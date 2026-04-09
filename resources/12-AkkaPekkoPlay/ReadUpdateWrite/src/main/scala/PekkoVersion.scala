import PekkoVersion.Message.GreetOk
import org.apache.pekko.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors, TimerScheduler}
import org.apache.pekko.actor.typed.{ActorRef, ActorSystem, Behavior}

import java.nio.file.{Path, Paths}
import scala.concurrent.Await
import scala.concurrent.duration.{Duration, DurationInt}

object PekkoVersion {
  enum Message {
    case Start
    case Greet(ref: ActorRef[Message])
    case GreetOk(ref: ActorRef[Message])
    case ReadRequest
    case ReadAnswer(lines: List[String])
    case UpdateRequest
    case UpdateAnswer(n: Int)
    case WriteRequest(lines: List[String])
    case WriteOk
    case GoodBye
    case Shutdown
  }

  class PekkoSystem(context: ActorContext[Message], timer: TimerScheduler[Message])
    extends AbstractBehavior[Message](context){
    import Message.*

    private var readWriteActor = Option.empty[ActorRef[Message]]
    private var updateActor = Option.empty[ActorRef[Message]]

    private var protagonists = List.empty[Protagonist]
    private var n = 0

    private def checkAndUpdateAge(): Unit = if (protagonists.nonEmpty && n != 0) {
      val updated = protagonists.map(updateAge(_, n))
      val newLines = updated.map(_.toLine)
      readWriteActor.foreach(_ ! WriteRequest(newLines))
    }

    private def updateAge(p: Protagonist, n: Int): Protagonist = {
      val newAge = p.age + n
      context.log.info(s"The age of ${p.firstName} ${p.lastName} changes from ${p.age} to $newAge")
      p.copy(age = newAge)
    }

    override def onMessage(msg: Message): Behavior[Message] = msg match {
      case Start =>
        context.log.info("Start")
        val rwa = ReadWriteActor(context)
        readWriteActor = Option(rwa)
        rwa ! Greet(context.self)
        val ua = UpdateActor(context)
        updateActor = Option(ua)
        ua ! Greet(context.self)
        Behaviors.same
      case GreetOk(ref) if readWriteActor.contains(ref) =>
        context.log.info("GreetOk from ReadWriteActor")
        ref ! ReadRequest
        Behaviors.same
      case ReadAnswer(lines) =>
        context.log.info(s"ReadAnswer from ReadWriteActor ($lines)")
        protagonists = lines.map(Protagonist.fromLine)
        checkAndUpdateAge()
        Behaviors.same
      case GreetOk(ref) if updateActor.contains(ref) =>
        context.log.info("GreetOk from UpdateActor")
        ref ! UpdateRequest
        Behaviors.same
      case UpdateAnswer(n) =>
        context.log.info(s"UpdateAnswer from UpdateActor ($n)")
        this.n = n
        checkAndUpdateAge()
        Behaviors.same
      case WriteOk =>
        context.log.info("WriteOk from ReadWriteActor")
        readWriteActor.foreach(_ ! GoodBye)
        updateActor.foreach(_ ! GoodBye)
        timer.startSingleTimer(Shutdown, 2.seconds)
        Behaviors.same
      case Shutdown =>
        context.log.info("Shutdown!")
        context.system.terminate()
        Behaviors.stopped
    }
  }

  object PekkoSystem {
    def apply(): ActorSystem[Message] = {
      val behavior = Behaviors.withTimers[Message] { timer =>
        Behaviors.setup(context => new PekkoSystem(context, timer))
      }
      ActorSystem(behavior, "pekko-system") // no whitespace allowed in the system's name
    }
  }

  class ReadWriteActor(context: ActorContext[Message]) extends AbstractBehavior[Message](context) {
    import Message.{Greet, ReadRequest, ReadAnswer, WriteRequest, WriteOk, GoodBye}
    import java.nio.file.{Files, Path}
    import scala.jdk.CollectionConverters.*
    import ReadWriteActor.FilePath

    private var mainActorRef: Option[ActorRef[Message]] = None

    private def read(path: Path): List[String] = Files.readAllLines(path).asScala.toList
    private def write(path: Path, lines: List[String]): Unit = Files.writeString(path, lines.mkString("\n"))

    override def onMessage(msg: Message): Behavior[Message] = msg match {
      case Greet(ref) =>
        context.log.info(s"ReadWriteActor: Hello, main actor! I will save a reference to you")
        mainActorRef = Some(ref)
        ref ! GreetOk(context.self)
        Behaviors.same
      case ReadRequest =>
        context.log.info(s"ReadWriteActor: I received a read request")
        val lines = read(FilePath)
        mainActorRef.foreach(_ ! ReadAnswer(lines))
        Behaviors.same
      case WriteRequest(lines) =>
        context.log.info(s"ReadWriteActor: I received a write request ($lines)")
        write(FilePath, lines)
        mainActorRef.foreach(_ ! WriteOk)
        Behaviors.same
      case GoodBye =>
        context.log.info(s"ReadWriteActor: Goodbye")
        Behaviors.stopped
    }
  }

  object ReadWriteActor {
    private val FilePath: Path = Paths.get("resources/protagonists.csv")

    def apply(context: ActorContext[?]): ActorRef[Message] = {
      val behavior = Behaviors.setup(new ReadWriteActor(_))
      context.spawn(behavior, "read-write-actor")
    }
  }

  class UpdateActor(context: ActorContext[Message]) extends AbstractBehavior[Message](context) {
    import Message.{Greet, UpdateRequest, UpdateAnswer, GoodBye}
    private var mainActorRef: Option[ActorRef[Message]] = None

    private def askForUpdate(): Int = {
      printf("By how much should I update the age? ")
      val answer = scala.io.StdIn.readLine()
      answer.toInt
    }

    override def onMessage(msg: Message): Behavior[Message] = msg match {
      case Greet(ref) =>
        context.log.info(s"UpdateActor: Hello, main actor! I will save a reference to you")
        mainActorRef = Some(ref)
        ref ! GreetOk(context.self)
        Behaviors.same
      case UpdateRequest =>
        context.log.info(s"UpdateActor: I received an update request")
        val n = askForUpdate()
        mainActorRef.foreach(_ ! UpdateAnswer(n))
        Behaviors.same
      case GoodBye =>
        context.log.info(s"ReadWriteActor: Goodbye")
        Behaviors.stopped
    }
  }

  object UpdateActor {
    def apply(context: ActorContext[?]): ActorRef[Message] = {
      val behavior = Behaviors.setup(new UpdateActor(_))
      context.spawn(behavior, "update-actor")
    }
  }

  @main def main(): Unit = {
    import PekkoVersion.Message.Start

    println("Pekko Version Start")
    val system = PekkoSystem()
    system ! Start

    try {
      // Block the main thread until the system terminates
      Await.result(system.whenTerminated, Duration.Inf)
    } finally {
      println("Pekko Version Complete")
    }
  }
}

