# FP in Scala lectures

Goals:

1. Introduce fundamental FP concepts 
2. Teach how Scala handles them
3. Show how IntelliJ Scala helps coding Scala

Concepts:

* Functions as Data
* Immutability
* Laziness
* Pattern Matching
* Expressions over Statements
* Safe Error Handling (with monads)
* Recursion
* Referential Transparency
* Type Safety [not included]
* Composition over Inheritance [not included and not FP]
* Early Returns [included but not FP :) ]

IntelliJ Scala features:

* Universal Apply methods [Scala 3]
* Enums support [Scala 3]
* Match types (https://dotty.epfl.ch/docs/reference/new-types/match-types.html) [Scala 3]
* Untupling parameters (https://docs.scala-lang.org/scala3/reference/other-new-features/parameter-untupling.html) [Scala 3]
* "Fewer braces" support [Scala 3]
* Full line completion [AI]
* Onboarding tips
* Compiler-Based Highlighting
* Inlay Hints and the X-Ray mode [the type system]
* Unused declaration [advanced editor]
* Can be private
* Type check can be replaced
* Collections inspections [collections]
* Monadic checks [monads]
* Option inspections [monads]
* Type inference [the type system]
* Automatic imports management
* Compilation charts
* The debugger
* ScalaDoc popups
* Sticky lines
* AI assistant
* New UI

---

**TEMAT WYDARZENIA:** Programowanie Funkcjonalne w Scali

**DATA I GODZINA WYDARZENIA:** 2024-08-26 20:00 (może być późniejszy termin; najlepiej  wieczór poniedziałek-piątek)

**SPOSÓB PROWADZENIA:** udostępnienie ekranu, kodowanie na żywo, interakcja z użytkownikami, pytania i odpowiedzi, zbieranie feedbacku

**OPIS WYDARZENIA:** Zawodowo zajmuję promocją języka programowania Scala oraz oprogramowania dla Scali tworzonego przez JetBrains (IntelliJ Scala Plugin). Pracuję teraz nad serią wykładów (ew. jednym bardzo długim) o programowaniu funkcyjnym w Scali. Wykłady są skierowane do ludzi, którzy coś już wiedzą o programowaniu, ale nie w Scali i nie Functional Programming. Najpierw wprowadzam podstawowe koncepcje, a potem na kilku nietrywialnych przykładach pokazuję jak wykorzystać je w praktyce. Przy okazji przykładów omawiam jak się koduje w Scali oraz jak IntelliJ Scala Plugin w tym kodowaniu pomaga. Chętnie zrobię taki jeszcze trochę niedopracowany wykład, postaram się odpowiedzieć na pytania i przy okazji zrobi kupę notatek co tu jeszcze jest niejasne, albo z czego może lepiej zrezygnować.

**BANER GRAFICZNY:** [opcjonalnie, ale ma się wyświetla w wym. min. 800x320px (proporcja 2:1)]^

---



### Part #1 - Introduction

1. Title, logo, introduce yourself
2. Agenda: Introduce main FP concepts, implement examples with Scala, showcase Scala plugin
3. Why FP? Discuss how FP concepts help each other
4. Why Scala? Discuss how the user can start with imperative code and move towards FP gradually, what is JVM, and how other programming languages compare to Scala
5. Why Scala Plugin? Discuss what is an IDE, what is the position of IntelliJ IDEA on the market, how Scala Plugin supports Scala. 
6. Learning materials: Talk about the Academy plugin, the interactive course, IntelliJ Scala Bundle + onboarding tips, and the most popular places in the internet to learn Scala (also the main Scala webpage)

### Part #2 - Functions as Data

Showcase: type inference, "Can Be Private" inspection, "Unused Element" inspection, enums import, method names suggestion (for collections), "remove expression" action for unused elements, match/case code completion (in fizzBuzz). Inlay hints and X-Ray.

1. What is a function
2. Anonymous functions
3. Passing functions as arguments
4. Case class
5. Scala collections: filter, find, foreach, map, flatMap, foldLeft
6. Total and partial functions (and traits)
7. Functions returning functions

### Part #3 - The type system and recursion

Showcase the debugger, enum suggestions, enum imports, match/case exhaustive, the recursion icon, "the recursive call requires the return type", "cannot rewrite recursive call in tail position".

1. Enums
2. Traits hierarchies, case objects
3. Unapply
4. Recursion
5. tailrec

Follow with using/given in Part #7.

### Part #4 - Early returns

Covers a more complicated example, generics, views & lazy collections.

Showcase "implement members" (with the ValidUser object extending the Deconstruct trait).

Showcase "replace if with filtered option".

1. find/map/collectFirst
2. Option
3. traits and generic parameters
4. lazy collections
5. breaking

Follow with lazy val / view / lazy list in Part #8

### Part #5 - Error handling

Showcase code completion for Option, Either and Try.

Showcase sbt version completion when adding org.typelevel %% cats-effecgt

1. try/catch in Java and Scala
2. Option / Either/ Try
3. Cooperation with Java through Try
4. for/yield syntax
5. Theoretical: What is a monad?

Leads directly to Part #6

### Part #6 - Referential Transparency

Showcase: this might be an opportunity to show off AI line completion when reading from and writing to CSV.

1. Theoretical: discuss RT
2. Discuss effect systems, mention Cats Effect and ZIO
3. Mention that this is a simple example which may looks as if the effect system adds more complexity than needed



### Part #7 - using/given basics



### Part #8 - lazy collections





In each case, think what features of Scala Plugin can be showcased.

---

## Introduction

This course is designed to introduce you to the fundamental concepts of functional programming using Scala as the language of instruction. Whether you're a complete beginner to Scala or have some experience under your belt, this course will equip you with the necessary skills to start writing functional programs effectively.

Throughout the course, you'll gain a solid understanding of key functional programming principles such as:

 - **Functions as Data**: Learn how to treat functions as first-class values, passing them around and manipulating them just like any other data type.
 - **Immutability**: Discover the power of immutability in functional programming, where data is never changed but rather transformed into new values.
 - **Pattern Matching**: Explore pattern matching techniques for concise and elegant code that handles different data structures and scenarios.

The course is packed with hands-on examples, exercises, and practical applications to help you solidify your understanding and apply your newfound knowledge to real-world problems. You'll also gain valuable insights into the "Berliner" pattern, a functional approach to complex programs, and learn how to leverage the Cats library for building robust functional applications.

By the end of this course, you'll be well on your way to becoming a confident functional programmer in Scala, equipped with the skills to write clean, maintainable, and expressive code.

So, are you ready to dive into the world of functional programming? Let's get started!

---

We invite you to join our course chat on Discord!

It's a great space to ask questions, engage with our instructors, and connect with your fellow students.

[Join Discord chat![img](http://localhost:63342/eduResources/icons/com/jetbrains/edu/learning/external_link_arrow@2x.png)](https://discord.gg/jpsDuV37bW)

---

## Functions as Data

### What is a function?

A function is a standalone block of code that takes arguments, performs some calculations, and returns a result. It may or may not have side effects; that is, it may access the data in the program, and if the data is modifiable, the function might alter it.  If it doesn't — meaning, if the function operates solely on its arguments — we state that the function is pure. In functional programming, we use pure functions whenever possible, although this rule does have important exceptions,which we will discuss later.

The main difference between a function and a method is that a method is associated with a class or an object. On the other hand, a function is treated just like any other value in the program: it can be created anywhere in the code, passed as an argument, returned from another function or method, etc.

Consider the following code:
```Scala

// A function defined with `def`
def addAsFunction(x: Int, y: Int): Int = x + y

// A function defined as a value
val addAsValue: (Int, Int) => Int = (x, y) => x + y

// A method associated with a class
class Calculator:
  def add(x: Int, y: Int): Int = x + y

```

Both `add` functions take two input parameters, `x` and `y`, perform a pure computation of adding them together, and return the result. They do not alter any external state. In the first case, we define a function with the `def` keyword. After `def` comes the function's name, then the list of arguments with their types, then the result type of the function, and then the function's calculations, that is, `x + y`.

Compare this with the second approach to define a function using the `val` keyword, which we also use for all other kinds of data. Here, after `val`, comes the function's name, followed by the type of the function, `(Int, Int) => Int`. This consists of both the argument types and the result type. Next come the arguments (this time without the types), and finally the implementation.  You will probably find the first way to define functions more readable, and you will use it more often. However, it is important to remember that in Scala, a function is treated as data, just like integers, strings, and instances of case classes — and it can be defined as data if needed.

The third example illustrates a method, which we simply call `add`. Its definition mirrors that of the `addAsFunction`, however, we refer to `add` as a method because it is associated with the `Calculator` class.In this way, if we create an instance of `Calculator`, we can call `add` on it, granting us access to the internal state of the instance. It is also possible, for example, to override it in a subclass of `Calculator`.

```scala
// An instance of the class Calculator. The instance has no internal state.
val calc = new Calculator
// We call add(1, 2) on calc. It returns 3 (1 + 2).
calc.add(1, 2)

// A subclass of Calculator that has an internal state: the integer n.
class CalculatorPlusN(n: Int) extends Calculator:
  // The overridden method `add` that adds n from the internal state to the result of addition.
  override def add(x: Int, y: Int): Int = super.add(x, y) + n

// An instance of CalculatorPlusN with an internal state, n == 3.
val calc3 = new CalculatorPlusN(3)
// We call add on calc3. It returns 6 (1 + 2 + 3)
calc3.add(1 , 2)

```
<div class="hint" title="See additional materials on the topic">

A blog post <a href="https://makingthematrix.wordpress.com/2020/12/15/programming-with-functions-2-functions-as-data">here</a>.

A video: 

<iframe width="560" height="315" src="https://www.youtube.com/embed/RX1_EJp9Vxk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
#### Exercise 

Implement multiplication both as a function and a value; additionally, implement multiplication as a method within a class.  

---

### Anonymous functions

An anonymous function is a function that, quite literally, does not have a name. It is defined only by its argument list and computations. Anonymous functions are also known as lambda functions, or simply lambdas.

Anonymous functions are particularly useful when we need to pass a function as an argument to another function, or when we want to create a function that is only used once and is not worth defining separately.

Here's an example:

```scala
// We create a sequence of numbers.
val numbers = Seq(1, 2, 3, 4, 5)

// We use the Seq.map method to double each number in the sequence by utilizing an anonymous function.
val doubled = numbers.map(x => x * 2)
```

Here, we create a sequence of `numbers` and we want to double each of them. To do that, we use the `map` method. We define an anonymous function `x => x * 2` and give it to the `map` method as its only argument. The `map` method applies this anonymous function to each element of `numbers` and returns a new list, which we call `doubled`, containing the doubled values.

Anonymous functions can access variables that are within scope at the time of their definition.
Consider the `multiplyList` function, which multiplies every number in a list by a `multiplier`. 
The parameter `multiplier` can be used inside `map` without any issues.  

```scala
def multiplyList(multiplier: Int, numbers: List[Int]): List[Int] =
  // We can use multiplier inside map 
  numbers.map(x => multiplier * x)

```

When a parameter is used only once in the anonymous function, Scala allows omitting the argument's name and using `_` instead.However, note that if a parameter is used multiple times, you must use names to avoid confusion. The Scala compiler will report an error if you fail to adhere to this rule. 

```scala
// We multiply each pair of numbers in a list using an anonymous function.
def multiplyPairs(numbers: List[(Int, Int)]): List[Int] = numbers.map((x, y) => x * y)

// Here we also multiply each pair of numbers in a list, but we omit parameters' names in the anonymous function.
// Scala associates the wildcards with the parameters in the order they are passed.  
def multiplyPairs1(numbers: List[(Int, Int)]): List[Int] = numbers.map(_ * _)

// We compute the square of each element in the list using an anonymous function. 
def squareList(numbers: List[Int]): List[Int] = numbers.map(x => x * x)

// In this case, omitting parameters' names is disallowed.
// You can see how it can be confusing if you compare it with `multiplyPairs1`. 
def squareList1(numbers: List[Int]): List[Int] = numbers.map(_ * _)
```

#### Exercise

Implement the `multiplyAndOffsetList` function, which multiplies and offsets each element in the list. Use `map` and an anonymous function. 

---

### Passing Functions as Arguments

We can pass a named function as an argument to another function just as we would pass any other value. This is useful, for example, when we want to manipulate data in a collection. There are many methods in Scala collections classes that operate by accepting a function as an argument and applying it in some way to each element of the collection. In the previous chapter, we saw how we can use the `map` method on a sequence of numbers to double them. Now let's try something different. Imagine that you have a bag of cats with different colors, and you want to separate out only the black cats.

```scala
// We model colors as enums.
enum Color:
 case Black
 case White
 case Ginger

// We model a cat as a class. In this example, we are interested only in the color of a cat.
class Cat(val color: Color)

// We create our bag (a set) of cats. Each cat has a different color.
val bagOfCats = Set(Cat(Color.Black), Cat(Color.White), Cat(Color.Ginger))

// We use the `filter` method to create a new bag of black cats.  
val bagOfBlackCats = bagOfCats.filter(cat => cat.color == Color.Black)
```

In Scala 3, we can use enums to define colors. Then, we create a class `Cat`, which includes a value for the color of the cat. Next, we create a "bag" of cats, which is a set containing three cats: one black, one white, and one ginger. Finally, we use the `filter` method and provide it with an anonymous function as an argument. This function takes an argument of the `Cat` class and returns `true` if the cat's color is black. The `filter` method will apply this function to each cat in the original set and create a new set containing only those cats for which the function returns `true`.

However, our function that checks if the cat is black doesn't have to be anonymous. The `filter` method will work just as well with a named function.

```scala
def isCatBlack(cat: Cat): Boolean = cat.color == Color.Black
val bagOfBlackCats = bagOfCats.filter(isCatBlack)
```

Passing a function as an argument to a method (or another function) can be useful when we want to apply the same logic to all elements in a collection, stream, or whatever the method operates on. This approach allows us to create more reusable and modular code.

So far, you've seen examples of how this is done with `map` and `filter` — two methods from Scala collections. In the forthcoming chapters, we will discuss other methods that can be called in a similar manner but perform different operations.

#### Exercise 

Implement a function to check whether the cat is white or ginger and pass it as an argument to `filter` to create a bag containing only white or ginger cats. 

---

### Scala Collections Overview

Scala collections comprise a vast set of data structures that offer powerful and flexible ways to manipulate and organize data. The Scala collections framework is designed to be both user-friendly and expressive, enabling you to perform complex operations with concise and readable code. To achieve this, numerous methods take functions as arguments.

Scala collections are divided into two main categories: mutable and immutable. Immutable collections cannot be altered post-creation but can be duplicated with modifications, while mutable collections permit in-place updates. By default, Scala encourages the use of immutable collections because they are simpler to reason with and can aid in preventing bugs caused by unanticipated side effects.

Here's an overview of the main traits and classes:
1. `Iterable`: All collections that can be traversed in a linear sequence extend `Iterable`. It provides methods like `iterator`, `map`, `flatMap`, `filter`, and others, which we will discuss shortly.
2. `Seq`: This trait represents sequences, i.e., ordered collections of elements. It extends `Iterable` and provides methods like `apply(index: Int): T` (which allows you to access an element at a specific index) and `indexOf(element: T): Int` (which returns the index of the first occurrence in the sequence that matches the provided element, or -1 if the element can't be found). Some essential classes implementing the `Seq` trait include `List`, `Array`, `Vector`, and `Queue`.
3. `Set`: Sets are unordered collections of unique elements. It extends `Iterable` but not `Seq` — you can't assign fixed indices to its elements. The most common implementation of `Set` is `HashSet`.
4. `Map`: A map is a collection of key-value pairs. It extends `Iterable` and provides methods like `get`, `keys`, `values`, `updated`, and more. It's unordered, similar to `Set`. The most common implementation of `Map` is `HashMap`.

We will now quickly review some of the most frequently used methods of Scala collections: `filter`, `find`, `foreach`, `map`, `flatMap`, and `foldLeft`. 
In each case, you will see a code example and be asked to do an exercise using the given method. 
Please note that there are many other methods available. We encourage you to consult the [Scala collections documentation](https://www.scala-lang.org/api/current/scala/collection/index.html) and browse through them. Being aware of their existence and realizing that you can use them instead of constructing your own logic may save a substantial amount of effort.

---

#### filter

`def filter(pred: A => Boolean): Iterable[A]`

The filter method works on any Scala collection that implements Iterable. It takes a predicate that returns true or false for every element in the collection, and it produces a new collection that comprises only the elements for which the predicate returns true. The filter method returns an empty collection if the predicate does not succeed on any element.

We have already used filter in a previous example, but for consistency, let's consider the example below one more time.

```scala
// We define the Color enum
enum Color:
  case Black, White, Ginger

// We define the Cat case class with two fields: name and color
case class Cat(name: String, color: Color)

// Let’s import the Color enum values for better readability
import Color._

// We create four cats: two black, one white, and one ginger
val felix    = Cat("Felix", Black)
val snowball = Cat("Snowball", White)
val garfield = Cat("Garfield", Ginger)
val shadow   = Cat("Shadow", Black)

// We put them all in a set
val cats = Set(felix, snowball, garfield, shadow)

// We filter the set to keep only black cats
val blackCats = cats.filter { cat => cat.color == Black } 
```

##### Exercise

In the exercises, we will be working with a more detailed representation of cats than in the lessons. 
Check out the `Cat` class in `src/Cat.scala`.
A cat has multiple characteristics: its name, breed, color pattern, and a set of additional fur characteristics, such as
`Fluffy` or `SleekHaired`.
Familiarize yourself with the corresponding definitions in other files in `src/`.

Imagine you've entered an animal shelter intending to adopt a cat.
There are multiple cats available, and you wish to adopt a cat with one of the following characteristics:

* The cat is calico.
* The cat is fluffy.
* The cat is of the Abyssinian breed.

To simplify decision making, you first identify all the cats that possess at least one of the characteristics above. Your task is to implement the necessary functions and then apply the filter. 

---

#### find

`def find(pred: A => Boolean): Option[A]`

Imagine that instead of filtering for all black cats, we are happy with obtaining just one, no matter which. We could use `filter` for that and then take the first cat from the resulting collection. However, `filter` will iterate through the entire original collection of cats, regardless of its size.
There are better solutions. For example, we can use the `find` method, which works precisely like `filter` but stops at the first matching element.

```scala
// We find the first black cat in the bag, if it exists
val blackCat: Option[Cat] = bagOfCats.find { cat => cat.color == Black }

val felixTheCat: Option[Cat] = bagOfCats.find { cat => cat.name == "Felix" }
```

Note that the `find` method returns an `Option`. For now, you can consider an `Option` as a special type of collection that holds either zero or one element. If the predicate we used returned `false` for every element in the collection, the `find` method would return an empty `Option` (also known as `None`). We will talk more about `Option` in one of the following chapters.

Also, while we are on the topic, check out the Scala documentation for methods such as `exists`, `forall`, and `contains`. These can be handy if you just want to check whether an element in the collection fulfills specific requirements (or, in the case of `forall`, whether all of them meet the requirements), but you are not interested in retrieving the matching element.

##### Exercise

Now, imagine that we are willing to adopt any cat from the animal shelter that is white and fluffy, or, say, any Persian cat with a calico coat. Implement the corresponding functions. Hint: Use the `contains` method to check if a cat is fluffy.

---

#### foreach

`def foreach[U](f: A => U): Unit`

The `foreach` method works on any Scala collection that implements `Iterable`. It takes a function `f` and applies it to each element in the collection. We assume that `f` performs side effects (we can ignore the `U` result type of the `f` function), and those side effects are what we seek. You can think of the `foreach` method as a simple for-loop that iterates over a collection of elements without altering them.

Note that in functional programming, we try to avoid side effects. In this course, you will learn how to achieve the same results functionally, but in the beginning, `foreach` can be helpful for displaying computing results, debugging, and experimentation.

In the following example, we will use `foreach` to print out the name and color of each of our four cats.

```scala
// We define the Color enum
enum Color:
 case Black, White, Ginger

// We define the Cat case class with two fields: name and color
case class Cat(name: String, color: Color)

// Let’s import the Color enum values for better readability
import Color._

// We create four cats: two black, one white, and one ginger
val felix    = Cat("Felix", Black)
val snowball = Cat("Snowball", White)
val garfield = Cat("Garfield", Ginger)
val shadow   = Cat("Shadow", Black)

// We put them all in a set
val cats = Set(felix, snowball, garfield, shadow)

// For each cat in the set, we print out their color and name
cats.foreach { cat =>
  println(s"This ${cat.color} cat is called ${cat.name}")
}
```

##### Exercise

Use `foreach` to print brief information about each cat. Run the `main` function to see the result. Feel free to experiment. Can you implement a function that prints out all characteristics of a cat, including `FurCharacteristics`? 

---

#### map

`def map[B](f: A => B): Iterable[B]`

The `map` method works on any Scala collection that implements `Iterable`. It takes a function `f` and applies it to each element in the collection, similar to `foreach`. However, in the case of `map`, we are more interested in the results of `f` than its side effects. As you can see from the declaration of `f`, it takes an element of the original collection of type `A` and returns a new element of type `B`. Finally, the `map` method returns a new collection of elements of type `B`. 

In a special case, `B` can be the same as `A`. So, for example, we could use the `map` method to take a collection of cats of certain colors and create a new collection of cats of different colors. But, we could also take a collection of cats and create a collection of cars with colors that match the colors of our cats.

```scala
// We define the Color enum
enum Color:
 case Black, White, Ginger

// Let's import the Color enum values for better readability
import Color._

// We define the Cat case class with two fields: name and color
case class Cat(name: String, color: Color)

// We define the Car case class with only one field: color
case class Car(color: Color)

// We create four cats: two black, one white, and one ginger
val felix    = Cat("Felix", Black)
val snowball = Cat("Snowball", White)
val garfield = Cat("Garfield", Ginger)
val shadow   = Cat("Shadow", Black)

// and we put them all in a list
val cats: List[Cat] = Set(felix, snowball, garfield, shadow)

// We define the catToCar function, which for a given cat creates a car with the same color
def catToCar(cat: Cat): Car = Car(color = cat.color)

// Using the map method and the catToCar function, we create a new list of cars with the same color as our cats
val cars: List[Car] = cats.map(catToCar)
```

Please note that in this example, we've placed our cats in a `List` rather than a `Set`. This is because we want to avoid confusion — for each cat, we want a car of a matching color. However, since we have two black cats of the same color, `Felix` and `Shadow`, our `catToCar` function will produce two identical black cars. Since a `Set` is a collection that holds only unique elements, one of them would have to be removed.Therefore, instead of a `Set`, we need a collection that allows multiple identical elements, like a `List`.

#####  Exercise 

In functional programming, we usually separate side effects from computations. For example, if we want to print all fur characteristics of a cat, we first transform each characteristic into a `String`, and then output each one in a separate step. Implement the `furCharacteristicsDescription` function, which completes this transformation using `map`. 

---

#### flatMap

`def flatMap[B](f: A => IterableOnce[B]): Iterable[B]`

You can consider `flatMap` as a generalized version of the `map` method. The function `f`, used by `flatMap`, takes every element of the original collection and, instead of returning just one new element of a different (or the same) type, produces a whole new collection of new elements. These collections are then "flattened" by the `flatMap` method, resulting in just one large collection being returned.

Essentially, the same effect can be achieved with `map` followed by `flatten`. `flatten` is another method from the Scala collections. If the original collection is a collection of collections — that is, if every element of it is a collection itself — the `flatten` method will combine them into one new collection.

However, the applications of `flatMap` extend far beyond this simplistic use case. It's probably the most crucial method in functional programming in Scala. We will talk more about this in later chapters about monads and chains of execution. For now, let's focus on a straightforward example to demonstrate how exactly `flatMap` works.

Just as in the `map` example, we will use a list of four cats. But this time, for every cat, we will create a list of cars of different brands but the same color as the cat. Finally, we will use `flatMap` to combine all four lists of cars of different brands and colors into one list.

```scala
// We define the Color enum
enum Color:
 case Black, White, Ginger

// We define the CarBrand enum
enum CarBrand:
 case Volkswagen, Mercedes, Toyota

// Let’s import the Color and CarBrand enum values for better readability
import Color._
import CarBrand._

// We define the Cat case class with two fields: name and color
case class Cat(name: String, color: Color)

// We define the Car case class with two fields: brand and color
case class Car(brand: CarBrand, color: Color)

// We create four cats: two black, one white, and one ginger
val felix    = Cat("Felix", Black)
val snowball = Cat("Snowball", White)
val garfield = Cat("Garfield", Ginger)
val shadow   = Cat("Shadow", Black)

// We put them all in a list
val cats = List(felix, snowball, garfield, shadow)

// We define a function that takes a cat and produces a list of cars
def catToCars(cat: Cat): List[Car] =
 List(
   Car(Volkswagen, cat.color),
   Car(Mercedes, cat.color),
   Car(Toyota, cat.color)
)

// And we use the flatMap method and the catToCars function to create a new list of all cars of all colors
val cars: List[Car] = cats.flatMap(catToCars)
```

##### Exercise 

Use `flatMap` to implement `collectFurCharacteristics`, which aggregates all fur characteristics of the cats into a single set. 

---

#### foldLeft

`def foldLeft[B](acc: B)(f: (B, A) => B): B`

The `foldLeft` method is another method in Scala collections that can be perceived as a generalized version of `map`, but generalized differently than `flatMap`. Let's say that we call `foldLeft` on a collection of elements of type `A`. `foldLeft` takes two arguments: the initial "accumulator" of type `B` (usually different from `A`) and a function `f`, which again takes two arguments: the accumulator (of type `B`) and the element from the original collection (of type `A`). `foldLeft` starts its work by taking the initial accumulator and the first element of the original collection and assigning them to `f`. The `f` function uses these two to produce a new version of the accumulator — i.e., a new value of type `B`. This new value, the updated accumulator, is again provided to `f`, this time together with the second element in the collection. The process repeats until all elements of the original collection have been iterated over. The final result of `foldLeft` is the accumulator value after processing the last element of the original collection.

The "fold" part of the `foldLeft` method's name derives from the idea that `foldLeft`'s operation might be viewed as "folding" a collection of elements, one into another, until ultimately, a single value — the final result — is produced. The suffix "left" indicates that in the case of ordered collections, we are proceeding from the beginning of the collection (left) to its end (right). There is also `foldRight`, which works in the reverse direction.

Let's see how we can implement a popular coding exercise, *FizzBuzz*, using `foldLeft`. In *FizzBuzz*, we are supposed to print out a sequence of numbers from 1 to a given number (let's say 100). However, each time the number we are to print out is divisible by 3, we print "Fizz"; if it's divisible by 5, we print "Buzz"; and if it's divisible by 15, we print "FizzBuzz". 

Here is how we can accomplish this with `foldLeft` in Scala 3:

```scala
def fizzBuzz(n: Int): Int | String = n match
 case _ if n % 15 == 0 => "FizzBuzz"
 case _ if n % 3  == 0 => "Fizz"
 case _ if n % 5  == 0 => "Buzz"
 case _ => n

// Generate a range of numbers from 1 to 100
val numbers = 1 to 100

// Use foldLeft to iterate through the numbers and apply the fizzBuzz function
val fizzBuzzList = numbers.foldLeft[List[Int | String]](Nil) { (acc, n) => acc :+ fizzBuzz(n) }

println(fizzBuzzList)
```

First, we write the `fizzBuzz` method, which takes an `Int` and returns either an `Int` (the number that it received) or a `String`: "Fizz", "Buzz", or "FizzBuzz". With the introduction of union types in Scala 3,we can declare that our method can return any one of two or more unrelated types. However, it is guaranteed that the return will be one of them.

Next, we create a range of numbers from 1 to 100 using `1 to 100`.

We call the `foldLeft` method on the numbers range, stating that the accumulator will be of the `List[String | Int]` type and that initially, it will be empty (`Nil`).

The second argument to `foldLeft` is a function that takes the current accumulator value (`acc`) and an element from the numbers range (`n`). This function calls our `fizzBuzz` method with the number and appends the result to the accumulator list using the `:+` operator.

Once all the elements have been processed, `foldLeft` returns the final accumulator value, which is the complete list of numbers and strings "Fizz", "Buzz", and "FizzBuzz", replacing the numbers that were divisible by 3, 5, and 15, respectively.

Finally, we print out the results.

##### Exercise 

Implement the following functions using `foldLeft`: 
* The `computeAverage` function, which computes the average of a list of numbers;
* The `maximum` function, which finds the maximum number in the list;
* The `reverse` function, which reverses the list.

---

### Total and partial function

We have already discussed how a function can be categorized as pure or impure. A pure function does not produce side effects; instead, it operates solely on its arguments and produces a result. Conversely, an impure function may induce side effects and draw input from contexts other than its arguments.

This chapter introduces another important distinction: a function can be either total or partial. A total function is one that is defined for all input values within its domain. In other words, it yields an output value for every possible input value. A total function never throws an exception or results in a runtime error arising from undefined input values. 

On the other hand, a partial function is only defined for a subset of its domain. In other words, it may not supply a valid output value for certain input values. When a partial function is applied to an undefined input value, it may throw an exception, induce a runtime error, or remain unevaluated.

For example, consider these two functions:
```scala
def multiply(x: Int, y: Int): Int = x * y
def divide(x: Int, y: Int): Int = x / y
```
The first one, `multiply`, is a total function: we can supply it with any two integers and it will return a valid output. In contrast, the `divide` function is partial: if we input 0 as the second argument, the function throws a `java.lang.ArithmeticException` because we just attempted to divide by zero. Additionally, if the result of the division is not an integer, `divide` will round it downwards.

Now, you might wonder, why should we use partial functions at all? Shouldn't we always try to write total functions? After all, in the code of the divide function above, we could first check if y equals 0, and return some special value. And indeed, this would be the right approach in many cases. But sometimes, a partial function can be useful. 

Consider the following example that employs the `collect` method from Scala collections:

```scala
enum Color:
 case Black, White, Ginger

import Color.*

trait Animal:
 def name: String
 def color: Color

case class Cat(name: String, color: Color) extends Animal
case class Dog(name: String, color: Color) extends Animal

// We create three instances of cats
val felix = Cat("Felix", Black)
val garfield = Cat("Garfield", Ginger)
val shadow = Cat("Shadow", Black)

// and two instances of dogs
val fido = Dog("Fido", Black)
val snowy = Dog("Snowy", White)

// We put all cats and dogs in a sequence of type Seq[Animal]
val animals: Seq[Animal] = Seq(felix, garfield, shadow, fido, snowy)

// Using the collect method, we create a new sequence containing only black cats
val blackCats: Seq[Cat] = animals.collect {
 case cat: Cat if cat.color == Black => cat
}
```
In this example, we first create an enum `Color` with three values: `Black`, `White`, and `Ginger`. We define a trait `Animal` with two abstract methods: `name` and `color`. We create case classes `Cat` and `Dog` that extend the `Animal` trait, and override the `name` and `color` methods with respective values. Then, we create three instances of `Cat` (two black and one ginger) and two instances of `Dog` (one black and one white). We consolidate all these instances into a sequence of type `Seq[Animal]`.

Ultimately, we use the `collect` method on the sequence to create a new sequence containing only black cats. The `collect` method applies a partial function to the original collection and constructs a new collection containing only the elements for which the partial function is defined. You can perceive it as the combination of the `filter` and `map` methods. In the above example, we provide `collect` with the following partial function:

```scala
case cat: Cat if cat.color == Black => cat
```
The `case` keyword at the beginning tells us that the function will provide a valid result only in the following case: the input value needs to be of the type `Cat` (not just any `Animal` from our original sequence), and the color of that cat needs to be `Black`. If these conditions are met, the function will return the cat, but as an instance of the type `Cat`, not just `Animal`. As a result, we can specify that the new collection created by the `collect` method is a sequence of the type `Seq[Cat]`.

#### Exercise 

Define a partial function `division` to handle division by 0. Use the `case` keyword with an appropriate check to do this. Then, use the `isDefinedAt` method to verify if the function is defined for its arguments.

---

### Functions returning functions

In Scala, it is possible to construct functions dynamically, inside functions and methods, and return them.This technique allows us to create new functions based on the arguments given to the original function and return them as the result of that function.

It’s particularly useful when we need to create specialized functions based on a common pattern or behavior.For example, consider the class `CalculatorPlusN` we wrote in the chapter "What is a function?". In that example, we created a class that took a number `n` in its constructor and then used that number in the method `add(x: Int, y: Int)` by adding it to the sum of `x` and `y`.

```scala
class CalculatorPlusN(n: Int) extends Calculator:
// The overridden method `add` adds `n` from the internal state to the result of the addition.
override def add(x: Int, y: Int): Int = super.add(x, y) + n
// An instance of `CalculatorPlusN` with the internal state, `n`, equal to 3.
val calc = new CalculatorPlusN(3)
// We call `add` on `calc`. It returns 6 (1 + 2 + 3)
calc.add(1 , 2)
```

Now, instead of having a class that stores this additional number `n`, we can create and return the `adder` function to achieve the same result:

```scala
// Define a function that takes a fixed number and returns a new function that adds it to its input
def addFixedNumber(n: Int): (Int, Int) => Int =
  def adder(x: Int, y: Int): Int = x + y + n
  adder
// Create a specialized function that adds 3 to its input
val add = addFixedNumber(3)
// We call add. It returns 6 (1 + 2 + 3)
add(1, 2)
```

In the above example, we define a function `addFixedNumber` that takes an integer `n` and returns a new function, which takes two integers, `x` and `y`, and returns the sum of `n`, `x`, and `y`. Note the return type of `addFixedNumber` — it's a function type `(Int, Int) => Int`. Then, we define the new function, `adder`, inside `addFixedNumber`, which captures the value of `n` and adds it to its own two arguments, `x` and `y`. The `adder` function is then returned as the result of `addFixedNumber`. We then construct a specialized function `add` by calling `addFixedNumber(n: Int)` with `n` equal to `3`.
Now, we can call `add` on any two integers; as a result, we will get the sum of these integers plus `3`.

Scala provides special syntax for functions returning functions, as shown below:  

``` scala
def addFixedNumber(n: Int)(x: Int, y:Int) = x + y + n

val add = addFixedNumber(3)
```

The first argument of the function `addFixedNumber` is enclosed within its own set of parentheses, while the second and third arguments are enclosed within another pair of parentheses. The function `addFixedNumber` can then be supplied with only the first argument, which creates a function expecting the next two arguments: `x` and `y`.  You can also call the function with all three arguments, but they should be enclosed in separate parentheses: `addFixedNumber1(3)(4, 5)` rather than `addFixedNumber(3,4,5)`. Notice that you cannot pass only two arguments into the function written in this syntax: `addFixedNumber1(3)(4)` is not allowed. 

#### Exercise 

Implement a function `filterList`, which returns another function. You can use the `filter` method in the implementation.

---

### Partial function application

Returning functions from functions is related to, but not the same as, [partial application](https://en.wikipedia.org/wiki/Partial_application). The former allows you to create functions that behave as though they have a "hidden" list of arguments provided at the moment of creation, rather than at the moment of use. Each function returns a new function that accepts the next argument until all arguments have been processed. The final function then returns the result.

On the other hand, partial function application refers to the process of assigning fixed values to some of a function's arguments and returning a new function that only takes the remaining arguments.
The new function is a specialized version of the original function with some arguments already provided. This technique enables code reuse — we can write a more generic function and then construct its specialized versions for use in various contexts.

Here's an example:

```scala
// Define a function that takes three arguments
def addN(x: Int, y: Int, n: Int) = x + y + n
// Partially apply the 'addN' function to set the last argument to 3
val add3 = addN(_: Int, _: Int, 3)
// Call the partially applied function with the remaining arguments
val result = add3(1, 2) // the result is 6 (1 + 2 + 3)
```

In the above example, we define a function `addN` that takes three arguments, `x`, `y`, and `n`, and returns their sum. We then partially apply the `addN` function to set the last argument to 3, using the `_` placeholder for the first two. This way, we create a new function, `add3`, which takes only two arguments, `x`, and `y`. Finally, we call `add3` with only two arguments, obtaining the same result as with the function returning a function from the previous chapter and the `CalculatorPlusN` example from the first task.

#### Exercise 

Implement a function `filterList`, which can then be partially applied. You can use the `filter` method in the implementation.

---

## Pattern Matching

Pattern matching is one of the most important features in Scala. It is so vital that we might risk saying it’s not just *a* feature of Scala, but *the* defining feature. It affects every other part of the programming language to the extent that it’s difficult to discuss any aspect of Scala without at least mentioning or using pattern matching in a code example. You have already seen it — the match/case statements, the partial functions, and the destructuring of instances of case classes.

In this lesson, we will explore case classes and objects, ways to construct and deconstruct them, enums, and a neat programming trick called the newtype pattern.  

---

### Case class

In Scala, a case class is a special kind of class that comes equipped with some useful default behaviors and methods, beneficial for modeling immutable data. While Scala's compiler does place some limitations on it, it concurrently enriches it with features that otherwise we would have to code manually:

1. Fields of a case class are immutable by default.  To make them mutable, they need to be explicitly marked as `var`, but this practice is frowned upon as highly  unidiomatic in Scala. Instances of case classes should serve as immutable data structures, as modifying them can result in less intuitive and readable code.
2. A case class provides a default constructor with public, read-only parameters, thus reducing the boilerplate associated with case class instantiation.
3. Scala automatically defines some useful methods for case classes, such as `toString`, `hashCode`, and `equals`. The `toString` method gives a string representation of the object, `hashCode` is used for hashing collections like `HashSet` and `HashMap`, and `equals` checks structural equality rather than reference equality. In other words, it checks the equality of the respective fields of the case class, rather than verifying if the two references point to the same object.
4. Case classes come with a `copy` method that can be used to create a copy of the case class instance. This can be exactly the same as the original or with some parameters modified (the signature of the `copy` method mirrors that of the default constructor).
5. Scala automatically creates a companion object for the case class, which contains factory `apply` and `unapply` methods. The `apply` method matches the default constructor and lets you create class instances without using the `new` keyword. The `unapply` method is used in pattern matching.
6. Case classes can be conveniently used in pattern matching, as they have the default `unapply` method, which lets you destructure the case class instance.
7. On top of that, case classes are conventionally not extended. 
   They can extend traits and other classes, but they shouldn't be used as superclasses for other classes. Technically though, extending case classes is not forbidden by default. If you want to ensure that a case class isn't extended, mark it with the `final` keyword.

You should already be familiar with some of these features, as we used them in the previous module. 
The difference here is that we want you to focus on distinct aspects that you'll see in the examples and exercises.

Below is a simple example of a case class that models cats.  We create a `Cat` instance called `myCat` and then use pattern matching on `Cat` to access its name and color.  

```scala 3
case class Cat(name: String, color: String)

val myCat = Cat("Whiskers", "white")
myCat match {
  case Cat(name, color) => println(s"I have a $color cat named $name.")
}
```

#### Exercise 

Create a case class that represents a dog. Each dog should have a name, a breed, and a favorite toy.
For the time being, model these features as Strings. Use pattern matching to introduce the dog. 

---

### Smart constructors

In Scala, `apply` is a special method that can be invoked without specifying its name.

```scala 3
class Cat:
  def apply(): String = "meow"

  val cat = Cat()
  cat() // returns "meow"
```

Technically, this sums it up — you can implement `apply` any way you want, for any purpose. However, by convention, `apply` is most popularly used as a smart constructor. This convention is very important, and we strongly advise adhering to it. 

There are a few other ways you can use `apply`. For example, the Scala collections library often employs it to retrieve data from a collection. This usage might appear as if Scala has traded the square brackets, common in more traditional languages, for parentheses:

```scala 3
val entry1 = listOfEntries(5) // listOfEntries: List[Entry]
val entry2 = listOfEntries.apply(5) // this is the same as above
```

This use is popular enough that people understand it when they see it. However, if you try to use it for something really different, you may make your code harder to read for other Scala developers.  The default expectation is that a pair of parentheses after a name indicates a call to a smart constructor. A smart constructor is a design pattern often used in functional programming languages. Its main purpose is to encapsulate the creation logic of an object, thus enforcing some constraints or rules whenever an instance of a class is created. For example, you can use it to ensure that the object is always created in a valid state.

This pattern can be especially useful in situations where:
* The construction of an object is complex and needs to be abstracted away.
* You want to control how objects are created and ensure they're always in a valid state.
* You need to enforce a specific protocol for object creation, such as caching objects, creating singleton objects, or generating objects through a factory. 

The idiomatic way to use `apply` as a smart constructor is to place it in the companion object of a class 
and call it by using the name of the class followed by a pair of parentheses. For example, let's consider the `Cat` class again, which has a companion object that includes an `apply` method:

```scala 3
class Cat private (val name: String, val age: Int)

object Cat:
  def apply(name: String, age: Int): Cat =
    if (age < 0) new Cat(name, 0)
    else new Cat(name, age)

  val fluffy = Cat("Fluffy", -5) // the age of Fluffy is set to 0, not -5
```

The `Cat` class has a primary constructor that takes a `String` and an `Int` to set the name and age of the new cat, respectively. Besides, we create a companion object and define the `apply` method in it. 
This way, when we later call `Cat("Fluffy", -5)`, the `apply` method, not the primary constructor, is invoked. In the `apply` method, we check the provided age of the cat, and if it's less than zero, we create a cat instance with the age set to zero, instead of using the input age.

Please also notice how we distinguish between calling the primary constructor and the `apply` method. When we call `Cat("Fluffy", -5)`, the Scala 3 compiler checks if a matching `apply` method exists. If it does, the `apply` method is called. Otherwise, Scala 3 calls the primary constructor (again, if the signature matches). This makes the `apply` method transparent to the user. If you need to call the primary constructor explicitly, bypassing the `apply` method, you can use the `new` keyword,for example, `new Cat(name, age)`. We use this trick in the given example to avoid endless recursion — if we didn't, calling `Cat(name, age)` or `Cat(name, 0)` would again trigger the `apply` method.

You might wonder how to prevent users from bypassing our `apply` method by calling the primary constructor `new Cat("Fluffy", -5)`. Notice that in the first line of the example, where we define the `Cat` class, there is a `private` keyword between the name of the class and the parentheses. The `private` keyword in this position means that the primary constructor of the `Cat` class can only be called by methods within the class or its companion object. This way, we can still use `new Cat(name, age)` in the `apply` method, since it is in the companion object, but it remains unavailable to the user.

#### Exercise 

Consider the `Dog` class, which contains fields for `name`, `breed`, and `owner`. Sometimes a dog gets lost, and the person who finds it may know as little about the dog as its name on the collar. Until the microchip is read, there is no way to know who the dog's owner is or what breed the dog is. 
To allow for the creation of `Dog` class instances in these situations, it's wise to use a smart constructor. We represent the potentially unknown `breed` and `owner` fields with `Option[String]`. 
Implement the smart constructor that uses `defaultBreed` and `defaultOwner` to initialize the corresponding fields.  

---

### Enums

An enumeration (or enum) is a type that represents a finite set of distinct values. Enumerations are commonly used to limit the set of possible values for a field, thus improving code clarity and reliability. Since a field cannot be set to something outside a small set of well-known values, we can make sure that the logic we implement handles all possible options and that there are no unconsidered scenarios.

In Scala 3, enumerations are created using the `enum` keyword. Each value of the enum is an object of the *enumerated type*. Scala 3 enums can also have parameterized values and methods. You have already seen this in our previous examples, where we used enums to define the colors for cat fur:

```scala 3
enum Color:
  case White, Black, Ginger
```

However, Scala 3 enums are even more powerful than that. In fact, they are more versatile than their counterparts in many other programming languages. Enums in Scala 3 can also be used as algebraic data types (also known as sealed trait hierarchies in Scala 2). You can have an enum with cases that carry different types of data. 

Here's an example:

```scala 3
enum Tree[+A]:
  case Branch(left: Tree[A], value: A, right: Tree[A])
  case Leaf(value: A)
  case Stump

/*
    3
   / \
  2   5
 /   / \
1   4   6
*/

import Tree.*

val tree: Tree[Int] =
  Branch(
    Branch(Leaf(1), 2, Stump),
    3,
    Branch(Leaf(4), 5, Leaf(6))
  )
```

In this example, `Tree` is an enum that models a binary tree data structure. Binary trees are used in many areas of computer science, including sorting, searching, and efficient data access. They consist of nodes, each of which can have at most two subtrees. Here, we implement a binary tree with an enum `Tree[A]`, which allows the nodes of the tree to be one of three possible kinds:
* a `Branch`, which has a value of type `A` and two subtrees, `left` and `right`,
* a `Leaf`, which has a value of type `A` but no subtrees, or
* a `Stump`, which models the end of the branch on a given side.

Please note that our implementation of a binary tree is slightly different from the classic one. 
You may notice that ours is a bit redundant: a `Leaf` is, in all practical senses, the same as a `Branch` where both subtrees are stumps. However, having `Leaf` as a separate enum case allows us to write the code for building the tree in a more concise way.

#### Exercise 

Implement a function that checks if a tree is balanced.

A balanced binary tree meets the following conditions:
* The absolute difference between the heights of the left and right subtrees at any node is no greater than 1.
* For each node, its left subtree is a balanced binary tree.
* For each node, its right subtree is a balanced binary tree.

For an extra challenge, try to accomplish this in a single pass. 

---

### Sealed Traits Hierarchies

Sealed  traits in Scala are used to represent restricted class hierarchies, providing exhaustive type checking. When a trait is declared as sealed, it can only be extended within the same file. This restriction enables the compiler to identify all subtypes, allowing for more precise compile-time checking.

With the introduction of enums in Scala 3, many use cases of sealed traits are now covered by enums, and their syntax is more concise. However, sealed traits are more flexible than enums — they  allow for the addition of new behaviors in each subtype. For instance, we can override the default implementation of a given method differently in each case class that extends the parent trait. In contrast, in enums, all cases share the same methods and fields.

```scala 3 
sealed trait Tree[+A]:
  def whoAmI: String

case class Branch[A](left: Tree[A], value: A, right: Tree[A]) extends Tree[A]:
  override def whoAmI: String = "I'm a branch!"

case class Leaf[A](value: A) extends Tree[A]:
  override def whoAmI: String = "I'm a leaf!"

case object Stump extends Tree[Nothing]:
  override def whoAmI: String = "I'm a stump!"
```

The code for creating the tree looks exactly the same:

```scala 3
import Tree.*

val tree: Tree[Int] =
  Branch(
    Branch(Leaf(1), 2, Stump),
    3,
    Branch(Leaf(4), 5, Leaf(6))
  )
```



#### Exercise 

Our trees are immutable, so we can compute their heights and check if they are balanced at the time of creation. To do this, we added the `height` and `isBalanced` members to the `Tree` trait declaration. 
The only thing that is left is to override these members in all classes that extend the trait in this exercise.  This way, no extra passes are needed to determine whether a tree is balanced.

Consider this as an exercise. 

---

### Case Objects

You might have noticed in the example of a binary tree implemented with sealed trait hierarchies that we used a *case object* to introduce the `Stump` type. In Scala, a case object is a special type of object that combines characteristics and benefits of both a case class and an object.

Similar to a case class, a case object comes equipped with a number of auto-generated methods like `toString`, `hashCode`,and `equals`, and they can be directly used in pattern matching. On the other hand, just like any regular object, a case object is a singleton, i.e., there's exactly one instance of it in the entire JVM. Case objects are used in place of case classes when there's no need for parametrization — when you don't need  to carry data yet still want to benefit from the pattern matching capabilities of case classes. In Scala 2, implementing a common trait using case objects was the default way of achieving enum functionality. This is no longer necessary in Scala 3, which introduced enums, but case objects are still useful in more complex situations.

For example, you may have noticed that to use case objects as enums, we make them extend a shared sealed trait.

```scala 3
sealed trait AuthorizationStatus

case object Authorized   extends AuthorizationStatus
case object Unauthorized extends AuthorizationStatus

def authorize(userId: UserId): AuthorizationStatus = ...
```

Here, `AuthorizationStatus` is a sealed trait, and `Authorized` and `Unauthorized` are the only two case objects extending it. This means that the result of calling the authorize method can be either `Authorized` or `Unauthorized`. There is no other response possible.

However, imagine that you're working on code that uses a library or module you no longer want to modify. In that case, the initial author of that library or module might have used case objects extending a non-sealed trait to make it easier for you to add your own functionality:

```scala 3
// original code
trait AuthorizationStatus

case object Authorized   extends AuthorizationStatus
case object Unauthorized extends AuthorizationStatus

def authorize(userId: UserId): AuthorizationStatus = ...

// our extension
case object LoggedOut extends AuthorizationStatus

override def authorize(userId: UserId): AuthorizationStatus =
  if isLoggedOut(userId) then
    LoggedOut
  else
    super.authorize(userId)
```

Here, we extend the functionality of the original code by adding a possibility that the user, despite being authorized to perform a given operation, encounters an issue and is logged out. Now they need to log in again before they are able to continue. This is not the same as simply being `Unauthorized`, so we add a third case object to the set of those extending `AuthorizationStatus`: we call it `LoggedOut`. If the original author had used a sealed trait to define `AuthorizationStatus` or had used an enum, we wouldn't have been able to do that.

#### Exercise 

We're modeling bots that move on a 2D plane (see the `Coordinates` case class). There are various kinds of bots (see the `Bot` trait), each moving a distinct number of cells at a time. Each bot moves in one of four directions (see the `Direction` trait). Determine whether the traits should be sealed or not and modify them accordingly.

Implement the `move` function. 

---

### Destructuring

Destructuring in Scala refers to the practice of breaking down an instance of a given type into its constituent parts. You can think of it as the inversion of construction. In a constructor or an `apply` method, we use a collection of parameters to create a new instance of a given type. When destructuring, we start with an instance of a given type and decompose it into values that, at least in theory, could be used again to create an exact copy of the original instance. Additionally, just as an `apply` method can serve as a smart constructor that performs certain complex operations before creating an instance, we can implement a custom method, called `unapply`, that intelligently deconstructs the original instance. It's a very powerful and expressive feature of  Scala, often seen in idiomatic Scala code.

The `unapply` method should be defined in the companion object. It usually takes the instance of the associated class as its only argument and returns an option of what’s contained within the instance. 
In the simplest case, this will just be the class's fields: one if there is only one field, or otherwise a pair, triple, quadruple, and so on. Scala automatically generates simple `unapply` methods for case classes. In such cases, `unapply` just breaks the given instance into a collection of its fields, as shown in the following example:

```scala 3
case class Person(name: String, age: Int)
val john = Person("John", 25)
// ...
val Person(johnsName, johnsAge) = john
println(s"$johnsName is $johnsAge years old.")
```

As you can notice, just as we don't need to explicitly write `apply` to create an instance of the `Person` case class, we also don't need to explicitly write `unapply` to break an instance of the `Person` case class back into its fields: `johnsName` and `johnsAge`.

However, you will not often see this way of using destructuring in Scala. After all, if you already know exactly which case class you have and you only need to read its public fields, you can do so directly — in this example, with `john.name` and `john.age`. Instead, `unapply` becomes much more valuable when used together with pattern matching.

Let's start by defining the `Color` enum and the `Cat` case class.

```scala 3
enum Color:
  case White, Ginger, Black

import Color.*
case class Cat(name: String, color: Color, age: Int)
```

Now, let's create five instances of `Cat`:

```scala 3
val mittens  = Cat("Mittens", Black, 2)
val fluffy   = Cat("Fluffy", White, 1)
val ginger   = Cat("Ginger", Ginger, 3)
val snowy    = Cat("Snowy", White, 1)
val midnight = Cat("Midnight", Black, 4)
```

We have two cats (Fluffy and Snowy) who are one year old, and three cats (Mittens, Ginger, and Midnight) who are older than one year.Next, let's put these cats in a `Seq`:

```scala 3
val cats = Seq(mittens, fluffy, ginger, snowy, midnight)
```

Finally, we can use pattern matching and destructuring to check the age of each cat and print out the appropriate message:

```scala 3
cats.foreach {
  case Cat(name, color, age) if age > 1 =>
    println(s"This is a $color adult cat called $name")
  case Cat(name, color, _) =>
    println(s"This is a $color kitten called $name")
}
```

In this code, we're using pattern matching to destructure each Cat object. We're also using a guard, `if age > 1`, to check the age of the cat. If the age is more than one, we  print out the message for adult cats. If the age is one or less, we print out the message for kittens. Note that in the second case expression, we're using the wildcard operator `_` to ignore the age value, since we don't need to check it — if a cat instance is destructured in the second case, it means that the cat's age was already checked in the first case and failed that test.

Also, if we need to handle a case where one of the fields has a specific constant value (unlike in the first case above, where any age greater than `1` is suitable), we can directly specify that value in place of the field:

```scala 3
cats.foreach {
  case Cat(name, _, 2) =>
    println(s"$name is exactly two years old")
  case Cat(name, color, age) if age > 1 =>
    println(s"This is a $color adult cat called $name")
  case Cat(name, color, _) =>
    println(s"This is a $color kitten called $name")
}
```

#### Exercise 

RGB stands for Red, Green, and Blue. It is a color model used in digital imagining 
that represents colors by combining intensities of these three primary colors. This allows electronic devicesto create a wide spectrum of colors. Sometimes, a fourth component called Alpha is also used to describe the transparency. Each component can be any integer withing the range `0 .. 255`, with `0` meaning no color,  and `255` representing the maximum color intensity. For example, the color red is represented when Red is `255`, while Green and Blue are `0`. 

In this exercise, implement the function `colorDescription`, which transforms a given RGB color into a string. It should deconstruct the color, examine the RGB components, and return the name of the color in case it is one of the following: `"Black", "Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "White"`.  Otherwise, it should just return the result of the `toString()` method. Please ignore the alpha channel when determining the color name. 

---

### Custom unapply

You can also implement a custom `unapply` method for both a regular class that lacks an automatically generated `unapply`, and for providing an additional way to destructure a case class. Here's an example of a custom `unapply` method for the `Cat` case class we defined in the previous chapter:

```scala 3
object Cat:
  def unapply(cat: Cat): (String, Int, String) =
    val ageDescription = if (cat.age < 2) "kitten" else "adult"
    (cat.name, cat.age, ageDescription)
```

Here, we've defined `unapply` that not only returns the name and age of the `Cat`, but also a description of the cat's age (`"kitten"` or `"adult"`). Now, we can use this custom `unapply` method in pattern matching:

```scala 3
val mittens = Cat("Mittens", 1)

mittens match
  case Cat(name, age, description) =>
    println(s"$name is a $description.")
    // This will print out "Mittens is a kitten."
```

Take note that our `unapply` works in all situations — regardless of the cat's age, deconstructing it produces a valid result. This is called the *Universal Apply Method*, a new feature in Scala 3. Previously in Scala 2, every `unapply` had to return an `Option` of the collection of fields produced during the destructuring. That `Option` would be `Some(...)` if the destructuring succeeded, or `None` if it failed. 
When could it fail? 

Imagine that we're developing a system for handling driver's licenses. In Germany, if you want to drive a standard car, you must be at least 18 years old. However, a license for a small motorcycle can be obtained at 16, and for a moped, the minimum age is 15. Therefore, we will create an enum for `VehicleType` and a class `Applicant`, which will include the name of the person applying for a driver's license, their age, and the vehicle type they want to drive:

```scala 3
enum VehicleType:
  case Car
  case SmallMotorcycle
  case Moped

class Applicant(name: String, age: Int, vehicleType: VehicleType)
```

Now, somewhere in our code, we have a sequence of all applicants, and we want to get the names of those who are eligible for a driver's license based on their age and the vehicle type they're applying to drive. Just as we did in the previous chapter when searching for cats older than one year, we could define a Universal Apply Method and use guards within pattern matching. However, instead of `foreach`, this time we will use `collect`:

```scala 3
object Applicant:
  def unapply(applicant: Applicant): (String, Int, VehicleType) =
    (applicant.name, applicant.age, applicant.vehicleType)

  val applicants: Seq[Applicant] = ???
  val names = applicants.collect {
    case Applicant(name, age, VehicleType.Car) if age >= 18 => name
    case Applicant(name, age, VehicleType.SmallMotorcycle) if age >= 16 => name
    case Applicant(name, age, VehicleType.Moped) if age >= 15 => name
}
```

However, since we're defining our own `unapply` method anyway in this example, we might as well incorporate the logic that checks if the applicant is eligible for a driver's license within it. This would return an `Option` of their name or `None`:

```scala 3
object Applicant:
  def unapply(applicant: Applicant): Option[String] = applicant.vehicleType match
    case VehicleType.Car if age >= 18 => Some(applicant.name)
    case VehicleType.SmallMotorcycle if age >= 16 => Some(applicant.name)
    case VehicleType.Moped if age >= 15 => Some(applicant.name)
    case _ => None

  val applicants: Seq[Applicant] = ???
  val names = applicants.collect {
    case Applicant(name) => name
}
```

As you can see, we've shifted the logic from the `collect` method to the `unapply` method. While this example does not necessarily make the code shorter or more readable, the ability to move the logic that checks if an entity is valid for a specific operation to a separate place in your codebase could prove valuable, depending on the situation.

#### Exercise 

Given that each component in the RGB range can only be between `0` and `255`, it only uses 8 bits. The 4 components of the RGB representation fit neatly into a 32-bit integer, which allows for better memory usage. Many color operations can be performed directly using bitwise operations on this integer representation. However, sometimes it's more convenient to access each component as a number, and this is where the custom `unapply` method may come in handy. 

Implement the `unapply` method for the int-based RGB representation. The alpha channel resides in the leading bits, followed by red, green, and then blue. 

---

### The Newtype Pattern

The *newtype pattern* in Scala is a way of creating new types from existing ones that are distinct at compile time but share the same runtime representation. This approach can be useful for adding more meaning to simple types, enforcing type safety, and avoiding mistakes.

For  example, consider a scenario where you are dealing with user IDs and product IDs in your code. 
Both IDs are of type `Int`, but they represent  completely different concepts. Using `Int` for both may lead to bugs  where you accidentally pass a user ID where a product ID was expected, or vice versa.  The compiler wouldn't catch these errors because both IDs are of the same type, `Int`.

With the newtype pattern, you can create distinct types for `UserId` and `ProductId` that wrap around `Int`, providing more safety:

```scala 3
case class UserId(value: Int) extends AnyVal
case class ProductId(value: Int) extends AnyVal
```

These are called value classes in Scala. `AnyVal` is a special trait in Scala — when extended by a case class that has only a single field, you're telling the compiler that you want to use the newtype pattern. The compiler uses this information to catch any bugs, such as confusing integers used 
for user IDs with those used for product IDs. However, at a later phase, it strips the type information from the data, leaving only a bare `Int`, so that your code incurs no runtime overhead. Now, if you have a function that accepts a `UserId`, you can no longer mistakenly pass a `ProductId` to it:

```scala 3
case class UserId(value: Int) extends AnyVal
case class ProductId(value: Int) extends AnyVal
case class User(id: UserId, name: String)

def getUser(id: UserId): User = ???
val userId = UserId(123)
val productId = ProductId(456)

// getUser(productId) is a compile error
val user = getUser(userId) // This is fine
```

In Scala 3, a new syntax has been introduced for creating newtypes using *opaque type aliases*, although the concept remains the same. The above example would look as follows in Scala 3:

```scala 3
object Ids:
  opaque type UserId = Int
  object UserId:
    def apply(id: Int): UserId = id

  opaque type ProductId = Int
  object ProductId:
    def apply(id: Int): ProductId = id

import Ids.*
case class User(id: UserId, name: String)

def getUser(id: UserId): User = ???
val userId = UserId(123)
val productId = ProductId(456)

// getUser(productId) is a compile error
val user = getUser(userId) // This is fine
```

As you can see, some additional syntax is required. Since an opaque type is essentially a type alias and not a case class, we need to manually define `apply` methods for both `UserId` and `ProductId`. Also, it's essential to define these methods within an object or a class — they cannot be top-level definitions. On the other hand, opaque types integrate very well with extension methods, another new feature in Scala 3. We will discuss this in more detail later.

#### Exercise 

One application of opaque types is expressing units of measure. For example, in a fitness tracker, users can input the distance either in feet or meters, based on their preferred measurement system. Implement functions for tracking distance in different units and a `show` function to display 
the tracked distance in the preferred units. 

---

## Immutability

### Scala collections instead of imperative loops

In the imperative programming style, you will often find the following pattern: a variable is initially set to some default value, such as an empty collection, an empty string, zero, or null. Then, step by step, initialization code runs in a loop to create the proper value. Beyond this process, the value assigned to the variable does not change anymore — or if it does, it’s done in a way that could be replaced by resetting the variable to its default value and rerunning the initialization. However, the potential for modification remains, despite its redundancy. Throughout the whole lifespan of the program, it hangs like a loose end of an electric cable, tempting everyone to touch it.

Functional programming, on the other hand, allows us to build useful values without the need for initial default values or temporary mutability. Even a highly complex data structure can be computed extensively using a higher-order function before being assigned to a constant, thus preventing future modifications. If we need an updated version, we can create a new data structure instead of modifying the old one.

Scala provides a rich library of collections — `Array`, `List`, `Vector`, `Set`, `Map`, and many others — 
and includes methods for manipulating these collections and their elements. You have already learned about some of these methods in the first chapter. In this chapter, you will learn more about how to avoid mutability and leverage immutability to write safer and sometimes even more performant code.



---

### Case Class Copy

In Scala, case classes automatically come equipped with a few handy methods upon declaration, one of which is the `copy` method. The `copy` method is used to create a new instance of the case class, which is a copy of the original one; however, you can also modify some (or none) of the fields during the copying process. This feature adheres to functional programming principles, where immutability is often favored. You can derive new instances while maintaining the immutability of existing ones. Consequently, this helps prevent bugs that may occur when two threads work on the same data structure, each assuming that it is the sole modifier of it.

Another valuable characteristic of the `copy` method is that it’s a convenient and readable means of creating new instances of the same case class. Instead of building one from scratch, you can grab an existing instance and make a copy modified to your liking.

Below, you will find a Scala example using a User case class with mandatory `firstName` and `lastName` fields, along with optional `email`, `twitterHandle`, and `instagramHandle` fields. 
We will first create a user with its default constructor and then generate another user with the `copy` method from the first one. 

Note that:

* `originalUser` is initially an instance of `User` with `firstName = "Jane"`, `lastName = "Doe"`, and `email = "jane.doe@example.com"`. 
  The other fields use their default values (i.e., `None`).
* `updatedUser` is created using the `copy` method on `originalUser`. 
  This creates a new instance with the same field values as `originalUser`, except for those provided as parameters to `copy`:
   * `email` is updated to `"new.jane.doe@example.com"`
   * `twitterHandle` is set to `"@newJaneDoe"`
* `originalUser` remains unmodified after the `copy` method is used, adhering to the principle of immutability.

``` scala 3
case class User( firstName: String,
                 lastName: String,
                 email: Option[String] = None,
                 twitterHandle: Option[String] = None,
                 instagramHandle: Option[String] = None
               )

// usage
val originalUser = User("Jane", "Doe", Some("jane.doe@example.com"))

// Create a copy of originalUser, changing the email and adding a twitter handle
val updatedUser = originalUser.copy(
  email = Some("new.jane.doe@example.com"),
  twitterHandle = Some("@newJaneDoe")
)

println(s"Original user: $originalUser")
// prints out User("Jane", "Doe", Some("jane.doe@example.com"), None, None)

println(s"Updated user: $updatedUser")
// prints out User("Jane", "Doe", Some("new.jane.doe@example.com"), Some("@newJaneDoe"), None)
```

#### Exercise 

Let's unravel the `copy` function. Implement your own function, `myCopy`, which operates identically to `copy`. You should be able to pass values only for those fields that you wish to modify.  As a result, a new copy of the instance should be created. 

---

### The Builder Pattern

The builder pattern is a design pattern often used in object-oriented programming to provide 
a flexible solution for constructing complex objects. It's especially handy when an object needs to be created with numerous possible configuration options. The pattern involves separating the construction of a complex object from its representation so that the same construction process can yield different representations.

Here's why the builder pattern is used:
* To encapsulate the construction logic of a complex object.
* To allow an object to be constructed step by step, often through method chaining.
* To avoid having constructors with many parameters, which can be confusing and error-prone (often referred to as the telescoping constructor anti-pattern).

Below is a Scala example using the builder pattern to create instances of a `User` case class, with mandatory `firstName` and `lastName` fields and optional `email`, `twitterHandle`, and `instagramHandle` fields.

Note that:
* The `User` case class defines a user with mandatory `firstName` and `lastName` fields, along with optional `email`, `twitterHandle`, and `instagramHandle` fields.
* `UserBuilder` facilitates the creation of a `User` object, with
  mandatory parameters specified in the builder's constructor. Methods like `setEmail`, `setTwitterHandle`, 
  and `setInstagramHandle` are available to set optional parameters. 
  Each of these methods returns the builder itself, enabling method chaining.
* Finally, the execution of the `build` method employs all specified parameters (whether default or set) to construct a `User` object.

This pattern keeps the process of object creation clear and straightforward, particularly when dealing with objects possessing multiple optional parameters.

```scala 3
case class User( firstName: String,
                 lastName: String,
                 email: Option[String] = None,
                 twitterHandle: Option[String] = None,
                 instagramHandle: Option[String] = None
               )
               
class UserBuilder(private val firstName: String, private val lastName: String):
  private var email: Option[String] = None
  private var twitterHandle: Option[String] = None
  private var instagramHandle: Option[String] = None
  
  def setEmail(e: String): UserBuilder =
    email = Some(e)
    this

  def setTwitterHandle(t: String): UserBuilder =
    twitterHandle = Some(t)
    this

  def setInstagramHandle(i: String): UserBuilder =
    instagramHandle = Some(i)
    this

  def build: User =
    User(firstName, lastName, email, twitterHandle, instagramHandle)

  // usage
  val user: User = new UserBuilder("John", "Doe")
    .setEmail("john.doe@example.com")
    .setTwitterHandle("@johnDoe")
    .setInstagramHandle("@johnDoe_insta")
    .build
   
  println(user)
  // prints out User("John", "Doe", Some("john.doe@example.com"), Some("@johndoe"), Some("@johnDoe_insta"))
```

#### Exercise

Implement the builder pattern for constructing a message that has optional sender, receiver, and content fields. 

---

### Lazy Val

**Laziness** refers to the deferral of computation until it is necessary. This strategy can enhance performance and allow programmers to work with infinite data structures, among other benefits.
With a lazy evaluation strategy, expressions are not evaluated when bound to a variable, but rather when used for the first time. If they are never used, they are never evaluated. In some contexts, lazy evaluation can also prevent exceptions by avoiding the evaluation of erroneous computations.

In Scala, the keyword `lazy` is used to implement laziness. When `lazy` is used in a `val` declaration, the initialization of that `val` is deferred until it's first accessed. Here’s a breakdown of how `lazy val` works internally:

* **Declaration**: When a `lazy val` is declared, no memory space is allocated for the value, and no initialization code is executed.
* **First access**: Upon the first access of the `lazy val`, the expression on the right-hand side of the `=` operator is evaluated, and the resultant value is stored. This computation generally happens in a thread-safe manner to avoid potential issues in a multi-threaded context. There’s a check-and-double-check mechanism to ensure the value is computed only once, even in a concurrent environment.
* **Subsequent accesses**: During any subsequent accesses, the previously computed and stored value is returned directly, without re-evaluating the initializing expression.

Consider the following example:

```scala 3
lazy val lazyComputedValue: Int = {
  println("Computing...")
  // Some heavy computation
  Thread.sleep(1000)
  42  // Computed value
}

val timeOffset = System.currentTimeMillis

def now = System.currentTimeMillis - timeOffset

println(s"lazyComputedValue declared at $now.")
// The value is computed and printed only when it's accessed for the first time.
println(s"Accessing: $lazyComputedValue")
println(s"time now is $now") // takes more than 1000 milliseconds
// This time, it's not computed but fetched from memory.
println(s"Accessing again: $lazyComputedValue")
println(s"time now is $now") // should take only a few milliseconds at most
```

In the above code:
* The `lazy val lazyComputedValue` is declared but not computed immediately upon declaration.
* Once it is accessed in the first `println` statement that includes it, the computation is executed, `"Computing..."` is printed to the console, and the computation (here simulated with `Thread.sleep(1000)`) takes place before the value `42` is returned.
* Any subsequent accesses to `lazyComputedValue`, like in the second `println` statement, do not trigger the computation again. The stored value (`42`) is used directly.

---

### Lazy List

A lazy list in Scala is a collection that evaluates its elements lazily, with each element computed just once, the first time it is needed, and then stored for subsequent access. Lazy lists can be infinite, with their elements computed on-demand. Hence, if your program keeps accessing the next element in a loop, the lazy list will inevitably grow until the program fails with an out-of-memory error. In practice, however, you will likely need only a finite number of elements.While this number might be large and unknown from the start, the lazy list will compute only explicitly requested values, enabling developers to work with large datasets or sequences in a memory-efficient manner. In such cases, a lazy list provides a convenient method to implement the logic for computing consecutive elements until you decide to stop. 

You can use it in certain specific cases where you would otherwise need to code an elaborate data structure with mutable fieldsand a method to compute new values for those fields.


Below is an example of how to generate a Fibonacci sequence using a lazy list in Scala:

```scala 3
lazy val fib: LazyList[BigInt] =
  BigInt(0) #::
    BigInt(1) #::
    fib.zip(fib.tail).map { case (a, b) => a + b }

// Fetch and print the first 10 Fibonacci numbers
fib.take(10).foreach(println)
```

In the above code:
* `#::` is an operator that creates a new lazy list with a specified head (the element in front of the operator) and a tail (the lazy list after the operator).  We start with `BigInt(0)` as the head, and the expression after `#::` becomes the tail. Now, this tail comprises a head (`BigInt(1)`) and another tail linked with the `#::` operator. This second "internal" tail is constructed with the `zip` method operating on the original lazy list, `fib`. It is possible to access `fib` from this point in the code because the list is lazy — the expression will not be evaluated immediately upon the lazy list's construction, but only later when `fib` already exists and we want to access one of its elements.
* `fib.zip(fib.tail)` takes two sequences, `fib` and its tail (i.e., `fib` without its first element), and zips them together into pairs. The Fibonacci sequence is generated by summing each pair `(a, b) => a + b` of successive Fibonacci numbers.
* `take(10)` is used to fetch the first 10 Fibonacci numbers from the lazy list, and `foreach(println)` prints them out. Note that the Fibonacci sequence is theoretically infinite, but this doesn't cause any issues or out-of-memory errors (at least not yet), thanks to lazy evaluation.
* Alternatively, you can use `takeWhile` to compute consecutive elements of the lazy list until a certain requirement is fulfilled.
* The methods opposite to `take` and `takeWhile` — `drop` and `dropWhile` — can be used to compute and then ignore a certain number of elements in the lazy list or to compute and ignore elements until a certain requirement is met. These methods can be chained together. For example, `fib.drop(5).take(5)` will compute the first 10 elements of the Fibonacci sequence but will disregard the first 5.

To learn more about the methods of Scala's `LazyList`, read the [documentation](https://www.scala-lang.org/api/current/scala/collection/immutable/LazyList.html).

#### Exercise 

Implement a function that generates an infinite lazy list of prime numbers in ascending order. Use the Sieve of Eratosthenes algorithm.

---

### A View

A view in Scala collections is a lazy rendition of a standard collection. While a lazy list needs intentional construction, you can create a view from any "eager" Scala collection simply by calling `.view` on it. A view computes its transformations (like map, filter, etc.) in a lazy manner, meaning these operations are not immediately executed; instead, they are computed on the fly each time a new element is requested. This can enhance both performance and memory usage. On top of that, with a view, you can chain multiple operations without the need for intermediary collections — the operations are applied to the elements of the original "eager" collection only when requested. This can be particularly beneficial in scenarios where operations like map and filter are chained, so a significant number of elements can be filtered out, eliminating the need for subsequent operations on them.

Let's consider an example where we use a view to find the first squared even number in a list that is greater than 100.

```scala 3
val numbers = (1 to 100).toList

// Without using view
val firstEvenSquareGreaterThan100_NoView = numbers
  .map(n => n * n)
  .filter(n => n > 100 && n % 2 == 0)
  .head
println(firstEvenSquareGreaterThan100_NoView)


// Using view
val firstEvenSquareGreaterThan100_View = numbers.view
  .map(n => {
    println(s"Square of $n being calculated.")  // To observe the lazy evaluation
    n * n
  })
  .filter(n => n > 100 && n % 2 == 0)
  .head
println(firstEvenSquareGreaterThan100_View)
```


Without using a view, all the numbers in the list are initially squared and then filtered, even though we are only interested in the first square that satisfies the condition. With a view, transformation operations are computed lazily. Therefore, squares are calculated and conditions are checked sequentially for each element until the first match is found. This avoids unnecessary calculations and hence is more efficient in this scenario.

To learn more about the methods of Scala `View`, read its [documentation](https://www.scala-lang.org/api/current/scala/collection/View.html).

#### Exercise 

Consider a simplified log message: it is a comma-separated string where the first substring before the comma specifies its severity, the second substring is the numerical error code, and the last one is the message itself.  Implement the function `findLogMessage`, which searches for the first log message matching a given `severity` and `errorCode` within a list. As the list is assumed to be large, utilize `view` to avoid creating intermediate data structures. 

---

### View vs Lazy Collection

Now you may be wondering why Scala has both lazy lists and views, and when to use which one.
Here's a short list highlighting the key differences between these two approaches to lazy computation:

* Construction:
  * View: You can create a view from any Scala collection by calling `.view` on it.
  * Lazy List: You must create it from scratch with the `#::` operator or other specific methods.
* Caching:
  * View: It does not cache results. Each access recomputes values through the transformation pipeline unless forced into a concrete collection.
  * Lazy List: Once an element is computed, it is cached for future access to prevent unnecessary recomputation.
  
* Commonly used for:
  * View: Perfect for chaining transformations on collections when we want to avoid creating intermediate collections.
  * Lazy List: Ideal for working with potentially infinite sequences and when previously computed results might be accessed multiple times.


Below, you will find an example comparing both approaches. Run it, see the results, and experiment with the code. Use the debugger and breakpoints between chained operations to see how intermediate results differ between an eager collection, a view, and a lazy list.

```scala 3
val numbers = 1 to 1000

// using a standard, eager collection
val eagerResult = numbers
  .map(n => n * n)  // Squaring operation
  .filter(n => n % 2 == 0)  // Filtering even numbers
  .take(5)  // Taking first 5
  .toList  // Forcing evaluation

// Using view
val viewResult = numbers.view
  .map(n => n * n)  // Squaring operation
  .filter(n => n % 2 == 0)  // Filtering even numbers
  .take(5)  // Taking first 5
  .toList  // Forcing evaluation

println(s"View Result: $viewResult")

// Using LazyList
lazy val lazyListResult: LazyList[Int] = numbers.to(LazyList)
  .map(n => n * n)
  .filter(n => n % 2 == 0)
  .take(5)

println(s"LazyList Result: ${lazyListResult.toList}")
```



---

### The Berliner pattern

In functional programming, data rarely needs to be mutable. Theoretically, it is possible to completely avoid mutability, especially in such programming languages as Haskell. However, this might feel cumbersome and unnecessarily complicated to many coders. Thankfully, you can get the best of both worlds with the languages that combine functional and imperative programming. In particular, Scala was specifically designed with this fusion in mind. 

The Berliner Pattern is an architectural pattern introduced by Bill Venners and Frank Sommers at Scala Days 2018 in Berlin. Its goal is to restrict mutability to only those parts of a program where it is unavoidable. The application can be thought of as being divided into three layers: 

* The external layer, which has to interact with the outside world, enabling the application to communicate with other programs, services, or the operating system. It's practically impossible to implement this layer in a purely functional way, but the good news is that there is no need to do so. 
* The internal layer, where we connect to databases or write to files. This part of the application is usually performance-critical, so it's only natural to use mutable data structures here. 
* The middle layer, which connects the previous two. This is where our business logic resides and where functional programming shines. 
  

Pushing mutability to the thin inner and outer layers offers several benefits. First of all, the more we restrict data, the more future-proof our code becomes. We not only provide more information to the compiler, but we also signal to future developers that some data should not be modified.

Secondly, it simplifies the writing of concurrent code. When multiple threads can modify the same data, we may quickly end up in an invalid state, making it complicated to debug. There is no need to resort to mutexes, monitors, or other such patterns when there is no actual way to modify the data. 

Finally, a common pattern in imperative programming with mutable data involves first assigning some default value to a variable, and then modifying it. For example, you might start with an empty collection and then populate it with some specific values. However, coders often forget to change them into something meaningful, leading to many bugs, such as the billion-dollar mistake caused by using `null`. 

We encourage you to familiarize yourself with this pattern by watching the [original video](https://www.youtube.com/watch?v=DhNw60hxCeY).

#### Exercise

We provide you with a sample implementation of an application that handles creating, modifying, and deleting users in a database. We mock the database and HTTP layers, and your task is to implement methods for processing requests following the Berliner pattern.

Start by implementing the `onNewUser` and `onVerification` methods in `BerlinerPatternTask.scala`. We provide the implementations for the database and client for these methods so you can familiarize yourself with the application. Execute the `run` script in `HttpClient.scala` to make sure your implementation works correctly.

Then, implement the functionality related to password changes and user removals. You will need to implement all layers for these methods, so check out `Database.scala` and `HttpClient.scala`. Don't forget to uncomment the last several lines in the `run` script for this task. 

---

## Expressions over Statements

### What is an expression

When programming in an imperative style, we tend to build functions out of statements. We instruct the compiler on the exact steps and the order in which they should be performed to achieve the desired result. 

A typical function follows this approach: retrieve the data from here, modify it, save it there. It manipulates data that resides somewhere outside the function itself. This idea contradicts the definition of a function that we learned in school maths. There, functions didn't modify anything. 
Instead, they took arguments and produced a new result. They were expressions. 

An expression can be viewed as a combination of values, variables, functions, and operators that are evaluated by the programming language's interpreter or compiler to produce other values. For example, `1+2`, `x*3` and `f(42)` are all expressions. Typically, an expression evaluates to a *value* which can be used in subsequent computations. Expressions are also *composable*, meaning that an expression can be nested within other expressions, enabling complex computations. You can often identify an expression by the context in which it is used: they most often appear in if-conditions, as arguments to functions, and on the right-hand side of assignments. 

The main purpose of a statement is to execute some specific *action*: declare a variable, run a loop, execute a conditional statement, etc. For instance, examples of statements are `val x = 13;`, `return 42`, and `println("Hello world")`. They generally don't return a value; instead, they serve as the building blocks of a program written in an imperative style. Statements define the *control flow* of the program. 

Of course, in real programming languages, the distinctions between expressions and statements can be less clear-cut than in theory. Many languages permit expressions to have what are called *side effects*: they can throw exceptions, write to logs, or read from memory. On the other hand, statements may return values and even be composed. What is important is what we consider to be the primary purpose of a given language feature. 

In functional programming languages, we tend to favor expressions for various reasons. We will talk about these reasons in the further lessons. For now, let's consider how using expressions may affect the way we write code, using the example of a program that determines if a number is even or odd. 
First, consider a statement-based implementation. 

```scala 3
def even(number: Int): Unit = {
  if (number % 2 == 0)
    println("Number is even")
  else
    println("Number is odd")
}

def main(): Unit = {
  val number = 42
  even(42)
}
```

Here, we use an if-statement to check if the number is even. Depending on the condition, we execute one of the two `println` statements. Notice that no value is returned. Instead, everything the function does is a side effect of printing to the console. This style is not considered idiomatic in Scala. Instead, it's preferable for a function to return a string value, which is then printed, like so: 

```scala 3
def even(number: Int): String = { 
  if (number % 2 == 0) "even" else "odd"
} 

@main
def main(): Unit = {
  val number = 42 
  val result = even(12)
  println(s"The number is $result")
}
```

This way, you separate the logic of computing values from outputting them. It also makes your code more readable. 

#### Exercise 

Rewrite the `abs` and `concatStrings` functions as expressions to perform the same tasks as their original implementations. Implement the `sumOfAbsoluteDifferences` and `longestCommonPrefix` functions using the expression style.

* `abs` computes the absolute value of a given integer number. 
* `concatStrings` concatenates a list of strings. 
* `longestCommonPrefix` determines the longest common prefix among the strings in the input list.
* `sumOfAbsoluteDifferences` first computes the absolute differences between numbers at corresponding positions in two arrays and then sums them up. 

For example, given arrays `[1, 2]` and `[3, 4]`, it results in `abs(1 - 3) + abs(2 - 4) == 4`. 
It is assumed that the arrays always have the same length. 

---

### Nested Methods

In Scala, it's possible to define methods within other methods. This is useful when you have a function that is only intended for one-time use. For example, you may wish to implement the factorial function using an accumulator to enhance the program's efficiency.Simultaneously, you would not want to allow the user to call the function with an arbitrary accumulator parameter. In this situation, you can expose a standard one-parameter function `factorial`, which calls the nested tail-recursive implementation `fact` with the appropriate accumulator: 

```scala 3
def factorial(x: Int): Int =
  def fact(x: Int, accumulator: Int): Int =
    if x <= 1 then accumulator
    else fact(x - 1, x * accumulator)
  fact(x, 1)
```

An alternative option is to place the `fact` function on the same level as `factorial` and make it `private`. This still permits other functions in the same module to access `fact`, whereas nesting it renders it exclusively accessible from inside the `factorial` function. You can also have nested methods within other nested methods, with the rules of scoping being consistent: the nested function is only accessible from within its outer function: 

```scala 3
def foo() = {
  def bar() = {
    def baz() = { }
    baz()
  }
  def qux() = {
    def corge() = { }
    corge() // A nested function can be called
    bar() // A function on the same level can be called
    // A function nested within the other function cannot: 
    // baz() // not found: baz
  }
  // Functions on this level can be called...
  bar()
  qux()
  // ... but their nested functions cannot: 
  // baz() // not found: baz
  // corge() // not found: corge
}
```

Note that we've used curly braces to delineate scopes more clearly; however, they are not needed in Scala 3. 

Nested functions can access the parameters of their parents, so you can avoid passing parameters that do not change: 

```scala 3
def f(x: Int, y: Int): Int =
  def g(z: Int): Int =
    def h(): Int =
      x + y + z
    h()
  //  def i(): Int = z // z is not visible outside g
  g(42)
```

Another instance where nested methods prove particularly useful is when you create a chain of calls to higher-order functions, utilizing nested methods to assign meaningful names to their arguments. 
Consider the example where we count the number of kittens that are either white or ginger. 

```scala 3
enum Color:
  case Black
  case White
  case Ginger

// We have a model in which any cat has a color and an age (in years)
class Cat(val color: Color, val age: Int)

val bagOfCats = Set(Cat(Color.Black, 0), Cat(Color.White, 1), Cat(Color.Ginger, 3))

// Count the number of white or ginger kittens (cats that are not older than 1 year) 
val numberOfWhiteOrGingerKittens =
  def isWhiteOrGinger(cat: Cat): Boolean = cat.color == Color.White || cat.color == Color.Ginger
  def isKitten(cat: Cat): Boolean = cat.age <= 1
  bagOfCats.filter(isWhiteOrGinger).count(isKitten)
```

We could have written the latter function as shown below, but it is obviously less readable: 

```scala 3
val numberOfWhiteOrGingerKittens =
  bagOfCats
    .filter(cat => cat.color == Color.White || cat.color == Color.Ginger)
    .count(cat => cat.age <= 1)
```

#### Exercise 

Explore the scopes of the nested methods. Make the code in the file `NestedTask.scala` compile.

---

### Pure vs impure functions

Not all functions are created equal; some of them are better than others. A large group of such superior functions are designated as *pure*. A pure function always yields the same value if given the same inputs. For example, the mathematical function `double(x) = 2 * x`, for doubling a number, always returns `42` when given `21` as an argument. Conversely, the function `g`, which takes a number as an argument, reads another from the standard input, and then multiplies them,does not always compute the same result when called with `21`. 

```scala 3
def g(x: Int): Int =
  val y = StdIn.readInt()
  x * y

println(g(21)) // Input: 1 => printed 21
println(g(21)) // Input: 3 => printed 63
```

Another consequence of having to always produce the same result is that a pure function cannot perform any side effects. For instance, a pure function cannot output anything, interact with a database, or write into a file. It cannot read from the console, database, or a file, modify its arguments, or throw an exception. The result solely depends on the arguments and the implementation of the function itself. Its performance should neither be influenced by the external world nor impact it.

You might argue that pure functions seem entirely useless. If they cannot interact with the outer world or mutate anything, how is it possible to derive any value from them? Why should we even use pure functions? The fact is, they conform much better than their impure counterparts. Since there are no hidden interactions, it's much easier to verify that your pure function does what it is supposed to do and nothing more. Moreover, they are much easier to test, as you do not need to mock a database if the function never interacts with one. 

Some programming languages, such as Haskell, limit impurity and reflect any side effects in their types. However, it can be quite restricting and is not an approach utilized in Scala.  The idiomatic method is to write your code in such a way that the majority of it is pure, and impurity is only used 
where it is absolutely necessary, similar to what we did with mutable data. For example, the function `g` can be split into two: the one that reads the number from the standard input and the one that is responsible for multiplication: 

```scala 3
def gPure(x: Int, y: Int): Int =
  x * y 
  
def g(x: Int): Int =
  val y = StdIn.readInt()
  gPure(x, y)
```

#### Exercise

Implement the pure function `calculateAndLogPure`, which does the same thing as `calculateAndLogImpure`, but without using a global variable.

---

### Recursion

*To understand recursion, one must first understand recursion* 

This topic should be familiar to anyone who delved into functional programming, but we would like to review it once again. The essence of recursion is that a function calls itself. At first encounter, this approach may seem unconventional, but with more practice, you'll find it increasingly natural. 
Consider the problem of finding a key in a box. But, the box may contain other boxes, which may also contain further boxes, and so forth, and the key is located in one of these boxes, but you have no idea which one. To solve such a problem without recursion, you would generally use a loop: 

```scala 3
// We model the contents of a box as a set of Items, which can contain other boxes or keys 
sealed trait Item
case class Box(content: Set[Item]) extends Item
case class Key(id: String) extends Item

def lookForKey(box: Box): Option[Key] =
  // create a mutable variable for a pile of items to look through
  var pile = box.content
  while pile.nonEmpty do
    // pick one item from the pile
    val item = pile.head
    item match
      case key: Key => 
        // found the key
        return Some(key)
      case box: Box => 
        // remove the current item from the pile and add its contents for further inspection
        pile = pile - box ++ box.content
  // no key was found
  None 

@main
def main() =
  val box = Box(Set(Box(Set(Box(Set.empty), Box(Set.empty))), Box(Set(Key(), Box(Set.empty)))))
  println(lookForKey(box))
```

This solution is valid, but it feels cumbersome. We need to create a mutable variable to hold the pile of items inside the box. Additionally, we must remember to remove the box under inspection before adding its contents. We also have to remember to return `None` at the end, after the `while` loop: luckily, the compiler will complain if we forget this. In general, it is just too easy to make a mistake when writing this function.

Alternatively, we can consider what it means to look for a key in a box filled with other boxes and keys. We look inside the box, pick one of the items inside, and if it is a box, we just need to proceed and look for a key within it — just as we are currently doing. It is precisely the situation where a function calls itself. Compare the recursive implementation to the non-recursive one: 

```scala 3
def lookForKey(box: Box): Option[Key] =
  def go(item: Any): Option[Key] =
    item match
      case key: Key => Some(key)
      case box: Box =>
        // process every item in the box recursively and pick the first key in the result, if it exists
        box.content.flatMap(go).headOption
  go(box)
```

In this case, we simply go through evey item in the box, apply the recursive function `go` to it, and then select the first key in the resulting collection. Notice that we no longer have any mutable variables, our program is much more readable, and there are fewer ways it can go wrong. One may protest that this code is not optimal because `flatMap` will go through the entire box even if we find the key early, and that is a valid concern. There are many ways to deal with this kind of inefficiency. 
One method would be to use lazy collections or views, and we'll explore another in one of the following modules when we'll discuss early returns. 

If you find it hard to think recursively, consider the following two-step approach. 
1. If the given instance of the problem can be solved directly, solve it directly. 
2. Othewise, reduce it to one or more *simpler instances of the same problem*. 

In our example with boxes, if the item at hands is a key, then we've solved the problem and all we need to do is return the key. This is the base case of our problem, the smallest instance of it. Otherwise, we have *smaller* instances of the same problem: other boxes in which we can try to look for a key. Once we've looked through the boxes recursively, we can be sure that if a key exists, it has been found. The only thing left after that is some kind of post-processing of the recursive calls' results — in our case, getting the first found key with `headOption`. 

Recursion shines when dealing with recursive data structures, which are very common in functional programming. Lists, trees, and other algebraic data structures are areas where recursion applies very naturally. Consider the recursive function that computes the sum of the values in binary tree nodes: 

```scala 3
enum Tree:
  case Node(val payload: Int, val left: Tree, val right: Tree)
  case Leaf(val payload: Int)

import Tree.*

def sumTree(tree: Tree): Int =
  tree match
    case Leaf(payload) => payload
    case Node(payload, left, right) =>
      payload + sumTree(left) + sumTree(right)

@main
def main() =
  /**
   *     4
   *    / \
   *   2  5
   *  / \
   * 1  3
   */
  val tree = Node(4, Node(2, Leaf(1), Leaf(3)), Leaf(5))
  println(sumTree(tree))
```

You may notice that we call `sumTree` recursively every time there is a `Tree` within a `Tree` node. The recursion in the data type points us to a *smaller* instance of the problem to solve. We then sum the values returned from the recursive calls, producing the final result. There are no `Tree`s in a `Leaf`, therefore, we know it is the base case and the problem can be solved right away.

#### Exercise 

Implement a tiny calculator `eval` and a printer `prefixPrinter` for arithmetic expressions. An expression is presented as its abstract syntax tree, where leaves contain numbers, while nodes correspond to the binary operators applied to subexpressions. For example, the tree `Node(Mult, Node(Plus, Leaf(1), Leaf(3)), Leaf(5))` corresponds to the expression `(1+3)*5`. The printer should convert an expression into the prefix form, in which the operator comes first, followed by the left operand, then the right operand. Our tree should be printed as `* + 1 3 5`. 

### Tail recursion

A common criticism of using recursion is that it is intrinsically slow. Why is that? The clue is in what is known as the call stack. Each time a function is called, some information regarding the call is placed on the call stack — we say that some stack space is allocated. This information is kept there until all computations within the function are completed, after which the stack is deallocated (the information about the function call is removed from the stack), and the computed value is returned. 
If a function calls another function, the stack is allocated again before deallocating the previous function's call. What is worse, we wait until the inner call is complete, its stack frame is deallocated, and its value returned before we can compute the result of the caller function. This is especially significant for recursive functions because the depth of the call stack can be astronomical. 

Consider the example of computing the factorial.

```scala 3
def factorial(n: BigInt): BigInt =
  if (n <= 0) 1
  else n * factorial(n - 1)
```

Evaluating `factorial(3)` results in the following events occurring on the stack: 

```scala 3
factorial(3)
3 * factorial(2)
3 * 2 * factorial(1)
3 * 2 * 1 * factorial(0)
3 * 2 * 1 * 1 
3 * 2 * 1 
3 * 2 
6
```

Until we've reached the base case, we cannot start doing multiplication and must keep all the multipliers on the stack. Calling `factorial` with a large enough argument (like `10000` on my computer) results in a stack overflow error, and the computation doesn't produce any result. 

Don't get discouraged! There is a well-known optimization technique capable of mitigating this issue. It involves rewriting your recursive function into a tail-recursive form. In this form, the recursive call should be the last operation the function performs. 

For example, `factorial` can be rewritten as follows: 

```scala 3
def factorial(n: BigInt): BigInt = 
  def go(n: BigInt, accumulator: BigInt): BigInt =
    if (n <= 0) accumulator
    else go(n - 1, n * accumulator)
  go(n, 1)
```

We add a new parameter `accumulator` to the recursive function to keep track of the partially computed multiplication. Notice that the recursive call to `go` is the last operation in the `else` branch of the `if` condition. Whatever value the recursive call returns is simply returned by the caller. There is no reason to allocate any stack frames because nothing is awaiting the result of the recursive call to enablefurther computation. Smart enough compilers (and the Scala compiler is one of them) can optimize away the unnecessary stack allocations in this case. Go ahead and try to find an `n` such that the tail-recursive `factorial` results in a stack overflow. Unless something goes horribly wrong, you should not be able to find such an `n`. 

By the way, do you remember the key searching function we implemented in the previous task?
Have you wondered how we got away not keeping track of a collection of boxes to look through?
The trick is that the stack replaces that collection. All the boxes to be considered are somewhere on the stack, patiently awaiting their turn. 

Is there a way we can make that function tail-recursive? Yes, of course, there is! Similar to the `factorial` function, we can create a helper function `go` with an extra parameter `boxesToLookIn`
to keep track of the boxes to search for the key in. This way, we can ensure that `go` is tail-recursive, i.e., either returns a value or calls itself as its final step. 

```scala 3
def lookForKey(box: Box): Option[Key] =
  def go(item: Item, boxesToLookIn: Set[Item]): Option[Key] =
    item match
      case key: Key => Some(key)
      case Box(content) =>
        if content.isEmpty
        then
          if boxesToLookIn.isEmpty
          then None
          else go(boxesToLookIn.head, boxesToLookIn.tail)
        else
          go(content.head, boxesToLookIn ++ content.tail)
  go(box, Set.empty)
```

In Scala, there is a way to ensure that your function is tail-recursive: the `@tailrec` annotation from `scala.annotation.tailrec`. It checks if your implementation is tail-recursive and triggers a compiler error if it is not. We recommend using this annotation to ensure that the compiler is capable of optimizing your code, even throughfuture changes.

#### Exercise 

Implement tail-recursive functions for reversing a list and finding the sum of digits in a non-negative number. 
We've annotated the helper functions with `@tailrec` so that the compiler can verify this property for us.  

---

### The `using` clause

When writing pure functions, we often end up carrying some immutable context, such as configurations, as extra arguments. A common example is when a function expects a specific comparator of objects, such as in computing the maximum value or sorting: 

```scala 3
trait Comparator[A]:
  def compare(x: A, y: A): Int

class IntComparator extends Comparator[Int]:
  def compare(x: Int, y: Int): Int = x - y

def max[A](x: A, y: A, comparator: Comparator[A]): A =
  if comparator.compare(x,y) >= 0 then x
  else y

@main
def main() =
  println(s"${max(13, 42, IntComparator())}")
```

Here, we have a trait `Comparator` to specify a method for comparing values. Every time we want to call the function `max`, we need to provide a specific `Comparator`. However, there is usually only one reasonable comparator for a specific type, and passing an extra argument hinders readability. Scala solves this problem with the `using` clause, also known as a contextual parameter, along with what is called `given`s. 

```scala 3
trait Comparator[A]:
  def compare(x: A, y: A): Int

object Comparator:
  given Comparator[Int] with
    def compare(x: Int, y: Int): Int =
      x - y
end Comparator

def max[A](x: A, y: A)(using comparator: Comparator[A]): A =
  if comparator.compare(x,y) >= 0 then x
  else y

@main
def main() =
  println(s"${max(13, 42)}")
```

By marking an argument with `using` in Scala 3 or `implicit` in Scala 2, we tell the compiler to find an appropriate value based on its type among those marked as `given`. This marking is used when there is a single canonical value of the type, as with integer comparison. If the compiler cannot find a given value of the type needed, it will raise an error. You can read more about how the compiler searches for `given`s [in this StackOverflow answer](https://stackoverflow.com/questions/5598085/where-does-scala-look-for-implicits/5598107#5598107).

In some cases, there are two or more reasonable implementations of `Comparator`.  For example, `String`s can be compared lexicographically (`"aa"` comes before `"b"`, which comes before `"bb"`) or primarily based on their lengths and then lexicographically (`"b"` comes before `"aa"`, which comes before `"bb"`).Even when a contextual parameter is used, you can still use your custom value instead of the `given`. The only thing you need to do is to explicitly pass it as an argument and mark it with the `using` keyword when calling the function: 


```scala 3
trait Comparator[A]:
  def compare(x: A, y: A): Int

object Comparator:
  given Comparator[Int] with
    def compare(x: Int, y: Int): Int =
      x - y
  given Comparator[String] with
    def compare(x: String, y: String): Int =
      x.compareTo(y)
end Comparator

object StringLengthComparator extends Comparator[String]:
  def compare(x: String, y: String): Int =
    if x.length != y.length then y.length - x.length
    else x.compareTo(y)

def max[A](x: A, y: A)(using comparator: Comparator[A]): A =
  if comparator.compare(x,y) >= 0
    then x
  else y

@main
def main() =
  println(s"${max("b", "aa")}")  // prints b
  println(s"${max("b", "aa")(using StringLengthComparator)}") // prints aa  
```

#### Exercise 

Implement a `sort` function to sort an array of values based on the `Comparator` provided. Make it use a contextual parameter to avoid carrying around the immutable context. You can use any kind of sorting algorithm. 

---

## Early Returns

### The Problem

It is often the case that we do not need to go through all the elements in a collection to solve a specific problem. For example, in the Recursion chapter of the previous module, we saw a function to search for a key in a box. It was enough to find a single key, and there was no point in continuing the search in the box after one had been found.

The problem might get trickier as data becomes more complex. Consider an application designed to track your team members, detailing the projects they worked on and the specific days they were involved. Then, the team manager could use the application to run complicated queries such as the following:
* Find an instance when the team worked more person-hours than X in a day.
* Find an example of a bug that took longer than Y days to fix.

It's common to run some kind of conversion on an element of the original data collection into a derivative entry that better describes the problem domain. Then, this converted entry is validated with a predicate to decide whether it's a suitable example. Both the conversion and the verification may be expensive, which makes a naive implementation, like our key search example, inefficient.
In languages such as Java, you can use `return` to stop the exploration of the collection once you've found your answer. 

The implementation might look something like this:

```java
Bar complexConversion(Foo foo) {
  ...
}
 
bool complexValidation(Bar bar) {
  ...
}
 
Bar findFirstValidBar(Collection<Foo> foos) {
  for(Foo foo : foos) {
    Bar bar = complexConversion(foo);
    if (complexValidation(bar)) return bar;
  }
  return null;
}
```

Here, we enumerate the elements of the collection `foos` sequentially, running `complexConversion` on them, followed by `complexValidation`. If we find the element for which `complexValidation(bar)` succeeds, the converted entry is immediately returned, and the enumeration is stopped. If there was no such element, then `null` is returned after the entire collection has been explored without success.

How do we apply this pattern in Scala? It's tempting to translate this code line-by-line directly into Scala:

```scala 3
def complexConversion(foo: Foo): Bar = ...
def complexValidation(bar: Bar): Boolean = ...
 
def findFirstValidBar(seq: Seq[Foo]): Option[Bar] = {
  for (foo <- seq) {
    val bar = complexConversion(foo)
    if (complexValidation(bar)) return Some(bar)
  }
  None
}
```

We've replaced `null` with the more appropriate `None`, but otherwise, the code remains the same. However, this is not good Scala code, where the use of `return` is not idiomatic. Since every block of code in Scala is an expression, the last expression within the block is what is returned. You can write `x` instead of `return x` for the last expression, and it would have the same semantics. Once `return` is used in the middle of a block, the programmer can no longer rely on the last statement as the one
returning the result from the block. This makes the code less readable, makes it harder to inline code, and ruins referential transparency. Thus, using `return` is considered a code smell and should be avoided.

In this module, we'll explore more idiomatic ways to do early returns in Scala. 

---

### Baby steps

First, let's consider a concrete example of a program in need of early returns. Let's assume we have a database of user entries. Accessing this database is resource-intensive, and the user data is extensive. As a result, we only operate on user identifiers and retrieve the user data from the database only when necessary.

Now, imagine that many of those user entries are invalid in some way. For the brevity of the example code, we'll confine our attention to incorrect emails: those that either contain a space character or have a count of `@` symbols different from `1`. In subsequent tasks, we'll also discuss the case when the user with the given ID does not exist in the database.

We'll start with a sequence of user identifiers. Given an identifier, we first retrieve the user data from the database. This operation corresponds to the *conversion* in the previous lesson: we convert an integer number into an instance of the `UserData` class.

Following this step, we run *validation* to check if the email is correct. Upon locating the first valid instance of `UserData`, we should return it immediately, ceasing any further processing of the remaining sequence.

```scala 3
object EarlyReturns:
  type UserId = Int
  type Email = String

  case class UserData(id: UserId, name: String, email: Email)

  private val database = Seq(
    UserData(1, "John Doe", "john@@gmail.com"),
    UserData(2, "Jane Smith", "jane smith@yahoo.com"),
    UserData(3, "Michael Brown", "michaeloutlook.com"),
    UserData(4, "Emily Johnson", "emily at icloud.com"),
    UserData(5, "Daniel Wilson", "daniel@hotmail.com"),
    UserData(6, "Sophia Martinez", "sophia@aol.com"),
    UserData(7, "Christopher Taylor", "christopher@mail.com"),
    UserData(8, "Olivia Anderson", "olivia@live.com"),
    UserData(9, "James Thomas", "james@protonmail.com"),
    UserData(10, "Isabella Jackson", "isabella@gmail.com"),
    UserData(11, "Alexander White", "alexander@yahoo.com")
  )

  private val identifiers = 1 to 11

  /**
   * This is our "complex conversion" method. 
   * We assume that it is costly to retrieve user data, so we want to avoid
   * calling it unless it's absolutely necessary.
   *
   * This version of the method assumes that the user data always exists for a given user id.
   */
  def complexConversion(userId: UserId): UserData = 
    database.find(_.id == userId).get

  /**
   * Similar to `complexConversion`, the validation of user data is costly 
   * and we shouldn't do it too often.
   */
  def complexValidation(user: UserData): Boolean = 
    !user.email.contains(' ') && user.email.count(_ == '@') == 1
```

The typical imperative approach is to use an early return from a `for` loop. We perform the conversion, followed by validation, and if the data is found valid, we return it, wrapped in `Some`. If no valid user data has been found, we return `None` after traversing the entire sequence of identifiers.

```scala 3
 /**
  * Imperative approach that uses unidiomatic `return`.
  */
  def findFirstValidUser1(userIds: Seq[UserId]): Option[UserData] =
    for userId <- userIds do
      val userData = complexConversion(userId)
      if (complexValidation(userData)) return Some(userData)
    None
```

This solution is underwhelming because it uses `return`, which is not idiomatic in Scala.

A more functional approach is to use higher-order functions over collections. We can `find` a `userId` in the collection for which the `userData` is valid. However, this necessitates calling `complexConversion` twice, as `find` returns the original identifier rather than the `userData`.

```scala 3
 /**
  * Naive functional approach: calls `complexConversion` twice on the selected ID.
  */
  def findFirstValidUser2(userIds: Seq[UserId]): Option[UserData] =
    userIds
      .find(userId => complexValidation(complexConversion(userId)))
      .map(complexConversion)
```

Or course, we can run `collectFirst` instead of `find` and `map`. This implementation is more concise than the previous one, but it still doesn't allow us to avoid running the conversion twice. In the next lesson, we'll use a custom `unapply` method to eliminate the need for these repeated computations.

```scala 3
  /** 
   * A more concise implementation, which uses `collectFirst`.
   */
  def findFirstValidUser3(userIds: Seq[UserId]): Option[UserData] =
    userIds.collectFirst {
      case userId if complexValidation(complexConversion(userId)) => complexConversion(userId)
    }
    
```

#### Exercise

Let's revisit one of our examples from an earlier module.  You are managing a cat shelter and keeping track of cats, their breeds, and coat types in a database. You notice numerous mistakes in the database made by a previous employee: there are short-haired Maine Coons, long-haired Sphynxes, and other inconsistencies.  You don't have the time to fix the database right now because you see a potential adopter coming into the shelter.  Your task is to find the first valid entry in the database and present the potential adopter with a cat. 

Implement the `catConversion` method, which fetches a cat from the `catDatabase` in the `Database.scala` file by its identifier. To do this, you will first need to consult another database "table", `adoptionStatusDatabase`, to find out the cat's name. 

Then, implement the `furCharacteristicValidation` that checks if the fur characteristics in the database entry make sense for the cat's particular breed. Consult the `breedCharacteristics` map for the appropriate fur characteristics for each breed. 

Finally, implement the search using the conversion and validation methods:  
* `imperativeFindFirstValidCat`, which works in an imperative fashion.
* `functionalFindFirstValidCat`, utilizing a functional style. 
* `collectFirstFindFirstValidCat`, using the `collectFirst` method. 

Ensure that your search does not traverse the entire database.  We've put some simple logging within the conversion and validation methods so that you can verify this. 

---

### Unapply

Unapply methods form the basis of pattern matching. Their goal is to extract data encapsulated in objects. We can create a custom extractor object for user data validation with a suitable unapply method, for example:

```scala 3
  object ValidUser:
    def unapply(userId: UserId): Option[UserData] =
      val userData = complexConversion(userId)
      if complexValidation(userData) then Some(userData) else None
```

When we pattern match on `ValidUser`, its `unapply` method is called. It runs the conversion and validation and only returns valid user data. As a result, we get this short definition of our search function.

```scala 3
  /**
   * The custom `unapply` method runs conversion and validation and only returns valid user data.
   */
  def findFirstValidUser4(userIds: Seq[UserId]): Option[UserData] =
    userIds.collectFirst {
      case ValidUser(user) => user
    }
```

At this point, an observant reader is likely to protest. This solution is twice as long as the imperative one we started with, and it doesn't seem to do anything extra! One thing to notice here is that the imperative implementation is only concerned with the "happy" path. But what if there are no records in the database for some of the user identifiers? The conversion function becomes partial, and, adhering to the functional method, we need to return an optional value:

```scala 3
  /** 
   * This function takes into account that some IDs can be left out from the database
   */
  def safeComplexConversion(userId: UserId): Option[UserData] = 
    database.find(_.id == userId)
```

The partiality of the conversion will unavoidably complicate the imperative search function. The code still has the same shape, but it has to go through additional loops to accommodate partiality.
Note that every time a new complication arises in the business logic, it has to be reflected within the `for` loop.

```scala 3
  /**
   * Partiality of `safeComplexConversion` trickles into the search function. 
   */
  def findFirstValidUser5(userIds: Seq[UserId]): Option[UserData] =
    for userId <- userIds do
      safeComplexConversion(userId) match
        case Some(user) if complexValidation(user) => return Some(user)
        case _ =>
    None
```

Unlike the imperative approach, the functional implementation separates the logic of conversion and validation from the sequence traversal, which results in more readable code. Taking care of possible missing records in the database amounts to modifying the `unapply` method, while the search function stays the same.

```scala 3
  /**
   * This custom `unapply` method performs the safe conversion and then validation.
   */
  object ValidUser6:
    def unapply(userId: UserId): Option[UserData] =
      safeComplexConversion(userId).find(complexValidation)
  
  def findFirstValidUser6(userIds: Seq[UserId]): Option[UserData] =
    userIds.collectFirst {
      case ValidUser6(user) => user
    }
```

In general, there might be several ways in which user data could be valid. Imagine that there is a user who doesn't have an email. In this case, `complexValidation` returns `false`, but the user might still be valid. For example, it may be an account that belongs to a child of another user. We don't need to message the child; instead, it's enough to reach out to their parent. Even though this case is less common than the one we started with, we still need to keep it in mind. To account for it, we can create a different extractor object with its own `unapply` and pattern match against it if the first validation fails. We do run the conversion twice in this case, but its impact is less significant due to the rarity of this scenario.

```scala 3
  object ValidUserInADifferentWay:
    def otherValidation(userData: UserData): Boolean = false /* check that it's a child user */
    def unapply(userId: UserId): Option[UserData] = safeComplexConversion(userId).find(otherValidation)
  
  def findFirstValidUser7(userIds: Seq[UserId]): Option[UserData] =
    userIds.collectFirst {
      case ValidUser6(user) => user
      case ValidUserInADifferentWay(user) => user
    }
```

Both extractor objects work in the same way. They run a conversion method, which may or may not succeed. If the conversion succeeds, its result is validated and returned when it is valid. All of this is done with the `unapply` method, whose implementation stays the same regardless of the other methods. This forms a nice framework which can be abstracted as a trait we call `Deconstruct`. It has the `unapply` method that calls two abstract methods, `convert` and `validate`, which operate on generic types `From` and `To`.

```scala 3
  /**
   * @tparam From The type we initially operate on
   * @tparam To The type of the data we want to retrieve if it's valid
   */
  trait Deconstruct[From, To]:
    def convert(from: From): Option[To]
    def validate(to: To): Boolean
    def unapply(from: From): Option[To] = convert(from).find(validate)
```

In our case, the concrete implementation of the `Deconstruct` trait works on types `From` = `UserId` and `To` = `UserData`. It uses `safeComplexConversion` and `complexValidation` respectively.

```scala 3
  object ValidUser8 extends Deconstruct[UserId, UserData]:
    override def convert(userId: UserId): Option[UserData] = safeComplexConversion(userId)
    override def validate(user: UserData): Boolean = complexValidation(user)
```

Finally, the search function stays the same, but now it uses the `unapply` method defined in the `Deconstruct` trait during pattern matching:

```scala 3
  def findFirstValidUser8(userIds: Seq[UserId]): Option[UserData] =
    userIds.collectFirst {
      case ValidUser8(user) => user
    }
```

#### Exercise

You have noticed that the first cat found with a valid fur pattern has already been adopted.  Now you need to include a check in the validation to ensure that the cat is still in the shelter. 

* Implement `nonAdoptedCatConversion` to only select cats that are still up for adoption.
* Copy your implementation of the `furCharacteristicValidation` function from the previous task. 
* Implement your custom `unapply` method for the `ValidCat` object, and use it to write the `unapplyFindFirstValidCat` function. The validation of fur characteristics should not be run on cats who have been adopted. 

Next, you notice that there are some inaccuracies in the coat patterns: no Bengal cat can be of a solid color! 

* Implement the validation of the coat pattern using a custom `unapply` method. 
* Use the `ValidPattern` object that extends the `Deconstruct` trait.
* Use the custom `unapply` method in the `findFirstCatWithValidPattern` function. 

---

### Lazy Collections to the rescue

One more way to achieve the same effect of an early return is to use the concept of a lazy collection.  A lazy collection doesn't store all its elements computed and ready for access. Instead, it stores a way to compute an element once it's needed somewhere. This makes it possible to simply traverse the collection until we encounter an element that fulfills the conditions. Since we aren't interested in the rest of the collection, those elements won't be computed. 

As we've already seen a couple of modules ago, there are several ways to convert a collection into a lazy one. The first is by using [iterators](https://www.scala-lang.org/api/current/scala/collection/Iterator.html): we can call the `iterator` method on our sequence of identifiers.  Another way is to use [views](https://www.scala-lang.org/api/current/scala/collection/View.html), as we've done in one of the previous modules.  Try comparing the two approaches on your own.

```scala 3
  def findFirstValidUser9(userIds: Seq[UserId]): Option[UserData] =
    userIds
      .iterator
      .map(safeComplexConversion)
      .find(_.exists(complexValidation))
      .flatten
```

#### Exercise

Let's try using a lazy collection to achieve the same goal as in the previous tasks. 

* Use a lazy collection to implement `findFirstValidCat`.
* Copy the implementations of `furCharacteristicValidation` and `nonAdoptedCatConversion` from the previous task. 

---

### Breaking boundaries

Similarly to Java and other popular languages, Scala provides a way to break out of a loop. Since Scala 3.3, it's achieved with a composition of boundaries and breaks, which provides a cleaner alternative to non-local returns. 
With this feature, a computational context is established with `boundary:`, and `break` returns a value from within the 
enclosing boundary.
Check out the [implementation](https://github.com/scala/scala3/blob/3.3.0/library/src/scala/util/boundary.scala) 
if you want to know how it works under the hood.
One important thing is that it ensures that the users never call `break` without an enclosing `boundary`, thus making 
the code much safer. 

The following snippet showcases the use of boundary/break in its simplest form. 
If our conversion and validation work out, then `break(Some(userData))` jumps out of the loop labeled with `boundary:`. 
Since it's the end of the method, it immediately returns `Some(userData)`. 

```scala 3
  def findFirstValidUser10(userIds: Seq[UserId]): Option[UserData] =
    boundary:
      for userId <- userIds do
        safeComplexConversion(userId).foreach { userData =>
          if (complexValidation(userData)) break(Some(userData))
        }
      None
```

Sometimes, there are multiple boundaries, and in such cases, one can add labels to `break` calls. 
This is especially important when there are embedded loops.
An example of using labels can be found [here](https://gist.github.com/bishabosha/95880882ee9ba6c53681d21c93d24a97).

#### Exercise 

Finally, let's use boundaries to achieve the same result. 

Let's try using a lazy collection to achieve the same goal as in the previous tasks.

* Use a boundary to implement `findFirstValidCat`.
* Copy the implementations of `furCharacteristicValidation` and `nonAdoptedCatConversion` from the previous task. 

---

## Monads

### `Option` instead of `null`

Monad is a powerful concept widely used in functional programming. It's a design pattern capable of describing failing computations, managing state, and handling arbitrary side effects. Unlike Haskell, Scala's standard library doesn't include a specific Monad trait. Instead, a monad is a wrapper class `M[A]` that implements `flatMap`, the method for chaining several operations together. Simplified, this method has the following type: 

`def flatMap[B](f: A => M[B]): M[B]` 

It executes a monadic computation that yields some value of type `A` and then applies the function `f` to this value, resulting in a new monadic computation. This process enables sequential computations in a concise manner. 

In addition to this, there should be a way to create the simplest instance of a monad. Many monad tutorials written for Scala call it `unit`, but it may be misleading due to the existence of `Unit`, the class with only one instance. A better name for this method is `identity`, `pure` or `return`.  We will be calling it `identity` for reasons that will become clear when we talk about monadic laws, a set of rules each monad should satisfy. Its type is `def identity[A](x: A): M[A]`, meaning that it just wraps its argument into a monad, and in most cases, it is just the `apply` methods of the corresponding class.  In this lesson, we'll consider our first monad that should already be familiar to you. 

As you've probably already noticed, many real-world functions are partial. 
For example, when dividing by 0, you get an error, which fully aligns with our view of the world.
To make division a total function, we can use `Double.Infinity` or `Double.NaN`, but this is only valid for this narrow case. 
More often, a `null` is returned from a partial function, or, even worse, an exception is thrown.
Using `null` is called a billion-dollar mistake for a reason and should be avoided. 
Throwing exceptions is akin to throwing your hands in the air and giving up trying to solve a problem, passing it to someone else instead. 
These practices were once common, but now that better ways to handle failing computations have been developed, it's good to use them instead. 

`Option[A]` is the simplest way to express a computation that can fail. 
It has two subclasses: `None` and `Some[A]`. 
The former corresponds to an absence of a result or a failure, while the latter wraps a successful result. 
A safe, total division can be implemented as follows:  

```scala 3
def div(x: Double, y: Double): Option[Double] =
  if (y == 0) None
  else Some(x / y)
```

Now, let's consider that you need to make a series of divisions in a chain. 
For example, you want to calculate how many visits your website gets per user per day.
You should first divide the total number of visits by the number of users and then by the number of days during which you collected the data. 
This calculation can fail twice, and pattern matching each intermediate result gets boring quickly. 
Instead, you can chain the operations using `flatMap`. 
If any of the divisions fail, then the whole chain stops.

```scala 3
div(totalVisits, numberOfUsers).flatMap { div(_, numberOfDays) }
```

Now let's see how `identity` and `flatMap` can be implemented. 
This is not exactly their implementation from the standard library, but it reflects the main idea. 

```scala 3
def identity[A](x: A): Option[A] = Some(x)

def flatMap[B](f: A => Option[B]): Option[B] = this match {
  case Some(x) => f(x)  
  case _       => None 
}
```

There is one more special case in Scala: if you pass `null` as an argument to the `Option` constructor, then you receive `None`. 
You should avoid doing this explicitly, but when you need to call a third-party Java library, which can return `nulls`: 

```scala 3
val result = javaLib.getSomethingOrNull(bar)
Option(result).foreach { res => 
    // will only be executed if the `result` is not null  
 }
```

In short, `None` indicates that something went wrong, and `flatMap` allows chaining function calls that do not fail. 

#### Exercise

Let's consider users who are represented with the `User` class. 
Each user has a name, an age, and, sometimes, a child.
`UserService` represents a database of users along with some functions to search for them. 

Your task is to implement `getGrandchild`, which retrieve a grandchild of the user with the given name if the grandchild exists. 
Here we've already put two calls to `flatMap` to chain some functions together; your task is to fill in what functions they are. 

Then implement `getGrandchildAge`, which returns the age of the grandchild if they exist. 
Use `flatMap` here and avoid pattern matching. 

---

### `Either` instead of exceptions

Sometimes, you may need additional information to understand why a particular function failed. 
This is why we have multiple types of exceptions: apart from sending a panic signal, we also explain what happened. 
`Option` is not suitable to convey this information, and `Either[A, B]` is used instead. 
An instance of `Either[A, B]` can only contain a value of type `A` or a value of type `B`, but not simultaneously.
This is achieved by `Either` having two subclasses: `Left[A]` and `Right[B]`.
Whenever there is a partial function `def partialFoo(...): B` that throws exceptions and returns type `B`, we can replace it with a total function `def totalFoo(...): Either[A, B]` where `A` describes the possible errors. 

Like `Option`, `Either` is a monad that allows chaining of succeeding computations. 
The convention is that the failure is represented by `Left`, while `Right` wraps the value computed in the case of success. 
Which subclass to use for which scenario is an arbitrary decision and everything would work the same way if we were to choose differently and reflect the choice in the implementation of `flatMap`. 
However, a useful mnemonic is that `Right` is for cases when everything goes *right*. 
Thus, `identity` wraps the value in the `Right` constructor, and `flatMap` runs the second function only if the first function results in `Right`. 
If an error occurs and `Left` appears at any point, then the execution stops and the error is reported.
Take a minute to write the implementations of the two methods on your own.  

Consider a case where you read two numbers from the input stream and divide one by the other. 
This function can fail in two ways: if the user provides a non-numeric input or if a division-by-zero error occurs. 
We can implement this as a sequence of two functions: 

```scala 3
def readNumbers(x: String, y: String): Either[String, (Double, Double)] = 
  (x.toDoubleOption, y.toDoubleOption) match
    case (Some(x), Some(y)) => Right (x, y)
    case (None, Some(y)) => Left("First string is not a number")
    case (Some(x), None) => Left("Second string is not a number")
    case (None, None) => Left("Both strings are not numbers")

def safeDiv(x: Double, y: Double): Either[String, Double] =
  if (y == 0) Left("Division by zero")
  else Right(x / y)

@main
def main() =
  val x = readLine()
  val y = readLine()
  print(readNumbers(x, y).flatMap(safeDiv))
```

Note that we have used `String` for errors here, but we could have used a custom data type. 
We could even create a whole hierarchy of errors if we wished to do so. 
For example, we could make `Error` into a trait and then implement classes for IO errors, network errors, invalid state errors, and so on. 
Another option is to use the standard Java hierarchy of exceptions, like in the following `safeDiv` implementation. 
Note that no exception is actually thrown here; instead, you can retrieve the kind of error by pattern matching on the result.  

```scala 3
def safeDiv(x: Double, y: Double): Either[Throwable, Double] =
    if (y == 0) Left(new IllegalArgumentException("Division by zero"))
    else Right(x / y)
```

#### Exercise

Let's get back to our `UserService` from the previous lesson. 
There are three possible reasons why `getGrandchild` may fail: 

* The user with the given name can't be found.  
* The user doesn't have a child. 
* The user's child doesn't have a child. 

To explain the failure to the caller, we created the `SearchError` enum and changed the types of the `findUser`, `getGrandchild`, `getGrandchildAge` functions to be `Either[SearchError, _]`. 

Your task is to implement the functions providing the appropriate error message. 
There is a helper function, `getChild`, to implement so that `getGrandchild` can use `flatMap`s naturally. 

---

### `Try` instead of `try-catch`

When all code is under our control, it's easy to avoid throwing exceptions by using `Option` or `Either`. 
However, we often interact with Java libraries where exceptions are omnipresent, for example, in the context of working with databases, files, or internet services.
One option to bridge this gap is by using `try/catch` and converting exception code into monadic code: 

```scala 3
def foo(data: Data): Either[Throwable, Result] =
  try {
    val res: Result = javaLib.getSomethingOrThrowException(data)
    Right(res)
  } catch {
    case NonFatal(err) => Left(err)
  }
```

This case is so common that Scala provides a special monad `Try[A]`.
`Try[A]` functions as a version of `Either[Throwable, A]` specially designed to handle failures coming from the JVM.
You can think of this as a necessary evil: in the ideal world, there wouldn't be any exceptions, but since there is no such thing as the ideal world and exceptions are everywhere, we have `Try` to bridge the gap.
Using `Try` simplifies the conversion significantly: 

```scala 3
def foo(data: Data): Try[Result] =
  Try(javaLib.getSomethingOrThrowException(data))
```

`Try` comes with two subclasses `Success[A]` and `Failure`, which are like the `Right[A]` and `Left[Throwable]` of `Either[Thowable, A]`.
The former wraps the result of the successful computation, while the latter signals failure by wrapping the exception thrown. 
Since `Try` is a monad, you can use `flatMap` to pipeline functions, and whenever any of them throws an exception, the computation is aborted. 

Sometimes, an exception is not fatal, and you know how to recover from it. 
Here, you can use the `recover` or `recoverWith` methods.
The `recover` method takes a partial function that, for some exceptions, produces a value which is then wrapped in `Success`, while with all other exceptions, it results in `Failure`. 
A more flexible treatment is possible with the `recoverWith` method: its argument is a function that can decide on the appropriate way to react to particular errors. 


```scala 3
val t: Try[Result] =
  Try(javaLib.getSomethingOrThrowException(data))
  
t.recover {
  case ex: IOException => defaultResult
}
  
t.recoverWith {
  case ex: IOException =>
    if (ignoreErrors) Success(defaultResult)
    else Failure(ex)
}
```

To sum up, we strongly recommend that you use `Try` instead of `try/catch`.

---

### Syntactic sugar for for-comprehensions

In the case of any monad, be it `Option`, `Either`, `Try`, or any other, it's possible to chain multiple functions together with `flatMap`.
We've seen many examples where a successfully computed result is passed straight to the next function: `foo(a).flatMap(bar).flatMap(baz)`.
In many real-world situations, there is some additional logic that is executed in between calls.
Consider the following realistic example:

```scala 3
val res = client.getTeamMembers(teamId).flatMap { members =>
  storage.getUserData(members.map(_.userId)).flatMap { users =>
    log(s”members: $members, users: $users”)
    system.getPriorityLevels(teamId).flatMap {
      case levels if levels.size > 1 =>
        doSomeStuffOrFail(members, users, levels)
      case _ =>
        doSomeOtherStuffOrFail(members, users)
    }
  }
}
```

It doesn't look pretty, does it? 
There is a new nesting level for every call, and it's rather complicated to untangle the mess to understand what is happening.
Thankfully, Scala provides syntactic sugar called *for-comprehensions*, reminiscent of the do-notation in Haskell.
The same code can be written more succinctly using `for/yield`:

```scala 3
val res = for {
  members <- client.getTeamMembers(teamId)
  users   <- storage.getUserData(members.map(_.userId))
  _       =  log(s"members: $members, users: $users")
  levels  <- system.getPriorityLevels(teamId)
} yield
  if (levels.size > 1) 
    doSomeStuffOrFail(members, users, levels)
  else
    doSomeOtherStuffOrFail(members, users)
```

Each line with a left arrow corresponds to a `flatMap` call, where the variable name to the left of the arrow represents the name of the variable in the lambda function.
We start by binding the successful results of retrieving team members with `members`, then get user data based on the members' ids and bind it with `users`.
Note that the first line in a for-comprehension must contain the left arrow. 
This is how Scala compiler understands what type the monadic action has.

After that, a message is logged, and priority levels are fetched.
Note that we don't use the arrow to the left of the `log` function because it's a regular function and not a monadic operation that is chained with `flatMap` in the original piece of code.
We also don't care about the value returned by `log`, and because of that, we use the underscore to the left of the equal sign. 
After all this is done, the `yield` block computes the final values to be returned.
If any line fails, the computation is aborted, and the whole comprehension results in a failure. 

#### Exercise 

Use for-comprehensions to implement `getGrandchild` and `getGrandchildAge` from the previous exercise. 

---

### Non-determinism with Lists

(I'm not sure if non-determinism is the right term here)

Monads can express different computational effects, and failure is just one of them. 
Another is non-determinism, which allows a program to have multiple possible results. 
One way to encapsulate different outcomes is by using a `List`. 

Consider a program that computes a factor of a number. 
For non-prime numbers, there is at least one factor that is neither 1 nor the number itself, and many numbers have multiple factors.
The question is: which of the factors should we return?
Of course, we could return a random factor, but a more functional way is to return all of them, packed in a collection such as a `List`.
In this case, the caller can decide on the appropriate treatment.

```scala
// The non-deterministic function to compute all factors of a number 
def factors(n: Int): List[Int] = {
  (1 to n).filter(n % _ == 0).toList
}

// factors(42) == List(1, 2, 3, 6, 7, 14, 21, 42)
```

Let's now discuss the List monad. 
The `identity` method simply creates a singleton list with its argument inside, indicating that the computation has finished with only one value.
`flatMap` applies the monadic action to each element in a list and then concatenates the results. 
If we run `factors(4).flatMap(factors)`, we get `List(1,2,4).flatMap(factors)`, which concatenates `List(1)`, `List(1,2)`, and `List(1,2,4)` for the final result `List(1,1,2,1,2,4)`.

`List` is not the only collection that can describe non-determinism; another is `Set`. 
The difference between the two is that the latter doesn't care about repeats, while the former retains all of them. 
You can choose the suitable collection based on the problem at hand. 
For `factors`, it may make sense to use `Set` because we only care about unique factors. 

```scala
// The non-deterministic function to compute all factors of a number 
def factors(n: Int): Set[Int] = {
  (1 to n).filter(n % _ == 0).toSet
}

// factors(42) == Set(1, 2, 3, 6, 7, 14, 21, 42)
// factors(6).flatMap(factors) == Set(1, 2, 4) 
```

#### Exercise

To make our model of users a little more realistic, we should take into an account that a user may have multiple children. 
This makes our `getGrandchild` function non-deterministic. 
Let's reflect that in the names, types, and implementations. 

Now, function `getGrandchildren` aggregates all grandchildren of a particular user.
Since each person is unique, we use `Set`. 
However, there might be some grandchildren whose ages are the same, and we don't want to lose this information. 
Because of that, `List` is used as the return type of the `getGrandchildrenAges` function. 
Note that there is no need to explicitly report errors any longer because an empty collection signifies the failure on its own. 

---

### Monadic laws

There are multiple monads not covered in this course. 
A monad is an abstract concept, and any code that fulfills certain criteria can be viewed as one. 
What are the criteria we are talking about, you may ask? 
They are called monadic laws: left identity, right identity, and associativity. 

#### Identity Laws

The first two properties are concerned with `identity`, the constructor to create monads. 
Identity laws mean that there is a special value that does nothing when a binary operator is applied to it. 
For example, `0 + x == x + 0 == x` for any possible number `x`. 
Such an element may not exist for some operations, or it may only work on one side of the operator. 
Consider subtraction, for which `x - 0 == x`, but `0 - x != x`. 
As it happens, the `identity` is supposed to be the identity of the `flatMap` method. 
Let's take a look at what it means exactly. 

The left identity law says that if we create a monad from a value `v` with an `identity` method `Monad` and then `flatMap` a function `f` over it, it is equivalent to passing the value `v` straight to the function `f`: 

```scala 3
def f(value: V): Monad[V]

Monad(v).flatMap(f) == f(v)
```
The right identity law states that by passing the `identity` method into a `flatMap` is equivalent to not doing that at all. 
This reflects the idea that `identity` only wraps whatever value it receives and produces no effect. 

```scala 3
val monad: Monad[_] = ...

monad.flatMap(Monad(_)) == monad
```

#### Associativity 

Associativity is a property that says you can put parentheses in any way in an expression and get the same result. 
For example, `(1 + 2) + (3 + 4)` is the same as `1 + (2 + 3) + 4` and `1 + 2 + 3 + 4`, since addition is associative. 
However, subtraction is not associative, and `(1 - 2) - (3 - 4)` is different from `1 - (2 - 3) - 4` and `1 - 2 - 3 - 4`.

Associativity is desirable for `flatMap` because it allows us to unnest them and use for-comprehensions safely. 
In particular, let's consider two monadic actions `mA` and `mB`, followed by some function `doSomething` operating on the resulting values.
This code fragment is equivalent to putting parentheses around the pipelined `mB` and `doSomething`. 

```scala 3
mA.flatMap( a =>
  mB.flatMap( b =>
    doSomething(a, b)
  )
)
```

This can be refactored in the following form, using the `identity` of the corresponding monad. 
Here we parenthesize the chaining of the first two monadic actions and only then `flatMap` `doSomething` over the result.  

```scala 3
mA.flatMap { a => 
  mB.flatMap(b => Monad((a, b)))  
}.flatMap { case (a, b) =>  
  doSomething(a, b)
}
```

We can make this code pretty by sprinkling some syntactic sugar. 

```scala 3
for {
  a <- mA 
  b <- mB 
  res <- doSomething(a, b)
} yield res 
```

#### Do `Option` and `Either` Follow the Laws? 

Now that we know what the rules are, we can check whether the monads we are familiar with adhere to them.
The `identity` of `Option` is `{ x => Some(x) }`, while `flatMap` can be implemented in the following way. 

```scala 3
def flatMap[B](f: A => Option[B]): Option[B] = this match {
  case Some(x) => f(x)
  case _       => None
}
```

The left identity law is straightforward: `Some(x).flatMap(f)` just runs `f(x)`. 

To prove the right identity, let's consider the two possibilities for `monad` in `monad.flatMap(Monad(_))`. 
The first is `None`, and `monad.flatMap(Option(_)) == None.flatMap(Option(_)) == None`. 
The second is `Some(x)` for some `x`. Then, `monad.flatMap(Option(_)) == Some(x).flatMap(Option(_)) == Some(x)`. 
In both cases, we arrived to the value that is the same as the one we started with. 

Carefully considering the cases is how we prove associativity. 

1. If `mA == None`, both expressions are immediately `None`.  
2. If `mA == Some(x)` and `mB == None`, then both expressions are eventually `None`. 
3. If `mA == Some(x)` and `mB == Some(y)`, then the first expression results in `doSomething(x, y)`. Let's prove that the second expression is evaluated to the same value.

```scala 3
Some(x).flatMap { a => 
  Some(y).flatMap(b => Some((a, b)))  
}.flatMap { case (a, b) => doSomething(a, b) }
```

This expression gets evaluated to:  

```scala
Some(b).flatMap(b => Some((x, b)))  
  .flatMap { case (a, b) => doSomething(a, b) }
```

Which is evaluated to: 

```scala 3
Some(x, y).flatMap { case (a, b) => doSomething(a, b) }
```

Finally, we get `doSomething(x, y)`, which is exactly what we wanted. 

If you want to make sure you grasp the concepts of monadic laws, go ahead and prove that `Either` is also a monad.  

#### Beyond Failure

We only covered monads capable of describing failures and non-determinism. 
There are many other *computational effects* that can be expressed via monads. 
These include logging, reading from global memory, state manipulation, different flavors of non-determinism, and many more. 
We encourage you to explore these monads on your own.
Once you feel comfortable with the basics, take a look at the [scalaz](https://scalaz.github.io/7/) and [cats](https://typelevel.org/cats/) libraries. 

---

### Referential Transparency

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

#### The example

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