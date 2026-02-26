# Scala Learning Roadmap

This is a temporary file with contents for nodes in [Scala Learning Roadmap](https://roadmap.sh/r/scala-learning-path). In time, it should be integrated into the roadmap itself. 

The following list describes the first half of the roadmap - IDEs with Scala support and the main Scala concepts. The other half consists of frameworks, libraries, and some more advanced concepts. Many of those (esp. frameworks and libraries) already have short descriptions and links to their webpages in the nodes themselves: just click on the given name and you should see it. 

1. Pick your IDE

   1. Mainstream

      There are two big Integrated Development Environments, most popular among Scala developers: IntelliJ IDEA and VS Code. You can install them and use them for free. To make them support Scala, you need to add plugins to them: respectively, IntelliJ Scala Plugin for IntelliJ IDEA and Metals for VS Code 

      1. IntelliJ Idea w/ Scala Plugin

         IntelliJ IDEA is a popular integrated development environment (IDE) that offers robust support for Scala through its Scala Plugin. This plugin provides essential features for Scala development, including code completion, refactoring, debugging, and seamless integration with build tools like sbt and Maven. 

         Resources

         1. [Scala IDE | The Landing Page](https://www.jetbrains.com/pages/scala/)
         2. [Get Started With Scala | IntelliJ IDEA Documentation](https://www.jetbrains.com/help/idea/get-started-with-scala.html#new-scala-project)

      2. VS Code w/ Metals

         Visual Studio Code (VS Code) is a popular IDE known for its lightweight design and extensive customization options. When equipped with the Metals extension, VS Code becomes a powerful tool for Scala development, offering features like code completion, refactoring, debugging, and integration with build tools like sbt and Maven.

         *Resources*

         1. [Visual Studio Code](https://code.visualstudio.com/)
         2. [Install Metals for VS Code](https://marketplace.visualstudio.com/items?itemName=scalameta.metals#overview)

   2. Secondary

      There is also a number of simpler code editors that support Scala when paired with the Metals plugin.

      1. Vim

         Vim is a highly configurable text editor known for its efficiency and powerful features. When equipped with the Metals plugin, Vim becomes a capable environment for Scala development, offering features like code completion, refactoring, and debugging. 

         *Resources*

         1. [Vim Main Page](https://www.vim.org/)
         2. [Vim | Scalameta](https://scalameta.org/metals/docs/editors/vim/)

      2. Emacs

         Emacs is a highly extensible and customizable text editor known for its powerful features and flexibility. When equipped with the Metals plugin, Emacs becomes a robust environment for Scala development, offering features like code completion, refactoring, and debugging.

         *Resources*

         1. [Emacs Main Page](https://www.gnu.org/software/emacs/)
         2. [Emacs | Scalameta](https://scalameta.org/metals/docs/editors/emacs/)

      3. Zed

         Zed is a modern, lightweight, and highly performant code editor designed for efficiency and ease of use. It offers features like real-time collaboration, a minimalistic interface, and powerful editing capabilities. While Zed is not specifically designed for Scala development, its extensibility and support for various programming languages make it a versatile tool for developers. With the Metals plugin, Zed provides intelligent code completion, diagnostics, and refactoring capabilities for Scala.

         *Resources*

         1. [Scala Editor - Zed](https://zed.dev/languages/scala)

      4. Sublime Text

         Sublime Text is a sophisticated text editor known for its speed, ease of use, and powerful features. It supports a wide range of programming languages, including Scala, through plugins and packages. Sublime Text offers features like multiple selections, command palette, and extensive customization options, making it a popular choice for developers. With the Metals plugin, Sublime Text provides intelligent code completion, diagnostics, and refactoring capabilities for Scala.

         *Resources*

         1. [Sublime Text](https://www.sublimetext.com/)
         2. [Sublime Text | Scalameta](https://scalameta.org/metals/docs/editors/sublime/)

2. Find resources

   1. YouTube
   2. Books
   3. Official documentation
   4. Interactive courses

3. Learn basics

   1. Syntax

      1. Statements & expressions

         1. Standard operators

            Operators are methods that can be used in a more readable and intuitive way. Scala supports standard arithmetic operators (`+`, `-`, `*`, `/`), relational operators (`==`, `!=`, `>`, `<`, `>=`, `<=`), and logical operators (`&&`, `||`, `!`). Additionally, Scala has specific operators like the arrow (`->`) and fat arrow (`=>`). The arrow operator (`->`) is used to create tuples, which are pairs of values. For example, `1 -> 2` creates a tuple `(1, 2)`. The fat arrow (`=>`) is used in function definitions and pattern matching.

            *Resources*

            1. [Working with Arrows in Scala](https://blog.ssanj.net/posts/2017-07-02-working-with-arrows-in-scala.html)
            2. [What do all of Scala's symbolic operators mean? - Stack Overflow](https://stackoverflow.com/questions/7888944/what-do-all-of-scalas-symbolic-operators-mean)
            3. [Introduction to Scala Operators | Baeldung on Scala](https://www.baeldung.com/scala/operators-intro)

         2. Method calls

            Method calls can be made using different syntaxes and conventions. Methods can be called using the standard dot notation (e.g., `obj.method(params)`) or using the infix notation (e.g., `obj method params`). Scala also allows the omission of parentheses on methods of arity-0 (no arguments), but this syntax should only be used when the method in question has no side-effects. Additionally, Scala supports named parameters, which can be used to make method calls more readable.

            *Resources*

            1. [Functions and Methods in Scala | Baeldung on Scala](https://www.baeldung.com/scala/functions-methods)
            2. [Method Invocation | Style Guide | Scala Documentation](https://docs.scala-lang.org/style/method-invocation.html)
            3. [Scala - method call syntax - Stack Overflow](https://stackoverflow.com/questions/11899177/scala-method-call-syntax)

         3. Conditionals
            Conditional statements are primarily handled using `if/else` and `match/case` constructs. The `if/else` construct is straightforward and similar to other programming languages, allowing for simple conditional branching. The `match/case` construct is more powerful and can handle multiple conditions, pattern matching, and even include guards (additional conditions using `if` expressions within each case).

            *Resources*

            1. [Mastering Conditional Statements in Scala: If-Else and Match Explained](https://www.developerindian.com/articles/mastering-conditional-statements-in-scala-if-else-and-match-explained)
            2. [Scala: How to add ‘if’ expressions (guards) to match/case expressions](https://alvinalexander.com/scala/how-to-use-if-then-expressions-guards-in-case-statements-scala/)
            3. [match Expressions | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/match-expressions.html)

         4. Loops

            Loops are used to execute a block of code repeatedly. Scala supports the following types of loops:

            - **while loop**: Repeats a statement or group of statements while a given condition is true. It tests the condition before executing the loop body.
            - **for loop**: Used to iterate over collections or ranges. It is often used for its readability and conciseness.
            - **do-while loop**: Deprecated in Scala 3. Similar to the `while` loop, but the condition is tested at the end of the loop body, ensuring that the loop body is executed at least once.

            *Resources*

            1. [Scala | Loops (while, do..while, for, nested loops) - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-loopswhile-do-while-for-nested-loops/)
            2. [for loops | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/for-loops.html)
            3. [Scala - while loop](https://www.tutorialspoint.com/scala/scala_while_loop.htm)

         5. Try/catch

            Exception handling is done using the `try/catch/finally` construct, similar to Java. The `try` block contains code that might throw an exception, the `catch` block handles the exception, and the `finally` block is used for cleanup or other operations that must be performed regardless of whether an exception was thrown.

            Scala also encourages the use of functional error handling with monads like `Try`, `Option`, and `Either`, which provide a more composable and functional way to handle errors and exceptional cases.

            *Resources*

            1. [try/catch/finally Expressions | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/try-catch-finally.html)
            2. [Scala | Try-Catch Exceptions - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-try-catch-exceptions/)
            3. [Handling Exceptions using Try/Catch/Finally in Scala | ScalaJobs.com](https://scalajobs.com/blog/handling-exceptions-using-try-catch-finally-in-scala)

         6. Strings

            strings can be created and formatted using string interpolators. String interpolation allows you to embed variable references directly in processed string literals. The most commonly used interpolators are:

            - **s interpolator**: Allows you to embed variables directly in the string.
            - **f interpolator**: Allows you to format strings using printf-style format specifiers.
            - **raw interpolator**: Does not perform escaping of literals within a string.

            *Resources*

            1. [String Interpolation | Scala 3 — Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/string-interpolation.html)
            2. [String Interpolation in Scala | Baeldung on Scala](https://www.baeldung.com/scala/string-interpolation)
            3. [Scala - String Interpolation](https://www.tutorialspoint.com/scala/scala_string_interpolation.htm)

         7. Regex

            Regular expressions are supported through the `Regex` class in the `scala.util.matching` package. Regular expressions (regex) are patterns used to match character combinations in strings. They are useful for text processing, pattern matching, and data validation.

            *Resources*

            1. [Regular Expression Patterns | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/regular-expression-patterns.html)
            2. [Regular Expressions in Scala | Baeldung on Scala](https://www.baeldung.com/scala/regular-expressions)
            3. [Scala Regular Expressions | Tutorials Point](https://www.tutorialspoint.com/scala/scala_regular_expressions.htm)

      2. Main data structures

         1. class

            A class is a blueprint for creating objects. Classes can contain methods, values, variables, types, objects, and traits. The primary constructor is defined in the class signature. Classes are defined using the `class` keyword followed by the class name.

            *Resources*

            1. [Classes | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/classes.html)
            2. [Scala - Classes & Objects](https://www.tutorialspoint.com/scala/scala_classes_objects.htm)
            3. [Classes and Objects in Scala | Baeldung on Scala](https://www.baeldung.com/scala/classes-objects)

         2. trait

            A trait is a type that defines a contract of fields and methods, which can be either abstract (unimplemented) or concrete (implemented). Traits are used to share behavior across classes, enabling code reuse without relying on single inheritance. Traits are similar to Java 8’s interfaces. Classes and objects can extend traits using the `extends` keyword, but traits cannot be instantiated and therefore have no parameters.

            *Resources*

            1. [Traits | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/traits.html)
            2. [Scala - Traits](https://www.tutorialspoint.com/scala/scala_traits.htm)
            3. [Introduction to Traits in Scala | Baeldung on Scala](https://www.baeldung.com/scala/traits)

         3. object

            The `object` keyword is used to create a singleton object. A singleton object is a class that has only one instance. Singleton objects are often used to define methods and values that are not specific to instances of a class, similar to static methods in Java.

            *Resources*

            1. [Singleton Objects | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/singleton-objects.html)
            2. [Scala - Classes & Objects | Tutorials Point](https://www.tutorialspoint.com/scala/scala_classes_objects.htm)
            3. [Classes and Objects in Scala | Baeldung on Scala](https://www.baeldung.com/scala/classes-objects)

         4. def / val /var

            `def`, `val`, and `var` are used to declare methods, immutable values, and mutable variables, respectively.

            - **def**: Used to define methods. Methods are evaluated each time they are called.
            - **val**: Used to define immutable values. Values are evaluated once when they are defined.
            - **var**: Used to define mutable variables. Variables can be reassigned.

            *Resources*

            1. [Def, Var & Val in Scala | Baeldung on Scala](https://www.baeldung.com/scala/def-var-val)
            2. [Two Types of Variables | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/two-types-variables.html)
            3. [Difference between var, val, and def in Scala? Examples | Java67](https://www.java67.com/2017/05/difference-between-var-val-and-def-in-Scala.html)

      3. Generic types

         1. Type hierarchy

            Generic types allow you to write code that can work with different types while maintaining type safety. Generic classes and traits take a type as a parameter within square brackets. For example, `Stack[A]` is a generic class that can be used to create stacks of any type `A`.

            Scala's type hierarchy is unified, with `Any` as the top type, which is the supertype of all types, and `Nothing` as the bottom type, which is the subtype of all types.

            *Resources*

            1. [Generic Classes | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/generic-classes.html)
            2. [Basics of Generics in Scala | Baeldung on Scala](https://www.baeldung.com/scala/generics-basics)
            3. [Generics | Scala 3 - Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/types-generics.html)

         2. Type parameters

            Type parameters are used to create generic classes, traits, and methods. Type parameters are enclosed in square brackets and can be used to define methods and classes that work with different types while maintaining type safety.

            *Resources*

            1. [Polymorphic Methods | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/polymorphic-methods.html)
            2. [Generic Classes | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/generic-classes.html)
            3. [Basics of Generics in Scala | Baeldung on Scala](https://www.baeldung.com/scala/generics-basics)

         3. Conversions

            Implicit conversions allow the compiler to automatically convert one type to another in certain situations. In Scala 3, implicit conversions are defined by a `given` instance of type `scala.Conversion[S, T]`, where `S` is the source type and `T` is the target type.

            In Scala 3.8+, the `into` keyword is used to mark types that can be implicitly converted. If the expected type of an expression is `into[T]`, then an implicit conversion to that type can be inserted without the need for a language import.

            *Resources*

            1. [Implicit Conversions | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/implicit-conversions.html)
            2. [Implicit Conversions | Scala 3 — Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/ca-implicit-conversions.html)
            3. [Implicit Conversions | Baeldung on Scala](https://www.baeldung.com/scala/implicit-conversions)

   2. Functions as Data

      1. What is a function?

         In Scala, functions are first-class values, which means they can be assigned to variables, passed as arguments to other functions, and returned from functions. This is a key feature of functional programming in Scala.

         *Resources*

         1. [How to use functions as variables (values) in Scala | alvinalexander.com](https://alvinalexander.com/scala/how-to-use-functions-as-variables-values-in-scala-fp/)
         2. [Functions Are Values | Scala 3 - Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/fp-functions-are-values.html)
         3. [Scala - Functions | Tutorials Point](https://www.tutorialspoint.com/scala/scala_functions.htm)

      2. Anynomous functions / lambdas

         Anonymous functions, also known as lambdas, are functions that are not bound to a name. They are often used for short-term tasks where defining a named function would be redundant. 

         *Resources*

         1. [Anonymous Functions | Scala 3 — Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/fun-anonymous-functions.html)
         2. [Lambda Expressions in Scala | Baeldung on Scala](https://www.baeldung.com/scala/lambda-expressions)
         3. [Anonymous Functions in Scala: How to Use Lambda Functions Effectively](https://www.developerindian.com/articles/anonymous-functions-in-scala-how-to-use-lambda-functions-effectively)

      3. Total / partial functions

         A total function is a function that is defined for every possible input value it can be given. In contrast, a partial function is a function that is only defined for a subset of possible input values. Partial functions can be used with collection methods like `collect`  and `collectFirst` to manipulate and transform data.

         *Resources*

         1. [Partial Functions in Scala | Baeldung on Scala](https://www.baeldung.com/scala/partial-functions)
         2. [How to create and use partial functions in Scala | alvinalexander.com](https://alvinalexander.com/scala/how-to-define-use-partial-functions-in-scala-syntax-examples/)
         3. [Scala Partial Function - Ways to Define Partial Functions in Scala - DataFlair](https://data-flair.training/blogs/scala-partial-function/)

      4. Functions returning functions

         In Scala, functions can return other functions, which is a powerful feature for functional programming. Currying is the process of converting a function with multiple arguments into a sequence of functions that take one argument each. Function composition is the process of combining two or more functions to create a new function.

         *Resources*

         1. [Currying in Scala | Baeldung on Scala](https://www.baeldung.com/scala/currying)
         2. [Currying Functions in Scala](https://www.tutorialspoint.com/scala/currying_functions.htm)
         3. [Partially Applied Functions and Currying](https://www.scalamatters.io/post/partially-applied-functions-and-currying)

   3. Collections

      1. Collections types

         Scala provides a rich set of collection types, including lists, sets, maps, tuples, options, iterators, vectors, queues, stacks, sequences, and ranges. Scala collections are either mutable or immutable. Mutable collections can be updated or extended in place, while immutable collections never change.

         *Resources*

         1. [Collections Types | Scala 3 - Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/collections-classes.html)
         2. [Scala - Collections | Tutorials Point](https://www.tutorialspoint.com/scala/scala_collections.htm)
         3. [Guide to to Scala Collections | Baeldung on Scala](https://www.baeldung.com/scala/collections)

         Sub-nodes:

         1. Array

            An array is a fixed-size data structure that stores elements of the same data type. Arrays in Scala are mutable, meaning their elements can be updated. Arrays provide fast and constant-time access to elements based on their indices.

            *Resources*

            1. [Arrays | Collections (Scala 2.8 - 2.12) | Scala Documentation](https://docs.scala-lang.org/overviews/collections/arrays.html)
            2. [Scala | Arrays - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-arrays/)
            3. [Guide to Arrays in Scala | Baeldung on Scala](https://www.baeldung.com/scala/arrays-guide)

         2. Seq / List / Vector

            Seq is a common interface for sequences, and the default concrete type is List. List allows for fast (O(1)) prepending and advanced pattern matching with the `::` operator. Vector allows fast random access and updates. All three are immutable (see "Mutable collections" for their mutable counterparts).

            *Resources*

            1. [When should I choose Vector in Scala? - Stack Overflow](https://stackoverflow.com/questions/6928327/when-should-i-choose-vector-in-scala)
            2. [Make the Scala Vector class your default immutable sequence | alvinalexander.com](https://alvinalexander.com/scala/make-vector-class-default-immutable-sequence-scala-cookbook/)
            3. [Scala 2.8 Collections API -- Vectors](https://www.scala-lang.org/docu/files/collections-api/collections_15.html)

         3. Set / Map

            A set is a collection of unique elements. Sets are useful when you need to ensure that all elements are distinct and want to perform operations like union, intersection, and difference efficiently. A map is a collection of key-value pairs. Maps are useful for associating values with unique keys and allow for efficient lookups, insertions, and deletions. Both are immutable (see "Mutable collections" for their mutable counterparts).

            *Resources*

            1. [Maps | Collections (Scala 2.8 - 2.12) | Scala Documentation](https://docs.scala-lang.org/overviews/collections/maps.html)
            2. [Scala: Whats the difference between "Map" vs "Set"? - Stack Overflow](https://stackoverflow.com/questions/45133364/scala-whats-the-difference-between-map-vs-set)
            3. [Scala Set map() method with example - GeeksforGeeks](https://www.geeksforgeeks.org/scala-set-map-method-with-example/)

         4. Mutable collections

            Mutable collections are used when you need collections that can be updated or extended in place, usually for better performance. After the computations are done, you can transform it to its immutable counterpart. Scala provides several mutable collection classes, including `ArrayBuffer`, `ListBuffer`, `HashSet`, and `HashMap`.

            *Resources*

            1. [Concrete Mutable Collection Classes | Collections (Scala 2.8 - 2.12) | Scala Documentation](https://docs.scala-lang.org/overviews/collections/concrete-mutable-collection-classes.html)
            2. [Concrete Mutable Collection Classes | Collections | Scala Documentation](https://docs.scala-lang.org/overviews/collections-2.13/concrete-mutable-collection-classes.html)
            3. [Scala mutable collections on waitingforcode.com - articles about Scala collections](https://www.waitingforcode.com/scala-collections/scala-mutable-collections/read)

      2. Common methods

         1. filter /find

            The `find` and `filter` methods are commonly used to search and filter elements in collections. The `filter` method creates a new collection containing elements that satisfy a given predicate. A predicate is a function that returns a Boolean value (true or false). The `find` method returns the first element that satisfies a given predicate. If no element satisfies the predicate, it returns `None`.

            *Resources*

            1. [Different Ways to Filter Elements From a Scala Collection | Baeldung on Scala](https://www.baeldung.com/scala/filter-collections)
            2. [Collections Methods | Scala 3 — Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/collections-methods.html)
            3. [Scala Collections Filter | Tutorials Point](https://www.tutorialspoint.com/scala_collections/scala_collections_filter.htm)

         2. foreach

            The `foreach` method is used to apply a function to each element of a collection for its side effects. Unlike methods like `map` or `filter`, `foreach` does not return a value; it is used primarily for operations that have side effects, such as printing elements or modifying external state.

            *Resources*

            1. [for Loops | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/for-loops.html)
            2. [Scala Tutorial - Foreach Function Example](https://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-foreach-example/)
            3. [Using foreach() Method in Scala Collections | Baeldung on Scala](https://www.baeldung.com/scala/foreach-collections)

         3. map

            The `map` method is used to apply a function to each element of a collection and create a new collection with the same number of elements where each element is a result of applying that function to the original element. 

            *Resources*

            1. [Write Your Own map Method | Scala 3 — Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/fun-write-map-function.html)
            2. [A Guide to Scala Maps | Baeldung on Scala](https://www.baeldung.com/scala/maps-guide)
            3. [How to Write a 'map' Function in Scala](https://alvinalexander.com/scala/fp-book/how-to-write-scala-map-function/)

         4. collect / collectFirst

            The `collect` and `collectFirst` methods are used to apply a partial function to elements of a collection. The `collect` method takes a partial function as its parameter and applies it to all the elements in the collection to create a new collection. The new collection contains only those elements that were successfully mapped by the partial function. The `collectFirst` method applies the partial function to the first element in the collection for which the function is defined and returns its result wrapped with `Some`, or `None` if the function is not defined for any element in the collection.

            *Resources*

            1. [Scala Tutorial - Collect Function](https://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-collect-function/)
            2. [collect vs collectFirst - why the return values are of different type - Scala - Stack Overflow](https://stackoverflow.com/questions/40773529/collect-vs-collectfirst-why-the-return-values-are-of-different-type-scala)
            3. [tech: Scala : collectFirst example](http://thushw.blogspot.com/2015/09/scala-collectfirst-example.html)

         5. flatMap

            The `flatMap` method is used to apply a function to each element of a collection and then flatten the results into a new collection. It is essentially a combination of the `map` method followed by the `flatten` method but this seemingly very simple property makes it fundamental for Functional Programming.

            *Resources*

            1. [A collection of Scala 'flatMap' examples](https://alvinalexander.com/scala/collection-scala-flatmap-examples-map-flatten/)
            2. [Scala | flatMap Method - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-flatmap-method/)
            3. [Scala Tutorial - FlatMap Function](https://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-flatmap-function/)

         6. foldLeft

            The `foldLeft` method is used to produce a single result by "folding" all the element of a collection. The algorithm starts with a "zero" element which is paired with the first element of the collection to create an intermediate result element. Then that intermediate result is paire with the second element of the collection to create a new intermediate result, and so on, until the algorithm reaches the end of the collection. Then the final result is returned. 

            *Resources*

            1. [Scala Collections - FoldLeft Method](https://www.tutorialspoint.com/scala_collections/scala_collections_foldleft.htm)
            2. [Folding Lists in Scala | Baeldung on Scala](https://www.baeldung.com/scala/folding-lists)
            3. [Scala Tutorial - FoldLeft Function Example](https://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-foldleft-example/)

   4. Pattern matching

      Pattern matching in Scala is a powerful feature that allows you to check a value against a pattern and deconstruct it into its constituent parts. It is a more powerful version of the switch statement in Java and can be used in place of a series of if/else statements. Pattern matching is particularly useful with algebraic types expressed via case classes.

      *Resources*

      1. [Pattern Matching | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/pattern-matching.html)
      2. [Pattern Matching in Scala | Baeldung on Scala](https://www.baeldung.com/scala/pattern-matching)
      3. [Scala | Pattern Matching - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-pattern-matching/)

      Sub-nodes:

      1. Case classes

         Case classes are a special type of class that is particularly useful for modeling immutable data. They provide several conveniences over regular classes, including immutability, several synthetic methods like `toString`, `equals`, and `copy`, as well as synthetic `apply` and `unapply` methods which make case classes very useful for pattern matching.

         *Resources*

         1. [Case Classes | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/case-classes.html)
         2. [Case Classes | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/case-classes.html)
         3. [Difference Between Class and Case Class in Scala | Baeldung on Scala](https://www.baeldung.com/scala/case-class)

      2. The apply method

         The `apply` function is a so-called smart constructor. It's the most popular way in Scala to create new instances of data types. It's more flexible than a standard constructor because it allows for running certain logic before deciding on if an instance should be created and if yes, it can create an instance of a certain subtype while returning it as an instance of a supertype.

         *Resources*

         1. [What is the apply function in Scala? - Stack Overflow](https://stackoverflow.com/questions/9737352/what-is-the-apply-function-in-scala)
         2. [Apply Method in Scala | Baeldung on Scala](https://www.baeldung.com/scala/apply-method)
         3. [Universal Apply Methods](https://docs.scala-lang.org/scala3/reference/other-new-features/creator-applications.html)

      3. Enums

         In Scala 3, enums are used to define a type consisting of a set of named values. They provide a more concise and safer way to define enumerations compared to the traditional `Enumeration` class in Scala 2.

         *Resources*

         1. [Enumerations | Scala documentation](https://docs.scala-lang.org/scala3/reference/enums/enums.html)
         2. [Enums in Scala 3: Quickly Explained | Rock the JVM](https://rockthejvm.com/articles/enums-in-scala-3)
         3. [Guide to Scala Enumerations | Baeldung on Scala](https://www.baeldung.com/scala/enumerations)

      4. Sealed traits

         Sealed traits are used to define closed hierarchies where all possible subclasses are known. They can be extended only in the same file as their declaration, allowing the compiler to perform exhaustiveness checking. This feature is particularly useful for pattern matching.

         *Resources*

         1. [What is a sealed trait? - Stack Overflow](https://stackoverflow.com/questions/11203268/what-is-a-sealed-trait)
         2. [Scala | Sealed Trait - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-sealed-trait/)
         3. [Sealed Keyword in Scala | Baeldung on Scala](https://www.baeldung.com/scala/sealed-keyword)

      5. Case objects

         Case objects are similar to regular Scala objects but with additional features that they share with case classes - immutable and with synthetic methods. They are often used for creating singleton objects and are particularly useful in pattern matching and message passing.

         *Resources*

         1. [Case Objects | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/case-objects.html)
         2. [Difference between case object and object - Stack Overflow](https://stackoverflow.com/questions/5270752/difference-between-case-object-and-object)
         3. [Difference Between Case Object and Object | Baeldung on Scala](https://www.baeldung.com/scala/case-object-vs-object)

      6. The unapply method

         The `unapply` method is used to deconstruct instances through pattern matching. It is often used in extractor objects to extract data values compacted in objects.

         *Resources*

         1. [Extractor Objects | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/extractor-objects.html)
         2. [Understand how to use apply and unapply - Stack Overflow](https://stackoverflow.com/questions/18468786/understand-how-to-use-apply-and-unapply)
         3. [Scala pattern matching: apply the unapply | by Linas Medžiūnas | Wix Engineering | Medium](https://medium.com/wix-engineering/scala-pattern-matching-apply-the-unapply-7237f8c30b41)

   5. Laziness

      Laziness is a feature that allows you to defer the evaluation of an expression until it is needed. This can be useful for optimizing performance and avoiding unnecessary computations.

      *Resources*

      1. [Understand and implement laziness with examples in Scala, JavaScript, Swift and Racket](https://matt.might.net/articles/implementing-laziness/)
      2. [Let Them Be Lazy! | The Scala Programming Language](https://www.scala-lang.org/blog/2017/11/28/view-based-collections.html)
      3. [Laziness in Scala | InfoWorld](https://www.infoworld.com/article/2072680/laziness-in-scala.html)

      *Sub-nodes*

      1. Lazy vals

         Lazy vals are used to defer the initialization of a variable until it is accessed for the first time. This can be useful for optimizing performance and avoiding unnecessary computations.

         *Resources*

         1. [Guide to lazy val in Scala | Baeldung on Scala](https://www.baeldung.com/scala/lazy-val)
         2. [scala - What does a lazy val do? - Stack Overflow](https://stackoverflow.com/questions/7484928/what-does-a-lazy-val-do)
         3. [Lazy Vals Initialization](https://docs.scala-lang.org/scala3/reference/changed-features/lazy-vals-init.html)

      2. By-name parameters

         By-name parameters are defined using the `=>` symbol before the parameter type. Such a parameter will be evaluated only when it is used inside the method's body. You can think of it as synctatic sugar over a zero-parameter function passed to a method.

         *Resources*

         1. [By-name Parameters | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/by-name-parameters.html)
         2. [How to Use By-Name Parameters in Scala | alvinalexander.com](https://alvinalexander.com/scala/fp-book/how-to-use-by-name-parameters-scala-functions/)
         3. [By-Name Parameters in Scala](https://tpolecat.github.io/2014/06/26/call-by-name.html)

      3. Lazy collections

         Lazy collections are used to describe successive transformation operations without evaluating intermediate transformations. They are particularly useful for creating infinite collections without blowing the memory.

         1. Iterators

            An iterator is a mechanism to access collection's elements sequentially in a performant way. They are often used in loops. On the other hand, they are mutable and uncareful use can lead to non-trivial bugs.

            *Resources*

            1. [Iterators | Collections (Scala 2.8 - 2.12) | Scala Documentation](https://docs.scala-lang.org/overviews/collections/iterators.html)
            2. [Scala - Iterators](https://www.tutorialspoint.com/scala/scala_iterators.htm)
            3. [Iterators in Scala - GeeksforGeeks](https://www.geeksforgeeks.org/scala/iterators-in-scala/)

         2. Views

            Views are used to create lazy versions of collections. They are essentially reusable iterators that implement the same interfaces as regular collections.

            *Resources*

            1. [Views | Collections | Scala Documentation](https://docs.scala-lang.org/overviews/collections-2.13/views.html)
            2. [Views | Collections (Scala 2.8 - 2.12) | Scala Documentation](https://docs.scala-lang.org/overviews/collections/views.html):
            3. [What are views for collections and when would you want to use them? - Stack Overflow](https://stackoverflow.com/questions/3361478/what-are-views-for-collections-and-when-would-you-want-to-use-them)

         3. LazyList

            A lazy list is an immutable linked list that computes its elements only when they are needed. Elements are memoized, meaning the value of each element is computed at most once.

            *Resources*

            1. [LazyList - Scala 3 - EPFL](https://dotty.epfl.ch/api/scala/collection/immutable/LazyList.html)
            2. [LazyList in Scala | Baeldung on Scala](https://www.baeldung.com/scala/lazylist)
            3. [Scala Standard Library 2.13.4 - scala.collection.immutable.LazyList](https://www.scala-lang.org/api/2.13.4/scala/collection/immutable/LazyList.html)

         4. Early returns

            This is a topic that puts together several concepts you already encountered: pattern matching, partial functions, apply and unapply methods, and lazy collections. Its purpose is to let you see how they work together.

            *Resources*

            1. [Many Happy Early Returns](https://makingthematrix.wordpress.com/2021/03/09/many-happy-early-returns/)

   6. Scope & visibility

      1. private / protected

         The `private` and `protected` keywords are used to control the visibility of members (variables and methods) in classes, objects, or packages. If no access modifier is specified, the default access level is public.

         *Resources*

         1. [Understanding Scala Access Modifiers](https://www.tutorialspoint.com/scala/scala_access_modifiers.htm)
         2. [How to control Scala method scope with private, package, and more](https://alvinalexander.com/scala/how-to-control-scala-method-scope-object-private-package/)
         3. [Scala access modifiers and qualifiers in detail](https://www.jesperdj.com/2016/01/08/scala-access-modifiers-and-qualifiers-in-detail/)

      2. package

         The `package` keyword is used to create namespaces that can contain entities such as classes, objects, and other packages. In Scala 2, package objects allow to define functions, variables, and types that are accessible to all members of a package. In Scala 3, it's possible to define all those elements at the top-level, so there is no longer any need to declare package objects.

         *Resources*

         1. [Top Level Definitions in Packages | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/package-objects.html)
         2. [Packaging, Importing and Package Objects in Scala | Baeldung on Scala](https://www.baeldung.com/scala/package-import)
         3. [Scala Package Objects](https://www.tutorialspoint.com/scala/scala_package_objects.htm)

      3. Implicit parameters

         Implicit parameters are a powerful feature that allows you to pass parameters to functions implicitly, without having to explicitly specify them at the call site. This can make your code more concise and readable, especially when dealing with common or boilerplate code. In Scala 2, they were declared with the `implicit` keyword. In Scala 3, we use keywords `given` and `using`. The `given` keyword is used to define instances of implicit values, and the `using` keyword is used to declare context parameters.

         1. [Scala 3: Given and Using Clauses | Rock the JVM](https://rockthejvm.com/articles/scala-3-given-and-using-clauses)
         2. [Scala 3: Using Term Inference with Given and Using (and extension methods) | alvinalexander.com](https://alvinalexander.com/scala/scala-3-given-using-term-inference-context/)
         3. [Using Clauses | Scala documentation](https://docs.scala-lang.org/scala3/reference/contextual/using-clauses.html)

   7. Recursion

      Recursion is a fundamental concept in computer science and mathematics where a function or process calls itself as part of its execution. This approach is particularly useful for tasks that can be defined in terms of similar subtasks, such as traversing tree structures, calculating factorials, or solving problems that exhibit self-similarity.

      In Scala, recursion is supported on many levels. It is, of course, possible for a function to recursively call itself. Additionally, the Scala compiler uses tail recursion to rewrite a subset of recursive functions into flat loops, and the Scala standard library contains "trampolines" - a mechanism to simulate recursion without the risk of stack overflow. On top of that, Scala pattern matching helps to write recursive functions in a readable way, and implicit parameters help to keep the code concise.

      1. Recursion basics

         Learn the basics of recursion with the following materials.

         *Resources*

         1. [Scala Recursion Functions](https://www.tutorialspoint.com/scala/recursion_functions.htm)
         2. [Simple Scala recursion examples (recursive programming) | alvinalexander.com](https://alvinalexander.com/scala/scala-recursion-examples-recursive-programming/)
         3. [Scala Tutorial | Tail Recursion](https://www.scala-exercises.org/scala_tutorial/tail_recursion)

      2. Tail recursion

         Tail recursion is a special form of recursion where the recursive call is the last operation in the function. This allows the Scala compiler to optimize the recursion to prevent stack overflow and improve performance.

         *Resources*

         1. [Tail Recursion in Scala | Baeldung on Scala](https://www.baeldung.com/scala/tail-recursion)
         2. [Scala Tutorial | Tail Recursion](https://www.scala-exercises.org/scala_tutorial/tail_recursion)
         3. [Writing Tail-Recursive Algorithms in Scala (and the tailrec annotation) | alvinalexander.com](https://alvinalexander.com/scala/fp-book/tail-recursive-algorithms/)

      3. Trampolines

         Trampolines in Scala are used to avoid stack overflow errors in deep recursion by moving the computation from the stack to the heap. The `TailRec` class is part of the `scala.util.control.TailCalls`  and is used to implement trampolining.

         *Resources*

         1. [Recursion and Trampolines in Scala · GitHub](https://gist.github.com/eamelink/4466932a11d8d92a6b76e80364062250)
         2. [Tail calls, @tailrec and trampolines](https://rd.nz/2009/04/tail-calls-tailrec-and-trampolines.html)
         3. [How Trampoline Works in Scala](https://free.cofree.io/2017/08/24/trampoline/)

   8. Error handling

      Scala offers multiple ways to handle errors, including try/catch/finally blocks, Option, Either, and Try. These methods allow developers to handle exceptions and errors in a functional and composable way.

      *Resources*

      1. [Functional Error Handling in Scala | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/functional-error-handling.html)
      2. [Error Handling in Scala](https://www.baeldung.com/scala/error-handling)
      3. [Idiomatic Error Handling in Scala | Rock the JVM](https://rockthejvm.com/articles/idiomatic-error-handling-in-scala)

      *Sub-nodes*

      1. Option

         The `Option` class in Scala is used to represent optional values. It is a carrier of single or no element for a stated type, and is particularly useful for handling cases where a value might be null.

         *Resources*

         1. [The Option Type in Scala | Baeldung on Scala](https://www.baeldung.com/scala/option-type)
         2. [Scala | Option - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-option/)
         3. [Scala Standard Library 2.13.3 - scala.Option](https://www.scala-lang.org/api/2.13.3/scala/Option.html)

      2. Either

         The `Either` class in Scala is used to represent a value of one of two possible types (a disjoint union). An instance of `Either` is either an instance of `scala.util.Left` or `scala.util.Right`.

         *Resources*

         1. [Scala Standard Library 2.13.6 - scala.util.Either](https://www.scala-lang.org/api/2.13.6/scala/util/Either.html)
         2. [Scala - Either class | by zeesh.arif | Medium](https://zeesh-arif.medium.com/scala-either-class-ca6cb44c3643)
         3. [A Scala Either, Left, and Right example (like Option, Some, and None) | alvinalexander.com](https://alvinalexander.com/scala/scala-either-left-right-example-option-some-none-null/)

      3. Try

         The `Try` class in Scala represents a computation that may fail during evaluation by raising an exception. It holds either a successfully computed value or the exception that was thrown.

         *Resources*

         1. [Scala Standard Library 2.13.6 - scala.util.Try](https://www.scala-lang.org/api/2.13.6/scala/util/Try.html)
         2. [A Scala Try, Success, and Failure example | alvinalexander.com](https://alvinalexander.com/source-code/scala/scala-try-success-and-failure-example/)
         3. [Handling Exceptions using Try/Catch/Finally in Scala | ScalaJobs.com](https://scalajobs.com/blog/handling-exceptions-using-try-catch-finally-in-scala)

      4. for-comprehensions

         For-comprehensions in Scala are used to evaluate expressions and return a sequence of values. They have the form `for (enumerators) yield e`, where enumerators refer to a list of enumerators. They are basically syntax sugar over `flatMap` but they help a lot in making your code both safe and concise.

         1. [For Comprehensions | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/for-comprehensions.html)
         2. [A Comprehensive Guide to For-Comprehension in Scala | Baeldung on Scala](https://www.baeldung.com/scala/for-comprehension)
         3. [Scala: comprehending the for-comprehension | by Linas Medžiūnas | Wix Engineering | Medium](https://medium.com/wix-engineering/scala-comprehending-the-for-comprehension-67c9f7953655)