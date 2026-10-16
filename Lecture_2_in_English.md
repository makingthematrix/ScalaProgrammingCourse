### New Project in IntelliJ IDEA

Hi, today we'll cover Scala basics: keywords, syntax, and fundamental concepts, similar to Java, C++, or Python. Knowledge of any of these languages should suffice.

Let's start with a new project called '`Trigonometry`.' The setup shows we could create a Git repository (though we won't today), select Scala as the language, and choose a build tool like SBT or Scala CLI. I'll use SBT.

For the JDK, we can choose any version - let's go with 25. Here we also select our SBT version. I will choose 2.0.10, the newest one, and the latest Scala version, 3.9.0.

Here on the right, we can download sources for both SBT and the compiler. Downloading SBT sources only makes sense if you're working on an SBT plugin. Downloading Scala sources can be helpful when using standard collections or other library classes, as having the source code will help with your work."

And one last thing: Significant Indentation Syntax, which I mentioned last week. Scala 3 offers two syntax options: Java-like (which I'll use today to avoid confusion) and Python-like (which I may discuss later). In Scala 2, only the braces syntax is available, so I thought it makes sense to stick to it, besides it should be a bit easier to read.

There are some advanced settings here but we don't need to use them. 'Add sample code' would create a simple main file, but let's disable that - I'll write it myself. The name is '`Trigonometry`'. IntelliJ has created a build.sbt configuration file with the information we provided and version 0.1.0 snapshot, which is fine.

Here in SBT we have build properties in the project directory with the current version. The src/main and test directories are created but currently empty. Double-clicking takes you to project structure, but there's nothing interesting for us yet. Let's create our first file: new, Scala class file, of type object, or simply a `Trigonometry` file.

### The main method

Ok, this is our main class. Let's create a basic main method. IntelliJ shows live templates here - when I type 'main', it finds the template. If I select it now, I'll get it immediately. 

```scala
@main def main(): Unit = { ... }
```

It starts with an annotation `@main`. Annotations in Scala work like those in Java: they carry additional information for the compiler, build tools, and also IDE. In this case, thanks to `@main` , IntelliJ IDEA knows that this is the start point for the program, and so it displays the "Run" icon next to it. The name of the method can be anything, here it's "main" too just to avoid confusion. 

Next, we have the `def` keyword for defining methods or functions. Scala follows the syntax  where the type of a given field, or the return type of a function is put at the end rather than how it is in Java: `returnType name(params)`. The difference might seem only aesthetically at first, but when we get to the topic of the type system, I hope you will see how this way makes more sense  somehow. 

Our `main` method has no parameters and the return type is `Unit`, which is equivalent to the Java's `void`.

Just to see how we can run the program, let's write `println("Hello, world")` and click "Run". The project is being compiled and then the "Run" window appears with the result. We can do the same from the terminal, without any IDE. In the project's main folder, we can first run `sbt` and then type `run` in the console, or we can simply type `sbt run`. 

### Values and variables

Let's start with something very simple:
```scala
val x = 1
val y = 2
val x2 = x + 1
println(x2)
```

`val` is how we declare an immutable value. If I try `x = x + 1`, that's an error. But I can do `val x2 = x + 1`, and then it's  fine. If I actually wanted a mutable variable, I'd need to use the keyword `var` , like this...

```scala
var x = 1
x = x + 1
```

 Now it works, `x` is actually mutable. Having this ability to make variables is sometimes useful,b ut idiomatically in Scala, we prefer immutability, that is, instead of modifying variables in place, we prefer to create new pieces of data as results of our calculations, while the original data stays as it was.

Same works with collections. There are mutable collections in Scala, and if I use one of them I can modify what elements it holds, but idiomatically I would rather use immutable collections, and instead of modifying them in place I would use transformations methods to create a new collection based on the old one and some logic that works on its elements.

### Classes and case classes

So we have `val` values, `var` variables, methods defined with` def`, and classes, defined with `class`. Here we will create a `Point` class with x and y of type Int, and now we can make `val p = Point(1, 2)`. 

```scala
class Point(val x: Int, val y: Int)
```

A class in Scala is basically the same as in Java, but field declaration differs. Here we have x and y fields. Instead of Java-style separate lines, we can declare them this way, simply in the constructor. For mutable fields, I could use `var` here. In Scala 3, constructors don't need the `new` keyword unless there's a need to distinguish the constructor from `apply` methods , sometimes called "smart constructors". We'll talk about them later.

Let's click 'Play' now, and... You should know this from Java too. Instead of displaying something meaningful, we get a reference id to and instance of the class `Point`. We can remedy it by overriding the `toString` method, again as in Java:

```scala
override def toString: String = s"Point($x, $y)"
```

The `override` keyword works like in Java. We're taking advantage the fact that every class in Scala, just like in Java, has a special super type `Object` which declares `toString`.

But we can do better. [01-03]

Long ago when people programmed in C (when mammoths roamed the earth), there were no classes, just data structures. A data structure simply declared what data was inside - that data could be other structures or pointers to them, or primitive types of specific kind and size. Then we had functions that took such a structure as a parameter and returned another - for example after some modifications it could return the same or another data structure. Functions and data structures were separate, but often the functions depended on the specific data structure.

We had sets of functions that worked well with specific data structures. In C++ (and not only - I'm simplifying, this isn't a programming history lesson), ideas emerged for classes, that is data structures that besides having fields also have methods that work on those fields. This exploded quickly: we started having classes that could be very complex, with many different methods for many different data types. We could override these methods, the concepts of abstract classes and interfaces emerged, data became public or protected or private. Generally, C++ still has a big mess in this regard. 

But if we look at how we actually use classes in production code in business applications, we'll see we actually have this on a spectrum: on one side classes that are mainly data structures with maybe some small set of specific simple methods, and on the other side managers, factories, builders, facades and so on.

These are classes that have little or no data. Often they only have references to instances of other classes, and have methods that simplify using those other classes. We have methods that reach through references to call methods on one instance, then send results to methods on other instances, and so on. 

In the middle, between these extremes, we have collections for example, which have quite a lot of data but can also have complex methods and deep hierarchies of abstract classes. In any case, we can see there was a need to have a separate language construct that clearly distinguishes data classes from logic classes.

And that's why concepts like case class emerged in Scala, in Kotlin (there we have data class), as well as for example in Rust (there we have structures again). Now, I can make `case class` `Point` and delete `val` from the front of field names. Every field in case case is a public value by default, the modifiers are needed only if we want something else. Also, I don't need to override `toString` anymore because case class already has a synthetical `toString`, as well as `hashCode`, `equals`, and a few other methods. Let's try it out.

```scala
case class Point(x: Int, y: Int) {
  def +(p: Point): Point = Point(x + p.x, y + p.y)
}

val p = Point(1, 2)
val q = p.copy(x = 3)
val r = p + q // p.+(q)
println(r)
```

The `copy` method is provided by the case class. It makes a copy of a given instance but also allows us to modify some of the fields. Then we define an operator `+` that returns a new point. Note that the fact we can write `p + q` is just synctatic sugar: Scala allows us to drop the dot and the parantheses if there's only one parameter. `+` is in fact a perfectly valid method name, just as `add` would be.

We can also check if p equals q. This shows false, but it's false not because these are references to different classes, as would be the case if they were instances of simple classes, but because they're different instances with different values. The `equals` method, `hashCode` and the `==` operator are also provided by the case class.

### apply and unapply 

```scala
object Point {
  def apply(z: Int): Point = new Point(z, z)

  def unapply(p: Point): (Int, Int) = (p.x, p.y) // or Option[(Int, Int)]
}
```



The `apply` method is what's called a smart constructor. We create it using a companion object - I can write companion object `Point` which will be associated with the `Point` case class. Now I can write an `apply` method that takes an Int parameter and returns Point(a). Now I can do `Point(5)`. What happened is that this called not the constructor directly, but called the `apply` method, which then called the constructor. There's also `def this` for secondary constructors, but we most often use the `apply` method.

The `apply` method defined here is rather artificial - all it does is call the constructor with both parameters equal to `z`. This is just to show you yhe special property of `apply`: it's called automatically when you use the class name and parameters within parentheses. The compiler checks if it should call `apply` with this data, so there's no need to write the name of the method `apply` explicitely. That's all there is to it. [85a-85d]

On the other hand, un`apply` is a bit more... maybe a bit less intuitive, but very useful in pattern matching. The `unapply` method takes a `Point` and returns a tuple of Ints. A tuple is like in Python - I can have a variable `t` equals to `(2, 3)` , for example, and that works too. Optionally (haha), an `unapply` may return an `Option` of some data structure. For now, you can think of an `Option` as a collection that may contain only 0 or 1 element. It's used in Scala idomatically instead of `null`. where there is a possibility that some computations may return no value. Here, we can always decompose a point into a tuple of integers, so we don't need to use `Option`, but there are many other situations where it's useful. We will talk about them later. 

Now, let's use that `unapply`:

```scala
val Point(rx, ry) = r
```



Ok, what happened here. This line works in reverse compared `val p = Point(5)`. There we had a constant `5` wrapped in a `Point` via `apply` method, creating a `Point` instance with x=5 and y=5. Here, we have the reference to `Point` r, and on the left side we declare constants rx and ry. Through destructuring q (by calling `unapply`), we get a tuple with rx and ry values.  This works because it's always possible to destructure a point into a tuple of integers. If it was not possible, we would get an exception. 

### private, protected, final, trait, abstract

I mentioned earlier that case class fields are always public. Actually, in Scala, fields of regular classes are too public by default. This might surprise you because in Java everything is private by default with encapsulation, and we use getters and setters to access or modify variables. In Scala, because everything is immutable, we assume by default that we can expose fields. No one can change the point's values, they're read-only, so exposing them is quite safe. It's when we want to hide something, then we need to use `private` or `protected`. It's also possible to write something like `private[<module name>]` which makes the given field public in the package scope, and private outside of it.

`protected` works as in Java. Classes can have subclasses and they can extend other classes or traits - that is, rough equivalents of Java interfaces. Let's write an example:

```scala
trait Shape {
  def centerPoint: Point
}

case class Rectangle(a: Point, b: Point) extends Shape

case class Triangle(a: Point, b: Point, c: Point) extends Shape

```



We define a trait `Shape` with one abstract method `centerPoint`, and two case classes that extend `Shape`. The trait here could also be an `abstract class`. The difference is that a class can extend only one abstract class but it can extend or decorate that abstract class with many traits. To do this, we would write `extends Shape with TraitA with TraitB` and so on. On the other hand, if we want to prevent a class from being extended, we may use the keyword `final`. By the way, case classes without `final` technically can be extended, but we don't do it simply by convention - case classes are supposed to be simple data structures.

As you can see, IntelliJ IDEA shows now squiggly red lines under Rectangle and Triangle. This is because we need to implement the `centerPoint` method for them. For a rectangle that's trivial, for a triangle it's only a bit more complicated:

```scala
case class Rectangle(a: Point, b: Point) extends Shape {
  override def centerPoint: Point = Point((a.x + b.x) / 2, (a.y + b.y) / 2) 
}

case class Triangle(a: Point, b: Point, c: Point) extends Shape {
  override def centerPoint: Point = Point((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3) 
}
```

Now we can do this:
```scala
println(r.centerPoint)
```

We can see a pattern here, right? To find a center point of a shape with more points, we need to find the averages of its x and y coordinates. Let's do that for a ComplicatedShape:

```scala
case class ComplicatedShape(points: Seq[Point]) extends Shape {
  override def centerPoint: Point = ... 
}
```

Let's ignore for now that not every sequence of points can be actually a shape. I just want to use this example to introduce you to the Scala collections library, and to functions as first-class citizens. 

By the way, almost any method in Scala (with some exceptions, but let's ignore that for now) can be declared `inline`, meaning that its implementation will be copy-pasted at the point of the call by the compiler, instead of actually calling that method. This way we gain some performance, because we don't make a call, but we pay for it by the bytecode size and also, often, by more memory being used. So, use it with caution.

### Collections and functions as first-class parameters

A `Seq` is in Scala a default immutable collection that keeps its elements in order. Thanks to this, we can iterate over them in the known order. Two main subclasses of `Seq` are `List` - a single-linked list - and a `Vector` that is, a more performant implementation that keeps inside an array or a sequence of arrays. There are also `Set`s and `Map`s. They are implemented as hash sets ans hash maps, but there are also alternative implementations of tree sets and tree maps. In their case, we don't care about the order but we can still iterate over the elements. The common super trait of all those collections is actually called `Iterable`. The type of the elements of a collection is put in the square brackets.

First, let's implement `centerPoint` in the Java-like way:

```scala
var pSum = Point(0)
for (p <- points) {
  pSum += p
}
Point(pSum.x / points.length, pSum.y / points.length)
```

We iterate over the `points` collection and add every point to a variable `pSum`, and then create a new point that consists of the average of all those points. One thing you may notice is that we don't use the `return` keyword - in Scala, the last expression of a function or method becomes automatically the value returned by that function. [10-10a] 

#### Expressions

And there's something nice about expressions instead of statements. Instead of sequential operations that change state, we have expressions where everything is passed via parameters and returned as result, with results flowing to next expressions. Here's a simple example: an even method in statement style that takes a number, checks if it's even, and immediately prints. This is imperative programming with line-by-line property checks and actions.

In functional programming in Scala and other languages, it's more idiomatic to split code into small expressions that each do one simple thing. For example, here we check if a number is even and return something - a String here, but it could be a boolean (just number % 2 == 0). The result is more flexible - it can be used in ways the original author didn't anticipate. Someone could use this event function elsewhere in the code months later, unlike the version that immediately prints to screen. Even better - because such expressions are values with types (takes int, returns String), this event can be flexibly passed as parameter and returned - functions can be returned from other functions too.



#### Functions

But there are at least two other ways to achieve the same result in Scala, without resorting to using `var`.

```scala
val px = points.map(p => p.x).sum / points.length
val py = points.map(p => p.y).sum / points.length
Point(px, py)

val pSum = seq.reduce { (p1, p2) => p1 + p2 }
Point(pSum.x / points.length, pSum.y / points.length)    
```

Scala collections comes with lots of methods capable of transforming the elements of the collections. They take a function as a parameter. It can be an anonymous function, like here, but a function in Scala is a first-class citizen, that is, it's a value with a type, just like any other data.

Normally we have data types like int, double, boolean, String, car - same as Java and Kotlin. We can also have references to literals, like an Iron Man String with value 'Tony Stark' of type String. We can have number 4 (int). We can have classes with references to literals and other complex types with their own literals or references. But we also have functions, like a multiplication function that takes x:int and y:int. This function takes these parameters, multiplies them, and returns an int. The function's type is its parameters and return type - that's the function type, like domain and codomain. These two ways of writing function types are equivalent.

Just as we had name, type and value for data, we have name, type and value for functions - the logic that executes when called. Like with other data types, we can create a class (or case class) and use this function as a value parameter, passing it to this Tony Stark case class with `mul` as the second parameter.

For example, I could do this:

```scala
    val addPoints: (Point, Point) => Point = (p1, p2) => p1 + p2
    val pFinal = seq.reduce(addPoints)
```

Now, `addPoints` is a reference to a function of the type `(Point, Point) => Point` whereas `(p1, p2) => p1 + p2` is its value. We can pass `addPoints` to any higher level function or method that accepts functions if this type as its parameters. 

The most important advantage is that this helps with type safety. Our types aren't just for fields and parameters - we can pass function types everywhere and use them to calculate new things from our data. This gives us built-in minimal documentation. We can see: okay, we have these parametes, and this function variable that takes themand returns something else. But we know the types, so we can understand what happens with the data even without looking at the implementation details.

The second important thing is that transforming collections of data this way helps functional programming with immutability. With immutable data, same input always gives same output. Immutable data is much easier to test, and we can better predict future calculation results. If the internal state of the program is mutable and our function relies on it, then two consecutive calls to the same functions with the same parameters might give us two different results. When the state is immutable - or even better, if we don't rely on the state, but only on immutable data we get through parameters, the function will always give the same result for the same parameters.

### if/else and match/case

One last thing I'd like to mention, now that we have a bit more code to use in the example, are the basics of pattern matching. Let's say I want to check if the points we created earlier fulfill certain requirements and if yes, then I want to log a message:

```scala
if (r == Point(1,2)) println("Matched point with specific coordinates")
else if (r == p) println("Matched point with same instance")
else if (r.y == 4) println(s"Matched point: (${r.x}, 4)")
else println("No match found")

```

This is pretty straightforward and similar to Java. In Scala though, we can take advantage of the powerful match/case syntax and the fact that we have synthetic `unapply` for `Point`:

```scala
r match {
  case Point(1,2)   => println("Matched point with specific coordinates")
  case _ if r == p  => println("Matched point with same instance")
  case Point(rx, 4) => println(s"Matched point: ($rx, 4)")
  case _            => println("No match found")
}
```

Every case here works as a check in if/else but it's possible to fit much more logic in that little space and it's still readable. For example, look to the third line: we check if `r` is a point with the `y` coordinate being `4`, and if yes, we take its `x` coordinate. We can match this `rx` against something else still, just as in the second `case` we check if the whole `r` is equals to `p`, but we may also use it on the right hand side of the match - here we do it to display the value. What's more:

```scala
  triangle match {
    case Triangle(Point(ax, ay), Point(bx, by), Point(cx, cy)) if ax == bx =>
      println(s"Triangle with matching vertices ax == bx: ($ax, $ay), ($bx, $by), ($cx, $cy)")
  }
```

You see, pattern matching is kind of recursive - maybe recursion isn't the right word, but if - in this case- we have a `Triangle` and it has its own `unapply`, then if it works and in return we get three points, we can use another unapply - because case class `Point` has unapply. At any level we can check if it matches the case we want to use. This really makes working with logic easier. If someone asked me about the most important feature in Scala, I'd say this is the most important practical feature in Scala.

By the way you can see that IntelliJ IDEA highlights the triangle in yellow and shows a warning "the match might not be exhaustive". Indeed, it is not. The first case will work only if ax is equal to bx. We lack a case for all other triangles, and both the Scala compiler and IntelliJ IDEA can detect that. To remedy that, I can simply let IntelliJ IDEA generate the last case:

```scala
case Triangle(_, _, _) => ???
```

It can look like this (`Triangle(_, _, _)`) . The underscore means that we don't care about the value in the given place, and the `???` is a way to say "this will be implemented later". The compiler will not complain about it but then it's up to us to make sure we will not get to this place when running the program. Otherwise we will get `NotImplementedError`.

The situation would be a bit different if instead of matching only triangles we decided to match any `Shape`. Consider this function:
```scala
def describe(shape: Shape): Unit = shape match {
  case Triangle(Point(ax, ay), Point(bx, by), Point(cx, cy)) if ax == bx =>
      println(s"Triangle with matching vertices ax == bx: ($ax, $ay), ($bx, $by), ($cx, $cy)")
  case t: Triangle => println(s"Some other triangle $t")
}
```

Now, we know that our shapes can be not only triangles but also rectangles and complicated shapes, but IntelliJ IDEA does not display the warning. This is because `Shape` is an open trait, that is, it is possible that at some other place in the codebase, or if we write a library then maybe even in the codebase of the user of our library, another developer will write a new subclass for `Shape`. So, it's not possible to the IntelliJ IDEA or the compiler to be sure what cases needed to be added.

To fix it, we should add `sealed` keyword to the trait. `sealed` means that all sub-traits and subclasses of that trait needs to be implemented in the same file. All the compiler needs to do is to analyze this single file to be able to make a list of all missing cases. It's called "exhaustive matching". We will talk more about in two or three lectures, on the one about advanced pattern matching.

### Outro

This is all for today. On the next lecture we will talk more about Scala collections methods and functions as parameters, generic types, laziness, and early returns.
