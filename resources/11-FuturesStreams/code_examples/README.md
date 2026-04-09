# Referential Transparency

**Note**: You can run both versions of the example from your terminal, with `sbt run`.

We will finish the course with a module about Referential Transparency (RT, in short), a concept tightly connected to the idea of a pure function that we discussed before. A pure function operates only on its input parameters and has no side effects, i.e., the only result of the function call should be the value it returns. The function will not modify data in any data collection, write to a file, access any object it wasn't given a reference to in the form of an input parameter, etc.
Referential Transparency takes pure functions even one step further. For a function to be referentially transparent, it must hold that replacing the function call with the value it returns will not affect the program's behaviour.
Imagine that we have a case class of a protagonist, with their first and last name and their age:

```scala
case class Protagonist(firstName: String, lastName: String, age: Int)
```

and we have a function called `updateAge` that, for a given protagonist instance and a number, returns a copy of the protagonist with the updated age:

```scala
def updateAge(protagonist: Protagonist, n: Int): Protagonist =
  protagonist.copy(age = protagonist.age + n)
```

The function is pure. It operates only on its parameters, `protagonist` and `n`, and its only result is the value it returns, namely a new instance of the case class `Protagonist`. Referential Transparency holds as well. The code which looks like this:

``` scala
// program version #1
val protagonist = Protagonist("Jonas", "Kahnwald", 17)
val newProtagonist = updateAge(protagonist, 33) // returns Protagonist("Jonas", "Kahnwald", 50)
val newerProtagonist = updateAge(newProtagonist, 33) // returns Protagonist("Jonas", "Kahnwald", 83)
```

can be replaced with:

``` scala
// program version #2
val protagonist = Protagonist("Jonas", "Kahnwald", 17)
val newProtagonist = Protagonist("Jonas", "Kahnwald", 50)
val newerProtagonist = Protagonist("Jonas", "Kahnwald", 83)
```

and it won't change the program's behaviour. Also, the following program will behave the same:

```scala
// program version #3
val protagonist = Protagonist("Jonas", "Kahnwald", 17)
val newProtagonist = updateAge(protagonist, 33)
val newerProtagonist = updateAge(updateAge(protagonist, 33), 33)
```

The function call and the value are virtually interchangeable. But let's say we want to update the protagonist's age and print out that we made the update. We could do this only for debugging purposes or write it down in a file to track how the protagonist's age changes.

```scala
def updateAge(p: Protagonist, n: Int): Protagonist =
  val newAge = p.age + n
  println(s"The age of ${p.firstName} ${p.lastName} changes from ${p.age} to $newAge")
  p.copy(age = newAge)
```

Now, all three versions of the program still give use the same values for `protagonist`, `newProtagonist` and `newerProtagonist` but what we see in the logs is different:

```
// program version #1:
Age of Jonas Kahnwald changes from 17 to 50
Age of Jonas Kahnwald changes from 50 to 83
// program version #2:
[no logs]
// program version #3:
Age of Jonas Kahnwald changes from 17 to 50
Age of Jonas Kahnwald changes from 17 to 50
Age of Jonas Kahnwald changes from 50 to 83
```

What happened? Logging is a side-effect. Our new `updateAge` function is not pure, and so it is also not referentially transparent anymore. But does it mean we should avoid logging in Functional Programming? Of course not. If we think about it, logging is just the most evident and straightforward example of when side-effects are helpful. Reading from a file, writing to a file, displaying new information on the screen, asking the user for information and waiting for it, accessing and modifying a database, sending an HTTP request, generating a random number, or even caching a result of CPU-heavy computations - these are all side-effects. If we were to avoid them all, Functional Programming would be useless.

One way to overcome this conundrum is to apply the Berliner pattern (discussed in a previous chapter) or a similar strategy to divide the codebase into purely functional, and "effectful" parts. The pure-FP part will never perform side-effects alone but will delegate that role to non-pure-FP parts of your code. 

But this solution might feel insufficient. It means that there will always be a part of your code that is not as safe as it could be. Fortunately, there is a way to achieve referential transparency and the ability to perform effectful operations like the ones mentioned above simultaneously. We can do it with the IO monad and an effect system.

We discussed monads before and saw examples of a few simple ones: `Option`,` Either`, and Try. `Try` all hold some data inside and let us transform it by calling `flatMap` and other methods. The IO monad works precisely like that but holds the program as a value. That program is a list of pure and effectful operations we want to perform in order. We can add new operations to the list by calling methods on the IO monad. In other words, we may say that the IO monad lets us create a scenario of what we want our program to do. Instead of making the program perform all those operations immediately, we add them individually to the IO monad, creating a scenario that will be played out later.

An effect system is a framework in which we write our code. In it, we build our scenario in the IO monad, and when it's ready, we give the IO monad to the effect system to run it. It is an additional layer of abstraction between us and the execution of our program: instead of writing code that is executed by our machine, we write code, give it to the effect system, and the effect system runs it for us. This approach enables better separation of concerns (planning vs. execution), helps with testing and debugging, as pure functions are easier to reason about, and also makes it way easier to design logic that uses concurrency - both because pure functions are safe to call concurrently, and because the effect system supervises the execution of the program.

The effect system we will use in the following example is Cats Effect 3. In the example, we will use it not only for logging but also for reading and writing to the file, as well as asking the user for the value we will then use to update the protagonists' age. The example needs to be simple enough to be usable in the context of the course, and, as a result, it may look overengineered, as it requires some boilerplate. However, when you start to write larger projects in Cats Effect 3, the amount of boilerplate will stay similar or even diminish as you learn to write idiomatic Cats Effect code, while the advantages of using Cats Effect get more visible while the project grows.

## The example

Lets' start with the file. It's a short CSV (comma-separated values) file called `protagonists.csv`.

```csv
Jonas,Kahnwald,17
Hannah,Kahnwald,47
```

Feel free to add more protagonists to the file or modify their data.
To read the file, we will use Java NIO. The standard, non-RT way of doing it would look like this:

```scala
import java.nio.file.{Files, Path}
import scala.jdk.CollectionConverters.*

def read(path: Path): List[String] =
  Files.readAllLines(path).asScala.toList
```

When we call this version of the read method with a path to the CSV file, it reads its contents immediately and returns a list of lines. Let's rewrite it using Cats Effect:

```scala
import java.nio.file.{Files, Path}
import scala.jdk.CollectionConverters.*
import cats.effect.IO

def read(path: Path): IO[List[String]] =
  IO { Files.readAllLines(path).asScala.toList }
```

That's it: all we need to do is to wrap our file-reading logic in the IO monad. Now, when we call read, the file will not be read **yet**. Instead, the file-reading logic will be added to the scenario held in the monad. After we build the whole scenario, it will be executed only when we pass the monad to Cats Effect.

After reading the lines, we will map them to the `Protagonist` case class instances. We will use the `fromLine` method of the `Protagonist` companion object:

```scala
object Protagonist:
  def fromLine(line: String): Protagonist =
    val arr = line.split(",")
    Protagonist(arr(0), arr(1), arr(2).toInt)
```

This method is pure so there's no need to refactor it.

The next step will be to ask the user for the number with which we will update the age of our protagonists. Again, in its straightforward form, the code is not referentially transparent. Of course it's not: the user can give a different answer every time. But suppose we wrap the logic in the IO monad instead of immediately asking the user. In that case, we will only create an immutable value: an instance of the IO monad with the logic for asking the user inside it.

```scala
val askForUpdate: IO[Int] =
  for {
    _      <- IO.println("By how much should I update the age?")
    answer <- IO(scala.io.StdIn.readLine())
  } yield answer.toInt
```

Take a moment and look at what happens here. We get our answer in three steps. First, we want to print out the prompt. Since we don't want to do it immediately - but only add it to the scenario - instead of the standard `println`, we use a utility method of the IO monad. Then, we want to ask the user for the answer - again, not immediately, so we wrap the call to `readLine` with the IO monad, and at the end, we convert the answer, which comes as a string, to an integer. For the sake of simplicity, let's assume that the user will always give an answer that can be converted.

Note that since IO is a monad, we can connect all three steps using the Scala `for/yield` notation, just as we did in the previous chapters with `Option`, `Either`, and `Try`. We will stick to this notation in our example, but be aware that Cats Effect developers use a more idiomatic syntax. To learn more, visit [the Cats Effect webpage](https://typelevel.org/cats-effect/) and their Discord server.

Now that we have a list of protagonists and the number with which to update their age, we need to turn our `updateAge` function into a referentially transparent version.

```scala
def updateAge(p: Protagonist, n: Int): IO[Protagonist] =
    val newAge = p.age + n
    for {
      _       <- IO.println(s"The age of ${p.firstName} ${p.lastName} changes from ${p.age} to $newAge")
      updated =  p.copy(age = newAge)
    } yield updated
```

Now, we have to call our new `updateAge` function for every protagonist. But we can't just use `map` over a list of protagonists. `updateAge` returns `IO[Protagonist]` now, which means that if we mapped `List[Protagonist]` with it, we would get `List[IO[Protagonist]]`, while what we want is `IO[List[Protagonist]]`. Fortunately, Cats Effect provides us with an extension method called `traverse`.

```scala
import cats.syntax.all.*

val protagonists: List[Protagonist] = ...
val n: Int = ...
val updated: IO[List[Protagonist]] = protagonists.traverse(updateAge(_, n))
```

The only thing left to do is write the new data to the file. We serialize each protagonist using a `toLine` method on the `Protagonist` class.

```scala
case class Protagonist(firstName: String, lastName: String, age: Int):
  def toLine: String = s"$firstName,$lastName,$age"
```

To write to the file, we will again use Java NIO and wrap the code in the IO monad, just as we did when we read the data at the beginning.

```scala
def write(path: Path, lines: List[String]): IO[Unit] =
  IO { Files.writeString(path, lines.mkString("\n")) }
```

Finally, we need to join all the instances of the IO monad that our functions return and the calls to our pure functions. We will do it using the Scala `for/yield` notation. When that's done, we will have one IO monad holding the scenario we built:

- Read data from a CSV file
- Deserialize it
- Ask the user for the update
- Create an updated version of the data
- Write it down to the file again

```scala
import cats.effect.{IO, IOApp}
import cats.syntax.all.*

object CatsEffectVersion extends IOApp.Simple:
  override def run: IO[Unit] =
    for {
      lines        <- read(Protagonist.FilePath)
      protagonists =  lines.map(Protagonist.fromLine)
      n            <- askForUpdate
      updated      <- protagonists.traverse(updateAge(_, n))
      newLines     =  updated.map(_.toLine)
      _            <- write(Protagonist.FilePath, newLines)
    } yield ()
```

After the IO monad is built, we give it to Cats Effect to execute it. One way to do it is to make our main object extend the Cats Effect class `IOApp.Simple`, and implement its `run` method. Cats Effect then runs the method to obtain the IO monad that is, in turn, executed by the framework.

If you're curious, the example was inspired by a German sci-fi TV series, "Dark," in which protagonists travel through time often and meet older and younger versions of themselves.

Thank you.

