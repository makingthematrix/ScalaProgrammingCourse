# Programming in Scala

## General Information

Course Code:
Erasmus / ISCED Code:
Course Name: Programming in Scala
Department: Faculty of Mathematics, Informatics, and Mechanics
Groups: Optional tool subjects for computer science
ECTS Credits and others: 4.00
Language of Instruction: Polish
Prerequisites: Introduction to Programming 1000-211bWPI

##Assumptions
The target group is 2nd or 3rd-year students. They already know at least one programming language - such as Java, Python, or C/C++. They can use an IDE (though not necessarily IntelliJ IDEA), but they probably have little or no experience working as programmers.

## Type of Classes
Lectures (13-15 x 1.5 hours) + a project for completion

## Brief Description
Scala is a programming language that combines the multitasking of the JVM ecosystem with the expressiveness and safety of functional programming, as well as the latest achievements in programming language design. Its development is overseen by a team working at the École Polytechnique Fédérale de Lausanne (EPFL) in Switzerland, led by the creator of Scala, Prof. Martin Odersky. The main applications of Scala include streaming platforms, web server software, and data mining.

## Full Description
After completing the course, students should be able to use Scala to create simple but practical applications, such as a web application that accepts data from the user, saves it, displays it, and allows for its modification and deletion (other possible examples: a desktop application, an Android application, a video game). They should know Scala's syntax, basic concepts of functional programming and their implementation in Scala, and be able to plan and configure a Scala project and develop it as a programmer working in a team.

The following topics will be discussed during the classes:

1. Scala Syntax: val vs var, immutable vs mutable collections, case class, case object, companion object, sealed trait, enum, apply and unapply, pattern matching.
2. Main Concepts of Functional Programming: functions as data, immutability, laziness (lazy evaluation), type system.
3. Main Methods for Data Collection Operations: filter, map, collect, find, collectFirst, flatMap, fold.
4. Version Control System using git. Commands: init, clone, checkout, branch, commit, push. Resolving conflicts using merge and rebase. Discussion of open-source licenses, how to write a README, the purpose of .gitignore, how to perform code review, what GitHub Actions are.
5. Building a Web Application in Play Framework.
6. Futures, async/await, event streams, actor model, Akka/Pekko.
Recursion: tail recursion (tailrec), trampolines. Advanced pattern matching: enum and unapply review; how to build and manipulate a binary tree.
7. Introduction to the debugger and other IntelliJ IDEA features helpful for refactoring, code completion, etc.
8. Monads: Theory, error handling using Option/Either/Try, IO monad in Cats Effect.
9. Roadmap for Further Learning: Overview of main websites, YouTube channels, etc. Review of major software development fields and the frameworks and libraries that support them in Scala: JSON parsing, ORM, HTTP request handling, build tools, GUI frameworks, web frameworks, testing.

## Literature
"Functional Programming in Scala, Second Edition", 2023, Michael Pilquist, Rúnar Bjarnason, and Paul Chiusano (https://www.manning.com/books/functional-programming-in-scala-second-edition)
Interactive course "Functional Programming in Scala", JetBrains (https://plugins.jetbrains.com/plugin/23833-functional-programming-in-scala)

## Methods and Criteria for Assessment
Form: Programming project.

Students will be tasked with forming 3-5 person programming teams, then selecting a project, setting up a repository on the GitHub platform, and implementing a multi-level application (e.g., a web application that accepts data from the user, saves it, displays it, and allows for its modification and deletion, a desktop application with a similar structure, a mobile application for the Android system, a simple computer game, etc.).

Not only the final result will be evaluated, but also teamwork (task division, communication among team members), code quality, and the presence and quality of tests. Mid-semester and during the last classes, students will have the opportunity to present their project.