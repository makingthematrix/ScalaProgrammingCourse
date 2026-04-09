import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}

class CustomFuture[T](f: => T)(using ec: ExecutionContext) {
  private var value: Option[Try[T]] = None

  ec.execute(() => { // can be also `new Runnable { ... }`
    val res = Try(f)
    value = Some(res)
    onCompleted.foreach(f => f(res))
  })

  def isCompleted: Boolean = value.isDefined

  private var onCompleted: List[Try[T] => Unit] = Nil
  def onComplete(f: Try[T] => Unit): Unit = {
    if (isCompleted)
      value.foreach(v => f(v))
    else
      onCompleted = f :: onCompleted
  }
}

object CustomFuture {
  import scala.concurrent.ExecutionContext.Implicits.global

  def main(): Unit = {
    val cf: CustomFuture[Int] = CustomFuture {
      Thread.sleep(1000L)
      1
    }
    cf.onComplete {
      case Failure(exception) => println(s"FAILURE: $exception")
      case Success(value) => println(s"value: $value")
    }

    Thread.sleep(2000L)
  }
}