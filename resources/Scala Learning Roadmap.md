# Scala Learning Roadmap

This is a temporary file with contents for nodes in [Scala Learning Roadmap](https://roadmap.sh/r/scala-learning-path). In time, it should be integrated into the roadmap itself. 

1. Pick your IDE

   1. Mainstream

      There are two big Integrated Development Environments, most popular among Scala developers: IntelliJ IDEA and VS Code. You can install them and use them for free. To make them support Scala, you need to add plugins to them: respectively, IntelliJ Scala Plugin for IntelliJ IDEA and Metals for VS Code 

      1. IntelliJ Idea w/ Scala Plugin

         IntelliJ IDEA is a popular integrated development environment (IDE) that offers support for Scala through its Scala Plugin. This plugin provides essential features for Scala development, including code completion, refactoring, debugging, and seamless integration with build tools like sbt and Maven. 

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

         Vim is a highly configurable text editor known for its efficiency and features. When equipped with the Metals plugin, Vim becomes a capable environment for Scala development, offering features like code completion, refactoring, and debugging. 

         *Resources*

         1. [Vim Main Page](https://www.vim.org/)
         2. [Vim | Scalameta](https://scalameta.org/metals/docs/editors/vim/)

      2. Emacs

         Emacs is a highly extensible and customizable text editor known for its features and flexibility. When equipped with the Metals plugin, Emacs becomes a robust environment for Scala development, offering features like code completion, refactoring, and debugging.

         *Resources*

         1. [Emacs Main Page](https://www.gnu.org/software/emacs/)
         2. [Emacs | Scalameta](https://scalameta.org/metals/docs/editors/emacs/)

      3. Zed

         Zed is a modern, lightweight, and highly performant code editor designed for efficiency and ease of use. It offers features like real-time collaboration, a minimalistic interface, and editing capabilities. While Zed is not specifically designed for Scala development, its extensibility and support for various programming languages make it a versatile tool for developers. With the Metals plugin, Zed provides intelligent code completion, diagnostics, and refactoring capabilities for Scala.

         *Resources*

         1. [Scala Editor - Zed](https://zed.dev/languages/scala)

      4. Sublime Text

         Sublime Text is a sophisticated text editor known for its speed, ease of use, and features. It supports a wide range of programming languages, including Scala, through plugins and packages. Sublime Text offers features like multiple selections, command palette, and extensive customization options, making it a popular choice for developers. With the Metals plugin, Sublime Text provides intelligent code completion, diagnostics, and refactoring capabilities for Scala.

         *Resources*

         1. [Sublime Text](https://www.sublimetext.com/)
         2. [Sublime Text | Scalameta](https://scalameta.org/metals/docs/editors/sublime/)

2. Find resources --- these nodes already have contents

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

         In Scala, functions can return other functions. Currying is the process of converting a function with multiple arguments into a sequence of functions that take one argument each. Function composition is the process of combining two or more functions to create a new function.

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

      1. match / case

         Pattern matching with match/case allows you to check a value against a pattern and deconstruct it into its constituent parts. It is a more powerful version of the switch statement in Java and can be used in place of a series of if/else statements. Pattern matching is particularly useful with algebraic types expressed via case classes.

         *Resources*

         1. [Pattern Matching | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/pattern-matching.html)
         2. [Pattern Matching in Scala | Baeldung on Scala](https://www.baeldung.com/scala/pattern-matching)
         3. [Scala | Pattern Matching - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-pattern-matching/)

      2. Case classes

         Case classes are a special type of class that is particularly useful for modeling immutable data. They provide several conveniences over regular classes, including immutability, several synthetic methods like `toString`, `equals`, and `copy`, as well as synthetic `apply` and `unapply` methods which make case classes very useful for pattern matching.

         *Resources*

         1. [Case Classes | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/case-classes.html)
         2. [Case Classes | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/case-classes.html)
         3. [Difference Between Class and Case Class in Scala | Baeldung on Scala](https://www.baeldung.com/scala/case-class)

      3. The apply method

         The `apply` function is a so-called smart constructor. It's the most popular way in Scala to create new instances of data types. It's more flexible than a standard constructor because it allows for running certain logic before deciding on if an instance should be created and if yes, it can create an instance of a certain subtype while returning it as an instance of a supertype.

         *Resources*

         1. [What is the apply function in Scala? - Stack Overflow](https://stackoverflow.com/questions/9737352/what-is-the-apply-function-in-scala)
         2. [Apply Method in Scala | Baeldung on Scala](https://www.baeldung.com/scala/apply-method)
         3. [Universal Apply Methods](https://docs.scala-lang.org/scala3/reference/other-new-features/creator-applications.html)

      4. Enums

         In Scala 3, enums are used to define a type consisting of a set of named values. They provide a more concise and safer way to define enumerations compared to the traditional `Enumeration` class in Scala 2.

         *Resources*

         1. [Enumerations | Scala documentation](https://docs.scala-lang.org/scala3/reference/enums/enums.html)
         2. [Enums in Scala 3: Quickly Explained | Rock the JVM](https://rockthejvm.com/articles/enums-in-scala-3)
         3. [Guide to Scala Enumerations | Baeldung on Scala](https://www.baeldung.com/scala/enumerations)

      5. Sealed traits

         Sealed traits are used to define closed hierarchies where all possible subclasses are known. They can be extended only in the same file as their declaration, allowing the compiler to perform exhaustiveness checking. This feature is particularly useful for pattern matching.

         *Resources*

         1. [What is a sealed trait? - Stack Overflow](https://stackoverflow.com/questions/11203268/what-is-a-sealed-trait)
         2. [Scala | Sealed Trait - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-sealed-trait/)
         3. [Sealed Keyword in Scala | Baeldung on Scala](https://www.baeldung.com/scala/sealed-keyword)

      6. Case objects

         Case objects are similar to regular Scala objects but with additional features that they share with case classes - immutable and with synthetic methods. They are often used for creating singleton objects and are particularly useful in pattern matching and message passing.

         *Resources*

         1. [Case Objects | Scala Book | Scala Documentation](https://docs.scala-lang.org/overviews/scala-book/case-objects.html)
         2. [Difference between case object and object - Stack Overflow](https://stackoverflow.com/questions/5270752/difference-between-case-object-and-object)
         3. [Difference Between Case Object and Object | Baeldung on Scala](https://www.baeldung.com/scala/case-object-vs-object)

      7. The unapply method

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

         Implicit parameters are passed to functions without having to explicitly specify them at the call site. This can make your code more concise and readable, especially when dealing with common or boilerplate code. In Scala 2, they were declared with the `implicit` keyword. In Scala 3, we use keywords `given` and `using`. The `given` keyword is used to define instances of implicit values, and the `using` keyword is used to declare context parameters.

         1. [Scala 3: Given and Using Clauses | Rock the JVM](https://rockthejvm.com/articles/scala-3-given-and-using-clauses)
         2. [Scala 3: Using Term Inference with Given and Using (and extension methods) | alvinalexander.com](https://alvinalexander.com/scala/scala-3-given-using-term-inference-context/)
         3. [Using Clauses | Scala documentation](https://docs.scala-lang.org/scala3/reference/contextual/using-clauses.html)

   7. Recursion

      1. Recursion basics

         Recursion is a fundamental concept in computer science and mathematics where a function or process calls itself as part of its execution. This approach is particularly useful for tasks that can be defined in terms of similar subtasks, such as traversing tree structures, calculating factorials, or solving problems that exhibit self-similarity.

         In Scala, recursion is supported on many levels. It is, of course, possible for a function to recursively call itself. Additionally, the Scala compiler uses tail recursion to rewrite a subset of recursive functions into flat loops, and the Scala standard library contains "trampolines" - a mechanism to simulate recursion without the risk of stack overflow. On top of that, Scala pattern matching helps to write recursive functions in a readable way, and implicit parameters help to keep the code concise.

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

4. Choose your build tool

   1. Scala-centered
      These build tools were created specifically for Scala projects. sbt and Mill can work with Java and Kotlin as well. ScalaCLI is ideal for small projects and scripts due to its simplicity. sbt is highly configurable and extensible, making it suitable for large and complex projects. Mill offers a balance between simplicity and power, making it a good choice for small to medium-sized projects.

      *Sub-nodes*

      1. ScalaCLI
         ScalaCLI is a command-line tool designed to simplify the process of learning and using Scala. It is optimized for speed and ease of use, making it ideal for scripts, playgrounds, and single-module projects. ScalaCLI manages its own dependencies and supports features like incremental compilation and dependency resolution. It does not require a configuration file, and all configurations can be provided through directives embedded in Scala files or via command-line arguments.

         *Resources*

         1. [Scala CLI Official Documentation](https://scala-cli.virtuslab.org/)
         2. [Introduction to Scala-CLI on Baeldung](https://www.baeldung.com/scala/scala-cli-intro)
         3. [Scala CLI GitHub Repository](https://github.com/VirtusLab/scala-cli)
         4. [Getting Started with Scala CLI](https://scala-cli.virtuslab.org/docs/getting_started/)

      2. sbt
         sbt (Scala Build Tool) is a build tool designed for Scala and Java projects. It allows developers to define tasks in Scala and run them in parallel from an interactive shell. sbt is known for its incremental compilation feature, which updates only the parts of the project that have changed, saving time and improving efficiency. It supports a wide range of plugins for tasks like packaging, releasing, and deploying software. sbt is highly configurable and extensible, making it suitable for projects of all sizes, from small applications to large, complex systems.

         *Resources*

         1. [sbt Official Documentation](https://www.scala-sbt.org/learn.html)
         2. [sbt in Action Book](https://www.manning.com/books/sbt-in-action)
         3. [Introduction to SBT on Baeldung](https://www.baeldung.com/scala/sbt-intro)
         4. [Scala Book: sbt Overview](https://docs.scala-lang.org/overviews/scala-book/scala-build-tool-sbt.html)

      3. Mill

         Mill is a build tool designed for Java, Scala, and Kotlin projects. It focuses on speed and efficiency by automatically caching and parallelizing build tasks and tests. Mill uses a long-lived daemon to keep the JVM warm, which helps in maintaining fast build times. It also supports selective test execution to shorten CI times. Mill is designed to be simple and intuitive, making it a good choice for both small and medium-sized projects.

         Even though Mill supports other programming languages, it started as a Scala build tool and its script files are in Scala - that's why it's in the "Scala-centered" category.

         *Resources*

         1. [Mill Official Documentation](https://mill-build.org/mill/index.html)

   2. Common to JVM
      Gradle and Maven are both popular build tools for Scala projects. They handle dependency management well and automate tasks like compiling code, running tests, and packaging artifacts. Both integrate with common development tools. However, Gradle uses a Groovy-based DSL, which is more flexible and easier to read than Maven's XML configuration. Gradle is usually faster because it only recompiles what's needed. It also allows for more customization with tasks and plugins written in Groovy or Kotlin. While Maven has a larger library repository, Gradle's performance and flexibility make it a preferred choice for many Scala projects. The choice between them depends on the project's specific needs.

      1. Gradle

         Gradle is widely used for building, testing, publishing, and deploying software packages. It is known for its flexibility and efficiency in managing dependencies and resolving version conflicts. Gradle uses a Groovy-based Domain Specific Language (DSL) for writing build scripts, making it more flexible and readable compared to XML-based build tools like Maven. Gradle supports incremental builds and build caching, which can significantly speed up the build process. It is commonly used for Java, Kotlin, and Android projects but can also be used for Scala.

         *Resources*

         1. [Gradle Guides](https://gradle.org/guides/)
         2. [Gradle Fundamentals on Udemy](https://www.udemy.com/course/gradle-fundamentals/)
         3. [Gradle Tutorial on TutorialsPoint](https://www.tutorialspoint.com/gradle/index.htm)
         4. [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html)

      2. Maven

         Maven is a build automation and dependency management tool primarily used for Java projects. It simplifies the build process by using a Project Object Model (POM) file, typically named `pom.xml`, which centralizes project configuration and manages dependencies. Maven follows best practices and conventions to ensure consistent project setups, making it easier for developers to understand and manage projects. It integrates well with other tools like IDEs (Eclipse, IntelliJ IDEA) and version control systems (Git). Maven's key features include dependency management, build automation, and a large repository of libraries and metadata.

         *Resources*

         1. [Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
         2. [Maven Tutorial on TutorialsPoint](https://www.tutorialspoint.com/maven/index.htm)
         3. [Apache Maven Tutorial on Baeldung](https://www.baeldung.com/maven)
         4. [Maven Complete Tutorial for Beginners on DEV Community](https://dev.to/saiupadhyayula/maven-complete-tutorial-for-beginners-1jek)

5. Know your ecosystem

   Ecosystems in Scala are groups of frameworks and libraries that work well together and are often maintained and developed by the same organization. While there's nothing stopping you from choosing any framework or library from the wide spectrum of Scala open-source projects, it often makes sense to stick to those that belong to the same ecosystem unless you have a good reason to pick another. Of course, you’re also free to use one ecosystem in one project and another in a different project.

   Click on each of the following nodes, read the descriptions, follow the links to resources, and form your own opinion.

   1. Cats

      Cats provides core abstractions for functional programming in Scala. It aims to be modular, approachable, and efficient, while providing a foundation for an ecosystem of pure, typeful libraries. Cats Effect, a part of the Cats ecosystem, offers a pure asynchronous runtime for Scala, enabling developers to build scalable and resilient applications. The ecosystem includes libraries for streaming frameworks, database layers, HTTP servers and clients, and more.

      *Resources*

      1. [Cats Effect Documentation](https://typelevel.org/cats-effect/)
      2. [Cats GitHub Repository](https://github.com/typelevel/cats)
      3. [Cats Tutorial on Baeldung](https://www.baeldung.com/scala/cats-intro)
      4. [Cats Course on Rock the JVM](https://rockthejvm.com/courses/cats)

   2. ZIO

      ZIO is a Scala framework designed for asynchronous and concurrent programming. It emphasizes type safety, composability, and resource safety, making it suitable for building scalable and resilient applications. The ZIO ecosystem includes libraries for HTTP, logging, configuration, streams, and testing, all built on top of ZIO's effect system. ZIO's fibers are lightweight and non-blocking, providing high performance and scalability.

       *Resources*

      1. [ZIO Official Website](https://zio.dev/)
      2. [ZIO GitHub Repository](https://github.com/zio/zio)
      3. [Introduction to ZIO on Baeldung](https://www.baeldung.com/scala/zio-intro)
      4. [ZIO Course on Rock the JVM](https://rockthejvm.com/courses/zio)

   3. Li Haoyi

      The Li Haoyi ecosystem is centered around making Scala easy to use and productive. It includes libraries like Ammonite REPL, Mill Build Tool, os-lib, uPickle, Cask, and Scalatags. This ecosystem emphasizes executable pseudocode, ease of use, and productivity. It is designed to allow developers to write Scala in a way that is easy and productive, delivering real business value. The ecosystem is maintained by Li Haoyi and is known for its simplicity and practicality.

       *Resources*

      1. [Li Haoyi's Programming Blog](http://www.lihaoyi.com/)
      2. [12 Years of the com.lihaoyi Scala Platform](https://www.lihaoyi.com/post/12yearsofthecomlihaoyiScalaPlatform.html)
      3. [Hands-on Scala Programming](https://www.handsonscala.com/)
      4. [com-lihaoyi GitHub Repository](https://github.com/com-lihaoyi)

   4. Akka / Pekko

      Akka and Pekko are toolkits for building concurrent, distributed, and resilient applications on the JVM using Scala. Akka, originally developed by Lightbend, introduced a actor model for managing concurrency, inspired by Erlang. It provides abstractions for building scalable and fault-tolerant systems. Pekko is an open-source fork of Akka, created after Akka's licensing changes, and continues to provide similar functionality under the Apache License. Both toolkits support the actor model, which simplifies the development of highly concurrent and distributed applications. They also offer additional modules for HTTP, streaming, clustering, and persistence, making them suitable for a wide range of applications, from microservices to large-scale distributed systems.

       *Resources*

      1. [Apache Pekko Official Website](https://pekko.apache.org/)
      2. [Akka Documentation on Wikipedia](https://en.wikipedia.org/wiki/Akka_(toolkit))
      3. [Akka/Pekko Essentials Course on Rock the JVM](https://rockthejvm.com/courses/akka-apache-pekko-essentials-with-scala)
      4. [Introduction to Apache Pekko on Baeldung](https://www.baeldung.com/scala/apache-pekko)

   5. No ecosystem

      The Scala open-source landscape outside of the major ecosystems often focuses on niche use cases or innovative ideas that may not be covered by the larger frameworks. Projects in this space can range from specialized tools for data science, machine learning, and web development to unique solutions for testing, build management, and database connectivity. These projects are frequently driven by individual developers or small communities.

6. Know your platform

   A platform is a runtime environment in which code is compiled and executed. Scala is primarily known as a JVM language, alongside Java and Kotlin. Scala code is compiled into the same bytecode as these languages and runs in the Java Runtime Environment (JRE), which provides independence from specific machine configurations and features such as garbage collection.

   However, there are at least two other platforms where Scala code can be run: Scala Native, which aims to compile Scala directly to machine code, bypassing the JRE, and Scala.js, which transpiles Scala code to JavaScript, allowing it to run in web browsers.

   1. JVM

      Scala's primary platform is the Java Virtual Machine (JVM). Scala code is compiled into Java bytecode, allowing it to run on any device with a JVM, independent of the underlying machine configuration. This setup ensures compatibility with Java libraries and tools, making Scala a versatile choice for developers familiar with the Java ecosystem. The JVM's backward compatibility ensures that Scala code compiled on older versions can run on newer JVMs without issues.

      *Resources*

      1. [TutorialsPoint: Understanding Java JDK, JRE, and JVM](https://www.tutorialspoint.com/java/java-jdk-jre-jvm.htm)
      2. [Scala Documentation on JDK Compatibility](https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html)
      3. [Scala and JVM Basics on Toptal](https://www.toptal.com/scala/scala-bytecode-and-the-jvm)

   2. Scala Native

      Scala Native is an optimizing ahead-of-time compiler and lightweight managed runtime designed specifically for Scala. By leveraging LLVM, Scala Native compiles Scala code directly to native executables, eliminating the need for a Java Virtual Machine (JVM). This results in faster startup times and smaller memory footprints, making it suitable for environments where performance and resource efficiency are critical. Scala Native also offers interoperability with C libraries, allowing developers to integrate with existing native libraries seamlessly. The compilation process involves converting Scala code to an intermediate format called Native Intermediate Representation (NIR), which is then transformed into an LLVM IR file for execution. The project is supported by the École polytechnique fédérale de Lausanne (EPFL) and has a growing community of contributors.

      *Resources*

      1. [Scala Native GitHub Repository](https://github.com/scala-native/scala-native)
      2. [Scala Native Documentation](https://scala-native.org/)
      3. [Getting Started with Scala Native: A Comprehensive Guide for Beginners](https://medium.com/@diehardankush/getting-started-with-scala-native-a-comprehensive-guide-for-beginners-dedafeed7f25)
      4. [Building Native Applications in Scala Using Scala Native | Baeldung on Scala](https://www.baeldung.com/scala/native-apps-scala-native)

   3. GraalVM Native Image

      GraalVM Native Image is a tool that compiles Java applications into native binary executables using ahead-of-time (AOT) compilation. When used with Scala, it can significantly improve the performance and startup time of Scala applications by eliminating the need for a JVM at runtime. The process involves using plugins like sbt-native-image, which automates the installation of GraalVM and the generation of native binaries. However, configuring GraalVM for Scala applications can be challenging due to the need to handle reflection and other dynamic features used by Scala libraries. 

      *Resources*

      1. [GraalVM with Scala | Baeldung on Scala](https://www.baeldung.com/scala/graalvm)
      2. [Packaging as GraalVM native images ⚡ | Scala CLI](https://scala-cli.virtuslab.org/docs/cookbooks/package/native-images/)
      3. [GitHub - scalameta/sbt-native-image: Plugin to generate native-image binaries with sbt](https://github.com/scalameta/sbt-native-image)
      4. [GraalVM Native Image · Cats Effect](https://typelevel.org/cats-effect/docs/core/native-image)

   4. Scala.js

      Scala.js is a Scala compiler that compiles Scala code to JavaScript, enabling Scala programs to run in web browsers or Node.js. It optimizes Scala code into highly efficient JavaScript, ensuring fast turn-around times with incremental compilation. Scala.js provides strong typing, which catches typos and type-errors immediately, making the development process more reliable and efficient. It also offers seamless interoperability with JavaScript libraries, allowing developers to use popular libraries like React and AngularJS directly from their Scala.js code. This makes it easier to leverage existing JavaScript ecosystems while benefiting from Scala's type system and tooling. Additionally, Scala.js supports full-stack development by allowing code to be shared between the frontend and backend, ensuring consistency and reducing the risk of mismatches.

      *Resources*

      1. [Scala.js Official Website](https://www.scala-js.org/)
      2. [Hands-on Scala.js](https://www.lihaoyi.com/hands-on-scala-js/)
      3. [Introduction to Scala.js | Baeldung on Scala](https://www.baeldung.com/scala/scala-js)
      4. [The importance of Scala.js](https://www.scalawilliam.com/importance-scalajs/)

7. Browse frameworks and libraries -- each node about a framework or library should already have a link to its official website if one exists. Please leave that link as the first resource and just add the ones I provide here below.

   1. Testing

      1. Unit testing

         Unit testing is a software testing method where individual components or units of a program are tested in isolation from the rest of the application. The purpose of unit testing is to validate that each unit of the software is working as intended. A unit can be a single function, method, procedure, module, or object. By testing units in isolation, developers can ensure that each part of the program behaves correctly on its own, making it easier to identify and fix bugs early in the development process. Unit tests are typically written and executed by developers themselves, and they often use testing frameworks like JUnit, ScalaTest, or uTest to automate the process. This approach not only helps in catching bugs early but also simplifies the debugging process, as issues can be traced back to specific units of code.

         1. ScalaTest

            ScalaTest is a flexible and comprehensive testing framework for Scala. It integrates with various tools like JUnit, TestNG, Ant, Maven, sbt, ScalaCheck, and mocking frameworks such as Mockito and ScalaMock. ScalaTest allows you to choose from multiple testing styles, such as FlatSpec, FunSuite, and FunSpec, to fit your team's preferences and project requirements. It is widely used for testing Scala, Scala.js, Scala Native, Dotty (Scala 3), and Java code.

            *Resources*

            1. [ScalaTest Official Website](https://www.scalatest.org/)
            2. [Introduction to Testing With ScalaTest | Baeldung on Scala](https://www.baeldung.com/scala/scalatest)
            3. [Unit testing in scala using scalatest | by Harshal Patel | Medium](https://hrpatel6699.medium.com/unit-testing-in-scala-using-scalatest-a73319c094f6)
            4. [Scala Testing with ScalaTest: A Beginner's Guide to Testing Styles | Rock the JVM](https://rockthejvm.com/articles/scala-testing-with-scalatest-a-beginners-guide-to-testing-styles)

         2. JUnit

            JUnit is a popular open-source unit testing framework for Java. It is part of the xUnit family and is designed to help developers write and run repeatable tests. JUnit is widely used for unit testing and supports various types of tests, including integration tests. It is trusted by millions of developers worldwide and is known for its simplicity and effectiveness in ensuring code quality.

            *Resources*

            1. [JUnit 5 tutorial - Learn how to write unit tests](https://www.vogella.com/tutorials/JUnit/article.html)
            2. [Introduction of JUnit - GeeksforGeeks](https://www.geeksforgeeks.org/advance-java/introduction-of-junit/)
            3. [A Guide to JUnit 5 | Baeldung](https://www.baeldung.com/junit-5)

         3. mUnit

            MUnit is a Scala testing library that offers actionable errors and extensible APIs. It is designed to provide clear and helpful error messages when tests fail, making it easier to debug and fix issues. MUnit allows you to run test suites directly from your IDE, whether it's IntelliJ, VS Code, or any other LSP editor.

            *Resources*

            1. [Testing with MUnit | The Scala Toolkit | Scala Documentation](https://docs.scala-lang.org/toolkit/testing-intro.html)
            2. [Getting started · MUnit](https://scalameta.org/munit/docs/getting-started.html)
            3. [Introduction to MUnit | Baeldung on Scala](https://www.baeldung.com/scala/munit-introduction)

         4. uTest

            uTest is a simple and convenient testing library for Scala. It provides essential features in their minimal form, avoiding unnecessary complexity. uTest allows you to organize tests in a hierarchical structure and run them at various levels, from individual tests to entire suites. It is designed to be straightforward and easy to use, making it a good choice for developers who want to focus on writing tests without dealing with excessive configurations or features.

            *Resources*

            1. [GitHub - com-lihaoyi/utest: A simple testing framework for Scala](https://github.com/com-lihaoyi/utest)
            2. [Introduction to uTest | Baeldung on Scala](https://www.baeldung.com/scala/utest-intro)
            3. [Unit testing with Scala: Libraries landscape | by Ivan Kurchenko | Medium](https://ivan-kurchenko.medium.com/testing-with-scala-libraries-landscape-61b4c6403455)

         5. ZIO Test

            ZIO Test is a testing library for Scala that makes it easy to test effectual programs. It is tightly integrated with ZIO, allowing tests to be treated as immutable values, which simplifies testing asynchronous and concurrent code. ZIO Test provides features like resource management, property-based testing, and support for various platforms including JVM, ScalaJS, Dotty, and Scala Native.

            *Resources*

            1. [Introduction to ZIO Test | ZIO](https://zio.dev/reference/test/)
            2. [Testing ZIO Applications Using ZIO Test | Baeldung on Scala](https://www.baeldung.com/scala/zio-test)
            3. [Test Aspects in ZIO Test | Baeldung on Scala](https://www.baeldung.com/scala/zio-test-aspects)

         6. specs2

            specs2 is a library for writing executable software specifications in Scala. It allows you to write specifications for individual classes (unit specifications) or entire systems (acceptance specifications). specs2 is designed to work with SBT and integrates with various testing styles and frameworks.

            *Resources*

            1. [Specs2 - Testing in Scala Book](https://www.oreilly.com/library/view/testing-in-scala/9781449360313/ch04.html)
            2. [Specs2 - Scalatra](https://scalatra.org/guides/2.6/testing/specs2.html)
            3. [How to make working with Specs2 much easier - Scalac](https://scalac.io/blog/specs2-working-testing/)

      2. Integration / performance testing

         Integration testing checks if different parts of a Scala app work together correctly, often using tools like ScalaTest. Performance testing measures how fast and stable the app is under load, using tools like JMH. Unit testing, in contrast, tests small pieces of code (like functions) in isolation to ensure they work as intended. Together, these testing methods help build reliable and efficient Scala applications.

         1. ScalaTest

            ScalaTest is a versatile testing framework for Scala that helps programmers write both integration and performance tests. For integration testing, ScalaTest allows you to test the interactions between different components of your application, such as APIs, databases, or services, ensuring they work together as expected. You can use ScalaTest with mocking libraries like ScalaMock to simulate external dependencies, making it easier to isolate and test specific parts of your system. For performance testing, while ScalaTest itself isn't designed for benchmarking, you can use it to verify that your code meets performance requirements by measuring execution times and validating response times.

            *Resources*

            1. [ScalaTest Official Website](https://www.scalatest.org/)
            2. [Introduction to Testing With ScalaTest | Baeldung on Scala](https://www.baeldung.com/scala/scalatest)
            3. [Unit testing in scala using scalatest | by Harshal Patel | Medium](https://hrpatel6699.medium.com/unit-testing-in-scala-using-scalatest-a73319c094f6)
            4. [Scala Testing with ScalaTest: A Beginner's Guide to Testing Styles | Rock the JVM](https://rockthejvm.com/articles/scala-testing-with-scalatest-a-beginners-guide-to-testing-styles)

         2. Gatling

            Gatling is an open-source tool for performance and load testing, particularly well-suited for testing web applications. It is built on Scala, Akka, and Netty, and allows you to write test scenarios using expressive SDKs in Scala, Java, Kotlin, JavaScript, or TypeScript. Gatling is designed to be high-performance and can simulate thousands of concurrent users with minimal system resources. It provides detailed reports and integrates well with CI/CD pipelines.

            *Resources*

            1. [Gatling documentation](https://docs.gatling.io/)
            2. [Testing With Gatling Using Scala | Baeldung on Scala](https://www.baeldung.com/scala/gatling-load-testing)
            3. [Distributed Performance Testing with Gatling | Baeldung](https://www.baeldung.com/gatling-distributed-perf-testing)
            4. [Load Testing in Java, Kotlin and Scala | Gatling Blog](https://gatling.io/blog/java-kotlin-or-scala-which-gatling-flavor-is-right-for-you)

   2. Effect systems

      An effect system is a programming paradigm that helps manage side effects in a controlled and predictable manner. In functional programming, side effects - such as input/output operations, state changes, or exceptions - can introduce complexity and make code harder to reason about. An effect system allows developers to explicitly declare and handle these side effects, making the code more modular, testable, and maintainable. By separating the description of what a program should do from the actual execution of those actions, effect systems enable better composition and reasoning about program behavior. 

      1. Cats Effect

         Cats Effect is a high-performance, asynchronous, composable framework for building real-world applications in a purely functional style within the Typelevel ecosystem. It provides a concrete tool, known as "the IO monad," for capturing and controlling actions, often referred to as "effects," that your program wishes to perform within a resource-safe, typed context with seamless support for concurrency and coordination. Cats Effect is designed to be fast, reliable, and community-driven, offering strong guarantees and functionality for managing resources, handling concurrency, and ensuring program safety.

         *Resources*

         1. [Cats Effect · The pure asynchronous runtime for Scala](https://typelevel.org/cats-effect/)[GitHub - typelevel/cats-effect: The pure asynchronous runtime for Scala](https://github.com/typelevel/cats-effect)
         2. [Learning Cats Effects — Undertstanding Effects 😼 | by Francisco Perrotta | Medium](https://medium.com/@PerrottaFrancisco/learning-cats-effects-undertstanding-effects-e9291c15f9ba)
         3. [Resource Handling in Cats Effect | Baeldung on Scala](https://www.baeldung.com/scala/cats-effect-resource-handling)

      2. ZIO

         ZIO is a Scala framework for asynchronous and concurrent programming. It is designed to be type-safe, composable, and highly scalable, allowing developers to build safe applications. ZIO provides a comprehensive set of tools for managing resources, handling concurrency, and ensuring program safety. It leverages the full power of the Scala compiler to catch bugs at compile time and allows for easy construction of concurrent applications without deadlocks, race conditions, or complexity.

         *Resources*

         1. [Introduction to ZIO | Baeldung on Scala](https://www.baeldung.com/scala/zio-intro)
         2. [GitHub - zio/zio: ZIO — A type-safe, composable library for async and concurrent programming in Scala](https://github.com/zio/zio)
         3. [What is ZIO? - Overview, Benefits and Case Studies](https://scalac.io/zio/)

   3. Backend

      Backend software development in the context of programming in Scala involves creating and maintaining the server-side components of applications that handle business logic, data processing, and communication with databases or other services. Frameworks like Akka, Play, and http4s are commonly used in the Scala ecosystem to build high-performance backend services. These tools leverage Scala's strengths to provide solutions that are both maintainable and capable of handling the demands of modern web applications.

      1. Finatra

         Finatra is a lightweight framework for building fast, testable Scala applications on top of TwitterServer and Finagle. It is designed to be easy to use and provides an API for creating and testing Finagle servers and apps, as well as JSON support, modern logging via SLF4J, and Finagle client utilities. Finatra is an open-source project actively developed and maintained by Twitter and other organizations.

         *Resources*

         1. [User’s Guide | Finatra 24.2.0 documentation](https://twitter.github.io/finatra/user-guide/)
         2. [Example Projects | Finatra 24.2.0 documentation](https://twitter.github.io/finatra/user-guide/getting-started/examples.html)

      2. Scalatra

         Scalatra is a lightweight, Sinatra-like web framework for Scala. It is designed to be simple, accessible, and easy to use, making it a practical way to learn Scala and build high-performance web sites and APIs.

         *Resources*

         1. [GitHub - scalatra/scalatra: Tiny Scala high-performance, async web framework, inspired by Sinatra](https://github.com/scalatra/scalatra)
         2. [Getting started with Scalatra](https://scalatra.org/getting-started/first-project.html)

      3. sttp

         sttp is an open-source HTTP client for Scala that provides a clean, programmer-friendly API to describe HTTP requests and handle responses. It supports various approaches to writing Scala code, including synchronous (direct-style), Future-based, and functional effect systems like cats-effect, ZIO, Monix, Kyo, and scalaz. sttp is designed to be extensible and integrates seamlessly with popular libraries for JSON handling, logging, metrics, and tracing.

         *Resources*

         1. [Sending HTTP requests with sttp | The Scala Toolkit | Scala Documentation](https://docs.scala-lang.org/toolkit/http-client-intro.html)
         2. [Introducing sttp | SoftwareMill](https://softwaremill.com/introducing-sttp-the-scala-http-client/)
         3. [Usage examples — sttp 3 documentation](https://sttp.softwaremill.com/en/v3.0.0/examples.html)

      4. Akka HTTP

         Akka HTTP is a modern, fast, asynchronous, and streaming-first HTTP server and client. It implements a full server- and client-side HTTP stack on top of akka-actor and akka-stream. Akka HTTP is not a web framework but rather a toolkit for providing and consuming HTTP-based services. It offers a flexible “Routing DSL” for defining RESTful web services and provides functionality for typical web servers, such as deconstructing URIs, content negotiation, and static content serving.

         *Resources*

         1. [Introduction to Akka HTTP | Baeldung](https://www.baeldung.com/akka-http)
         2. [Introduction to Akka HTTP in Scala | Baeldung on Scala](https://www.baeldung.com/scala/akka-http)
         3. [Sending HTTP Requests in 5 Minutes With Scala and Akka HTTP](https://dzone.com/articles/sending-http-requests-in-5-mins-with-scala-and-akk)

      5. Play

         The Play Framework is an open-source web application framework that follows the model–view–controller (MVC) architectural pattern. It is written in Scala and usable from other programming languages that are compiled to JVM bytecode, such as Java. Play is designed to optimize developer productivity by providing a lightweight, stateless, web-friendly architecture that uses Akka and Akka Streams to ensure predictable and minimal resource consumption (CPU, memory, threads) for highly-scalable applications. It is particularly well-suited for building modern web applications and REST services.

         *Resources*

         1. [Play Framework - Wikipedia](https://en.wikipedia.org/wiki/Play_Framework)
         2. [What Is Play Framework? (Definition, Uses, Alternatives) | Built In](https://builtin.com/software-engineering-perspectives/play-framework)
         3. [Getting Started with Play Framework](https://www.playframework.com/getting-started)

      6. Cask

         Cask is a simple Scala web framework inspired by Python's Flask project. It aims to bring simplicity, flexibility, and ease-of-use to Scala web servers, avoiding cryptic DSLs or complicated asynchrony. Cask is designed to be easy to set up and use for building websites, backend servers, or REST APIs.

         *Resources*

         1. [Building web servers with Cask | The Scala Toolkit | Scala Documentation](https://docs.scala-lang.org/toolkit/web-server-intro.html)
         2. [Simple Web and Api Servers with Scala](https://www.lihaoyi.com/post/SimpleWebandApiServerswithScala.html)

      7. Tapir

         Tapir is a library to describe HTTP APIs, expose them as a server, consume as a client, and automatically document using open standards. It is designed to be fast and developer-friendly, with a focus on type-safety, readability, and discoverability. Tapir provides integrations with many libraries in the Scala ecosystem, enhancing the developer’s toolbox with custom types, JSON handling, and observability features.

         *Resources*

         1. [Introduction to Tapir | Baeldung on Scala](https://www.baeldung.com/scala/tapir)

      8. http4s

         http4s is a minimal, idiomatic Scala interface for HTTP services. It is built on FS2, a streaming library that allows for processing and emitting large payloads in constant space and implementing websockets. http4s is designed to be composable and easy to reason about, with I/O managed through cats-effect.

         *Resources*

         1. [http4s GitHub Repository](https://github.com/http4s/http4s)
         2. [Introduction to http4s on Baeldung](https://www.baeldung.com/scala/http4s-intro)
         3. [http4s Tutorial on Rock the JVM](https://rockthejvm.com/articles/http4s-unleashing-the-power-of-http-apis-library)

   4. GUI

      1. Android

         Writing Android apps in Scala, while technically possible, brings a number of difficulties that together make the whole endeavor quite troublesome. Currently there are two ways to do it: one through a Gradle plugin (scalroid) which enables using Scala in standard Android SDK apps, the other through GraalVM Native Image ("Scala on Android") which allows for compiling a desktop app to Android. The third possible way, through Scala.js and React Native, requires more research.

         To be honest, all those paths require more research. Tread carefully.  

         1. scalroid -- the description and the link to the GitHub repository is already on the path
         2. "Scala on Android" -- the description and the link to the GitHub repository is already on the path

      2. Desktop

         Desktop application development in Scala often leverages JavaFX and ScalaFX to create rich, interactive user interfaces. JavaFX is a framework for building desktop applications with a comprehensive set of UI components and capabilities for graphics, animation, and multimedia. ScalaFX, a Scala wrapper around JavaFX, offers a more idiomatic and concise API for Scala developers.

         1. ScalaFX  -- the description and the link to the GitHub repository is already on the path

         2. JavaFX

            JavaFX is a GUI toolkit for Java designed to create rich desktop applications with modern user interfaces. It provides a comprehensive set of UI controls, supports hardware-accelerated graphics, and can be used to build applications that run across multiple platforms, including web, desktop, and mobile. JavaFX is known for its ease of use and integration with Java libraries.

            *Resources*

            1. [JavaFX Tutorial on TutorialsPoint](https://www.tutorialspoint.com/javafx/index.htm)
            2. [Official JavaFX Documentation](https://openjfx.io/openjfx-docs/)
            3. [JavaFX Tutorial on GeeksforGeeks](https://www.geeksforgeeks.org/java/javafx-tutorial/)

      3. Web

         Web application development in Scala typically involves using frameworks and libraries that leverage Scala's strengths in conciseness, type safety, and functional programming. Popular frameworks like Play Framework and Akka HTTP are commonly used for building scalable and reactive web applications. For the frontend, developers often integrate Scala with JavaScript frameworks or use Scala.js to write frontend code in Scala.

         1. Slinky

            Slinky is a framework for writing React apps in Scala, providing an experience similar to using ES6. It allows developers to leverage Scala's type safety and functional programming features while building React applications. Slinky supports React DOM, React Native, and other React-based platforms.

            *Resources*

            1. [Slinky "Hello, world" Tutorial](https://alvinalexander.com/scala/scala.js-slinky-hello-world-tutorial-example/)
            2. [Slinky and React Tutorial](https://pme123.medium.com/slinky-doing-react-the-scala-way-f78ccf42bf8f)

         2. React.js

            React.js is a popular JavaScript library for building user interfaces, developed and maintained by Facebook. It can be integrated with Scala.js, allowing developers to write React applications using Scala.

            *Resources*

            1. [Building Web Applications with Scala.js and React](https://enear.github.io/2017/03/07/scalajs-react-part1/)
            2. [Building a Frontend Application with Scala.js and React](https://medium.com/codinoverse/building-a-frontend-application-with-scala-js-and-react-a-detailed-guide-f89317d958c7)

         3. Laminar

            Laminar is a UI library for Scala.js that focuses on simplicity, expressiveness, and safety. It allows developers to build web application interfaces while keeping the UI state in sync with the underlying application state. 

            *Resources*

            1. [Official Laminar Website](https://laminar.dev/)
            2. [Build UIs with Laminar - Scala.js Tutorial](https://www.scala-js.org/doc/tutorial/laminar.html)
            3. [Laminar Documentation](https://laminar.dev/documentation)

         4. Calico

            Calico is a pure, reactive UI library for Scala.js. It enables developers to build reactive web applications using Scala.js, integrating with libraries such as Cats Effect and FS2.

            *Resources*

            1. [Calico GitHub Repository](https://github.com/armanbilge/calico)

      4. Concurrency

         Next to backend software development, concurrent programming is the other niche where Scala shines. Scala offers a number of solutions from all over the board: effect systems, actors, and so-called direct style.

         1. Ox

            Ox is a Scala library designed for safe direct-style streaming, concurrency, and resiliency on the JVM. It offers a comprehensive set of tools for managing concurrency, error handling, and resource management in a developer-friendly manner. Ox leverages Scala 3 and JDK 21+ to provide structured concurrency, high-level concurrency operators, and safe low-level primitives. It also includes features for error management, such as retries, timeouts, and safe error propagation.

            *Resources*

            1. [Ox Documentation](https://ox.softwaremill.com/latest/)
            2. [IO Effect Tracking with Ox](https://softwaremill.com/io-effect-tracking-using-ox/)

         2. Gears

            Gears is an experimental asynchronous programming library for Scala 3. It is designed to enable direct-style programming, structured concurrency, and is cross-platform, working on both JVM >=21 and Scala Native. Gears provides a simple and structured way to handle concurrent programming, minimizing computation leaks and offering tools for dealing with external, unstructured events.

            *Resources*

            1. [Gears Documentation](https://lampepfl.github.io/gears/)
            2. [Gears Book](https://blog.nkagami.me/gears-book/)

         3. FS2

            FS2 is a library for purely functional, effectful, and polymorphic stream processing in the Scala programming language. Its design goals are compositionality, expressiveness, resource safety, and speed. FS2 is built upon Cats and Cats-Effect, and its core types (streams and pulls) are polymorphic in the effect type, allowing it to be used with other effect libraries like Monix.

            *Resources*

            1. [Introduction to FS2 on Baeldung](https://www.baeldung.com/scala/fs2-functional-streams)
            2. [FS2 on Medium](https://taogang.medium.com/the-evolution-of-stream-processing-part-7-fs2-an-elegant-practitioner-of-functional-f52a0e55dd8e)
            3. [Functional Streams for Scala with FS2 on Udemy](https://www.udemy.com/course/functional-streams-for-scala-with-fs2/)

         4. Kyo

            Kyo is a toolkit for Scala development, providing a rich standard library for development across Native, JVM, and JavaScript platforms. It introduces a novel approach based on algebraic effects to deliver straightforward APIs in the pure Functional Programming paradigm.

            *Resources*

            1. [Writing Modular Applications Using The Kyo Library](https://www.scalamatters.io/post/writing-modular-applications-using-the-kyo-library)
            2. [Kyo Presentation at Functional Scala 2023](https://speakerdeck.com/fwbrasil/kyo-functional-scala-2023)

         5. Streaming

            Event streaming refers to the practice of capturing, processing, and analyzing a continuous flow of data events in real-time. Scala is particularly well-suited for event streaming due to its large ecosystem of libraries and frameworks. These tools allow developers to handle high-velocity data streams, perform complex event processing, and integrate with various data sources and sinks.

            1. Akka Streams

               Akka Streams is a toolkit for building highly concurrent, distributed, and fault-tolerant event-driven applications. It provides a high-level API geared towards efficient processing and always propagates back-pressure information from Sinks to Sources. Akka Streams is built on top of the Akka actor framework and adheres to the Reactive Streams manifesto, enabling efficient and scalable stream processing.

               *Resources*

               1. [Guide to Akka Streams on Baeldung](https://www.baeldung.com/akka-streams)
               2. [Akka/Apache Pekko Streams with Scala on Udemy](https://rockthejvm.com/courses/akka-apache-pekko-streams-with-scala)
               3. [Introduction to Akka Streams on Medium](https://arcagarwal.medium.com/introduction-to-akka-streams-5155bd070e37)

            2. Pekko Streams

               Pekko Streams started as an open-source clone of Akka Streams. It is a toolkit for building highly concurrent, distributed, and resilient message-driven applications for Java and Scala. It provides a uniform model of stream processing graphs, allowing flexible composition of reusable components.

               *Resources*

               1. [Akka/Apache Pekko Streams with Scala on Rock the JVM](https://rockthejvm.com/courses/akka-apache-pekko-streams-with-scala)
               2. [Pekko Streams Cookbook](https://pekko.apache.org/docs/pekko/current/stream/stream-cookbook.html)

            3. ZIO Streams

               ZIO Streams is a purely functional streaming library that uses the ZIO runtime. It is designed for working with large or infinite data, providing automatic backpressure handling, non-blocking and asynchronous processing, and a rich set of stream combinators. ZIO Streams ensures resource safety and efficient processing, making it suitable for building scalable and resilient streaming applications.

               *Resources*

               1. [ZIO Streams Introduction on Rock the JVM](https://rockthejvm.com/articles/zio-streams-introduction)
               2. [Introduction to ZIO Streams on Baeldung](https://www.baeldung.com/scala/zio-streams-intro)

      5. Distributed computing

         Distributed computing involves creating systems where multiple computers work together to solve complex problems by sharing resources and processing tasks across a network. Scala is particularly well-suited for distributed computing due to its ecosystem of libraries and frameworks like Akka, Apache Spark, and ZIO, which provide tools for building resilient, scalable, and fault-tolerant distributed systems.

         1. Akka

            Akka is a suite of modules designed for building scalable, resilient, and distributed systems using the actor model. It simplifies concurrency and fault tolerance by providing a framework for handling asynchronous operations and message passing. Akka is particularly well-suited for developing systems that require high availability and scalability.

            *Resources*

            1. [Akka Tutorials on All About Scala](https://allaboutscala.com/scala-frameworks/akka/)
            2. [Introductory Guide to Akka on Toptal](https://www.toptal.com/scala/concurrency-and-fault-tolerance-made-easy-an-intro-to-akka)
            3. [Akka Classic Essentials with Scala on Udemy](https://www.udemy.com/course/akka-essentials/)

         2. Pekko

            Pekko is an open-source framework for building applications that are concurrent, distributed, resilient, and elastic. It uses the Actor Model to provide intuitive high-level abstractions for concurrency. Pekko is a fork of Akka 2.6.x and offers libraries for persistence, streams, HTTP, and more.

            *Resources*

            1. [Introduction to Apache Pekko on Baeldung](https://www.baeldung.com/scala/apache-pekko)
            2. [Akka/Apache Pekko Essentials with Scala on Rock the JVM](https://rockthejvm.com/courses/akka-apache-pekko-essentials-with-scala)

         3. Spark

            Apache Spark is a framework for big data processing that integrates seamlessly with Scala. It provides a unified engine for various data processing tasks, including batch processing, interactive queries, streaming, machine learning, and graph processing. 

            *Resources*

            1. [Big Data Analysis with Scala and Spark on Coursera](https://www.coursera.org/learn/scala-spark-big-data)
            2. [Apache Spark with Scala on Udemy](https://www.udemy.com/course/apache-spark-with-scala-hands-on-with-big-data/)
            3. [Apache Spark with Scala Guide](https://www.chaosgenius.io/blog/apache-spark-with-scala/)

      6. Data handling

         1. Databases

            Scala's ecosystem includes libraries like Slick, Doobie, and Quill, which offer functional and type-safe approaches to database access. These libraries allow developers to interact with databases using Scala's expressive syntax and functional programming features, making it easier to write maintainable and efficient database code. Slick, for example, provides a functional-relational mapping (FRM) that allows developers to query databases in a type-safe manner, while Doobie offers a purely functional JDBC layer for interacting with databases. Additionally, Scala's interoperability with Java means that developers can also use Java-based database libraries and frameworks seamlessly.

            1. Redis4Cats

               Redis4Cats is a Redis client built on top of Cats Effect and FS2. It provides a functional and type-safe way to interact with Redis in Scala applications. Redis4Cats is designed to be used with Cats Effect for handling asynchronous operations and Fs2 for streaming data.

               *Resources* -- just the link to the website which is already in the path

            2. ScalikeJDBC

               ScalikeJDBC is a tidy SQL-based database access library for Scala developers. It naturally wraps JDBC APIs and provides easy-to-use APIs, making it intuitive and highly flexible. ScalikeJDBC is designed to be practical and production-ready, offering features like QueryDSL for type-safe and reusable code.

               *Resources*

               1. [ScalikeJDBC Cookbook](https://scalikejdbc.gitbooks.io/scalikejdbc-cookbook/content/en/)
               2. [ScalikeJDBC Tutorial for Beginners](https://www.slideshare.net/seratch/scalikejdbc-tutorial-for-beginners)

            3. Sangria

               Sangria is a Scala implementation of GraphQL, a query language for APIs. It is designed to be spec-compliant and works seamlessly with various GraphQL tools and libraries. Sangria provides a flexible and type-safe way to define and execute GraphQL schemas in Scala applications.

               *Resources*

               1. [Creating a GraphQL API with Scala and Sangria](https://sysgears.com/articles/how-to-create-a-graphql-api-with-scala-and-sangria/)
               2. [Building a GraphQL Server with Scala and Sangria Tutorial](https://www.howtographql.com/graphql-scala/0-introduction/)

            4. Slick

               Slick is a Functional Relational Mapping (FRM) library for Scala that allows developers to query and access databases in a manner similar to working with Scala collections. It provides compile-time safety and composability, making it easier to write and maintain database queries. Slick supports various databases like PostgreSQL, MySQL, Oracle, and MS SQL Server, and offers both asynchronous and streaming APIs for efficient database interactions.

               *Resources*

               1. [Introduction to Slick on Baeldung](https://www.baeldung.com/scala/slick-intro)
               2. [Getting Started with Slick on Rock the JVM](https://rockthejvm.com/articles/getting-started-with-scala-slick)

            5. Doobie

               Doobie is a pure functional JDBC layer for Scala and Cats. It provides a functional way to construct programs and higher-level libraries that use JDBC. Doobie is designed to be type-safe and composable, allowing developers to write database interactions in a purely functional style.

               *Resources*

               1. [Introduction to Doobie on Baeldung](https://www.baeldung.com/scala/doobie-intro)
               2. [Learning Doobie on Rock the JVM](https://rockthejvm.com/articles/learning-doobie-for-the-greater-good)

            6. Quill

               Quill is a library for database access in Scala that provides a Quoted Domain Specific Language (QDSL) to express queries in Scala and execute them in a target language. It supports compile-time query generation and validation, making it easier to write type-safe and efficient database queries. Quill is designed to minimize boilerplate and support multiple target languages, including SQL and Cassandra Query Language (CQL).

               *Resources*

               1. [Working with Databases using Scala and Quill](https://www.lihaoyi.com/post/WorkingwithDatabasesusingScalaandQuill.html)
               2. [Compile-time Queries with Quill](https://scalac.io/blog/quill-compile-time-queries/)
               3. [Database Queries with Quill](https://livebook.manning.com/book/get-programming-with-scala/chapter-46/v-9)

         2. JSON

            There is a number of Scala libraries develop for handling JSON data, at least one for each of the ecosystems, and a handful of independent ones. Some of them offer seamless support for Functional Programming and Scala's advanced type system, while others bet on simplicity on performance.

            1. PlayJSON

               PlayJSON is a Scala JSON library originally developed for use with Play Framework. It uses Jackson for JSON parsing and offers features like custom validation while parsing and automatic parsing of JSON in request bodies.

               *Resources*

               1. [Tutorial on Using PlayJSON](https://riptutorial.com/scala/example/13542/json-with-play-json)
               2. [Example of Using PlayJSON with Scala](https://dev.to/cuongld2/parse-json-to-object-models-in-scala-using-play-json-11im)

            2. Circe

               Circe is a JSON library for Scala that is part of the Cats ecosystem. It provides a functional way to handle JSON data, including encoding and decoding using Encoder and Decoder type classes. Circe aims to simplify working with JSON by hiding implementation details in a simple API and offers good performance and complete documentation.

               *Resources*

               1. [Tutorial on Circe](https://guillaumebogard.dev/videos/json-handling-scala-circe/)
               2. [Circe Tips and Tricks](https://medium.com/@famlyengineering/circe-tips-and-tricks-c2899e8c1967)

            3. Jsoniter

               Jsoniter is a library for compile-time generation of safe and ultra-fast JSON codecs for Scala. It uses Scala macros to generate codecs and has its own core mechanics for parsing and serialization. Jsoniter is designed to provide high performance and efficient processing of JSON data, making it suitable for handling both small JSON messages and large JSON data sets.

               *Resources*

               1. [Article on Jsoniter](https://blog.lambdaspot.dev/the-fastest-and-safest-json-parser-and-serializer-for-scala)

            4. uPickle

               uPickle is a simple, fast, and dependency-free JSON serialization library for Scala. It is designed to handle statically-typed, tree-shaped, immutable data structures efficiently. uPickle is part of the Scala Toolkit and integrates well with other Scala libraries.

               *Resources*

               1. [Reading and Writing JSON with uPickle](https://medium.com/@umanium/reading-and-writing-json-string-with-upickle-on-scala-3-b9b029e8efa2)
               2. [Scala Toolkit Documentation on uPickle](https://docs.scala-lang.org/toolkit/json-intro.html)

      7. Video game engines

         The video game development landscape is ruled mainly by C++ but there is a small but active scene of games developed in JVM languages - for example Minecraft was coded in Java. Scala's interoperability with Java makes it possible to develop video games using Java solutions, like LibGDX and LWJGL, but there are also game engines written directly in Scala.

         1. Indigo

            Indigo is a game engine written in Scala, designed specifically for functional programmers. It aims to address challenges in testing games and managing data flow and state. Indigo supports Scala 3.0 and is particularly suited for developing 2D pixel art games.

            *Resources* -- the link to the main webside is already in the path

         2. CosPlay

            CosPlay is a 2D ASCII game engine for Scala. It is designed to be a standard Scala3-based program with minimal requirements for code organization. CosPlay allows for the creation of games using ASCII characters and provides methods to initialize the game engine, start the game loop, and dispose of the game engine when the game exits.

            *Resources* -- the link to the main webside is already in the path

         3. LibGDX w/ Scala

            LibGDX is a popular JVM framework for game design that can be used with Scala. It provides a set of tools for creating cross-platform games. Scala developers can use LibGDX with build tools like sbt or Gradle to manage their projects. LibGDX supports various features such as graphics, sound, physics emulation, and more, making it a versatile choice for game development.

            1. [Using libGDX with Scala](https://libgdx.com/wiki/jvm-langs/using-libgdx-with-scala)
            2. [scala-libgdx-examples on GitHub](https://github.com/rathboma/scala-libgdx-examples)
            3. [Game Programming in Scala with Libgdx and Box2D](https://blog.matthewrathbone.com/2012/10/22/game-programming-in-scala-with-libgdx-and-box2d.html)

      8. Macros & the type system

         1. Monocle

            Monocle is an optics library for Scala and Scala.js, strongly inspired by Haskell Lens. It provides functionalities for creating and manipulating lenses, prisms, and isomorphisms. Monocle uses macros to simplify the generation of optics, such as lenses for case classes, prisms for subclasses, and isomorphisms between types. This makes it easier to work with nested data structures and perform operations like accessing, modifying, and transforming data in a concise and type-safe manner.

            *Resources*

            1. [Monocle | Lens](https://www.scala-exercises.org/monocle/lens)
            2. [Introduction to Optics in Scala Using Monocle](https://www.baeldung.com/scala/monocle-optics)
            3. [Optics: a hands-on introduction in Scala](https://jonaschapuis.com/2018/07/optics-a-hands-on-introduction-in-scala/)

         2. Chimney

            Chimney is a Scala library that provides typeclasses and macros for intuitive and type-safe transformations between data structures. It allows for automatic derivation of transformers between different model case classes, reducing boilerplate code. Chimney uses macros internally to ensure that transformations are checked at compile time, providing safety and convenience.

            *Resources*

            1. [Introduction to Chimney](https://www.baeldung.com/scala/chimney-data-transformation-library)
            2. [Chimney Cookbook](https://chimney.readthedocs.io/en/stable/cookbook/)

         3. Magnolia

            Magnolia is a generic macro for automatic materialization of typeclasses for datatypes composed from case classes (products) and sealed traits (coproducts). It supports recursively-defined datatypes out-of-the-box and incurs no significant time-penalty during compilation. Magnolia provides a simple interface for handling products and coproducts, which is then used by the Magnolia macro to derive typeclasses automatically.

            *Resources*

            1. [Blending Magnolia with Circe's trick for automatic derivation](https://stackoverflow.com/questions/50544041/blending-magnolia-with-circes-trick-for-automatic-derivation)
            2. [Intermediate's guide to derivations in Scala: Magnolia](https://blog.michal.pawlik.dev/posts/scala/scala-derivations-show/)

         4. Shapeless

            Shapeless is a library for type-level programming in Scala, providing functionalities for generic programming using type classes and macros. It allows for type-safe manipulation and transformation of data structures at compile time, leveraging Scala's type system. Shapeless is known for its use of HLists (heterogeneous lists) and support for type-level computations, making it a cornerstone of advanced type-level programming in Scala.

            *Resources*

            1. [Getting started with Shapeless](https://jto.github.io/articles/getting-started-with-shapeless/)

         5. Scalameta

            Scalameta is a metaprogramming tool for Scala that provides high-quality syntactic and semantic analysis and code generation. It was widely used in Scala 2 for advanced metaprogramming scenarios and continues to be relevant in Scala 3. Scalameta operates at the meta level, taking programs as input and producing syntactic or semantic information or rewritten programs as output. It supports annotation macros and is designed to be more reason-able and debuggable compared to traditional macros.

            *Resources*

            1. [Introduction to code generation with Scalameta](https://www.michaelpollmeier.com/2016/12/01/scalameta-code-generation-tutorial)
            2. [Scalameta: A Redesigned Scala Macros Programming Tool Library](https://blog.krybot.com/t/scalameta-a-redesigned-scala-macros-programming-tool-library/2403)

         6. Hearth

            Hearth is a library focused on helping write easy-to-maintain macros that can be cross-compiled between the Scala 2 and Scala 3 macro systems. It provides a cross-compilable API, exhaustive documentation, and no dependencies on additional ecosystems. Hearth is designed to serve not only specific libraries like Chimney but also any other library that uses macros.

            *Resources*

            1. [Hearth documentation](https://scala-hearth.readthedocs.io/en/stable/)

         7. Refined

            Refined is a library for refining types with constraints in Scala using macros. It leverages Scala's type system and metaprogramming capabilities to provide type-safe refinements. Refined allows developers to define constraints on types, ensuring that values adhere to specific conditions at compile time.

            *Resources*

            1. [Build your own refinement types in Scala 3](https://msitko.pl/blog/build-your-own-refinement-types-in-scala3.html)
            2. [Refined documentation](https://github.com/fthomas/refined#refined)

   5. Learn advanced concepts

      1. Referential Transparency

         Referential transparency is a fundamental concept in functional programming where an expression can be replaced by its value without changing the behavior of the program. In Scala, this concept is closely tied to pure functions, which always return the same output for the same input and do not have any side effects.

         *Resources*

         1. [Scala Best Practices - Referential transparency](https://nrinaudo.github.io/scala-best-practices/definitions/referential_transparency.html)
         2. [Scala Functional Programming Patterns book](https://www.oreilly.com/library/view/scala-functional-programming/9781783985845/ch01s05.html)
         3. [Referential Transparency in Scala - liveBook by Manning](https://livebook.manning.com/concept/scala/referential-transparency)
         4. [Referential Transparency - Learning Journal](https://www.learningjournal.guru/article/scala/functional-programming/referential-transparency/)
         5. [Scala Tutorials Part #21 - Referential transparency](https://madusudanan.com/blog/scala-tutorials-part-21-referential-transparency/)

      2. Pure functions

         Pure functions in Scala are functions that always return the same output for the same input and do not have any side effects. They are fundamental to functional programming and provide predictability and reliability. 

         *Resources*

         1. [Pure Functions - Scala 3 Documentation](https://docs.scala-lang.org/scala3/book/fp-pure-functions.html)
         2. [Pure Function vs Referential Transparency](https://edward-huang.com/functional-programming/tech/programming/scala/2020/01/30/pure-function-vs-referential-transparency/)
         3. [Referential Transparency in Scala Pt. I - Pure functions](https://rafaelvindelamor.dev/posts/referential-transparency-in-scala-pt-i-pure-functions/)
         4. [Scala best practice: Create methods that have no side effects (pure functions)](https://alvinalexander.com/scala/how-to-create-scala-methods-no-side-effects-pure-functions/)

      3. Monads

         Monads in Scala are constructs that augment a value with additional features, known as effects. These effects can include managing the nullability of a variable or handling the asynchronicity of its computation. In Scala, common monads include `Option[T]`, `Future[T]`, `Either`, `List`, and more. A monad adds an effect to a value by wrapping it around a context. The key functions a monad must implement are `unit` (which lifts a value into the monadic context) and `flatMap` (which allows for chaining operations within the monadic context).

         *Resources*

         1. [Monads in Scala | Baeldung on Scala](https://www.baeldung.com/scala/monads)
         2. [Monads in Scala - GeeksforGeeks](https://www.geeksforgeeks.org/scala/monads-in-scala/)
         3. [An Introduction to Monads in Scala | Rock the JVM](https://rockthejvm.com/articles/an-introduction-to-monads-in-scala)
         4. [Demystifying the Monad in Scala](https://medium.com/free-code-camp/demystifying-the-monad-in-scala-cc716bb6f534)

      4. Category Theory

         Category Theory is a branch of mathematics that deals with structures and relationships between them. In the context of Scala and functional programming, Category Theory provides a framework for understanding and designing functional programs. Key concepts include categories, functors, monads, and natural transformations, which are essential for writing maintainable functional code.

         *Resources*

         1. ["Category Theory for Programmers" by Bartosz Milewski](https://bartoszmilewski.com/2014/10/28/category-theory-for-programmers-the-preface/)

      5. Typeclasses

         Typeclasses are a concept used in functional programming to achieve ad-hoc polymorphism. They define a set of functions that can be implemented for a type fulfilling certain requirements, providing a way to add functionality to existing types without modifying their source code. Typeclasses are not natively supported in Scala but can be implemented using traits and implicit classes.

         *Resources*

         1. [Type Classes | Scala 3 — Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/ca-type-classes.html)
         2. [Type classes in Scala - Ad-hoc polymorphism - Scalac.io](https://scalac.io/blog/typeclasses-in-scala/)
         3. [Demystifying Type Classes in Scala: A Simple Guide | by Remis Haroon | Medium](https://medium.com/@remisharoon/demystifying-type-classes-in-scala-a-simple-guide-3a4766a59818)
         4. [Type Classes in Scala | Baeldung on Scala](https://www.baeldung.com/scala/type-classes)

      6. Capabilities

         Scala 3 introduces a new feature called "capabilities" as an alternative way to model effects. In short, a capability is an implicit function passed as a parameter. The function that requires a capability as a parameter declares in this way, that it will only work if in its scope is a capability to perform certain task. 

         *Resources*

         1. [Effects as Capabilities | Nicolas Rinaudo](https://nrinaudo.github.io/articles/capabilities.html)

      7. Capture checking

         Capture Checking is an experimental feature in Scala that allows you to track which designated values are captured (i.e., stored as references) by arbitrary other values. This tracking happens at compile time and is currently an opt-in mechanism that can be enabled via an import. Capture checking helps ensure resource safety and prevent capability leakage by verifying at compile-time that capabilities (representing resources, effects, or permissions) are properly managed and do not escape their intended scope.

         *Resources*

         1. [Capture Checking](https://docs.scala-lang.org/scala3/reference/experimental/cc.html)
         2. [Understanding Capture Checking in Scala | SoftwareMill](https://softwaremill.com/understanding-capture-checking-in-scala/)
         3. [Capture Checking Basics](https://nightly.scala-lang.org/docs/reference/experimental/capture-checking/basics.html)

      8. Type system

         The Scala type system supports both object-oriented and functional programming paradigms. It is designed to be expressive and flexible, allowing developers to write concise and type-safe code. The type system includes features such as type inference, generics, variance annotations, type bounds, abstract types, higher-kinded types, type classes, and implicit resolutions. It is one of the most sophisticated type systems in any programming language, combining comprehensive ideas from both functional programming and object-oriented programming.

         *Resources*

         1. [Types and the Type System | Scala 3 — Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/types-introduction.html)
         2. [Type Hierarchies in Scala | Baeldung on Scala](https://www.baeldung.com/scala/type-hierarchies)
         3. [Chapter 6. The Type System · Scala in Depth](https://livebook.manning.com/book/scala-in-depth/chapter-6)

      9. Variance

         Variance in Scala is a concept that controls how type parameters behave with regard to subtyping. Scala supports variance annotations of type parameters of generic classes, allowing them to be covariant, contravariant, or invariant if no annotations are used. Covariance means that if type B is a subtype of type A, then a type constructor F[B] is a subtype of F[A]. Contravariance is the opposite: if B is a subtype of A, then F[B] is a supertype of F[A]. Invariance means there is no subtyping relationship between F[A] and F[B].

         **Best Resources:**

         1. [Variances | Tour of Scala | Scala Documentation](https://docs.scala-lang.org/tour/variances.html)
         2. [Variance | Scala 3 - Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/types-variance.html)
         3. [Variances in Scala | Baeldung on Scala](https://www.baeldung.com/scala/variances)
         4. [Demystifying Variance Positions in Scala | Rock the JVM](https://rockthejvm.com/articles/demystifying-variance-positions-in-scala)

      10. Context bounds

          Context Bounds in Scala is a feature that provides a shorthand syntax for expressing the common pattern of a context parameter that depends on a type parameter. Context bounds are used to simplify the code for generic types and are particularly useful in the context of type classes. 

          *Resources*

          1. [Context Bounds | Scala 3 - Book | Scala Documentation](https://docs.scala-lang.org/scala3/book/ca-context-bounds.html)
          2. [Demystifying View and Context Bounds | Baeldung on Scala](https://www.baeldung.com/scala/view-context-bounds)
          3. [Scala Context Bound - GeeksforGeeks](https://www.geeksforgeeks.org/scala/scala-context-bound/)
          4. [Context Bounds - Scala 3 - EPFL](https://dotty.epfl.ch/docs/reference/contextual/context-bounds.html)

      11. Macros

          Macros enable advanced metaprogramming capabilities, such as code generation, optimizations, and the creation of domain-specific languages (DSLs). Scala 3 macros were redesigned to be more intuitive and flexible than the previous version.

          *Resources*

          1. [Scala 3 Macros | Macros in Scala 3 | Scala Documentation](https://docs.scala-lang.org/scala3/guides/macros/macros.html)
          2. [Tutorial | Macros in Scala 3 | Scala Documentation](https://docs.scala-lang.org/scala3/guides/macros/)
          3. [Scala 3 macros tips & tricks | SoftwareMill Blog](https://softwaremill.com/scala-3-macros-tips-and-tricks/)
          4. [Guide to Scala 3 Macros | Rock the JVM](https://rockthejvm.com/articles/scala-3-macros-comprehensive-guide)