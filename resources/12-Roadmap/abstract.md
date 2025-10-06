# Czego możecie się uczyć dalej?
(Where Do We Go Now?!)

Scala jest językiem programistycznym ogólnego użytku, ale najczęściej aplikacje w nim napisane można spotkać w następujących niszach:

* Backend
* Data mining
* Video streaming
* Narzędzia, biblioteki i frameworki open-source
* Cryptocurrency

Oraz jako hobby:

* Android
* Gry komputerowe

* Ecosystems:
  * Cats
  * ZIO
  * Akka/Pekko
  * Play
  * Li Haoyi's libraries
* Frameworks
  * Akka (https://akka.io/)
    * "The platform to build, run, and evaluate agentic systems with certainty, scale, and resilience."
  * Pekko (https://pekko.apache.org/)
    * "Apache Pekko™ is an open-source framework for building applications that are concurrent, distributed, resilient and elastic. Pekko uses the Actor Model to provide more intuitive high-level abstractions for concurrency. Using these abstractions, Pekko also provides libraries for persistence, streams, HTTP, and more. Pekko includes APIs for Java and Scala and is designed to run in JVMs."
  * Cats (https://typelevel.org/cats/)
    * "Cats is a library which provides abstractions for functional programming in the Scala programming language."
  * ZIO (https://zio.dev/)
    * "Type-safe, composable asynchronous and concurrent programming for Scala"
  * Finagle (https://twitter.github.io/finagle/)
    * "Finagle is an extensible RPC system for the JVM, used to construct high-concurrency servers. Finagle implements uniform client and server APIs for several protocols, and is designed for high performance and concurrency. "
* Unit testing
  * ScalaTest (https://www.scalatest.org/)
    * "ScalaTest is the most flexible and most popular testing tool in the Scala ecosystem. With ScalaTest, you can test Scala, Scala.js (JavaScript), Scala Native, Dotty (Scala 3), and Java code."
  * ScalaMock (https://scalamock.org/)
    * "Native Scala mocking framework"
  * JUnit 5 (https://junit.org/)
    * "The programmer-friendly testing framework for Java and the JVM"
  * specs2 (https://specs2.org/)
    * "specs2 is a library for writing executable software specifications in Scala. With specs2 you can write: specifications for simple classes (unit specifications); specifications for full features (acceptance specifications)"
  * uTest
    * 
  * MUnit
  * ZIO Test
* Web frameworks
  * Akka HTTP (https://doc.akka.io/libraries/akka-http)
    * "The Akka HTTP modules implement a full server- and client-side HTTP stack on top of akka-actor and akka-stream. It’s not a web-framework but rather a more general toolkit for providing and consuming HTTP-based services."
  * Play (https://www.playframework.com/)
    * " Play is based on a lightweight, stateless, web-friendly architecture. Built on Pekko (Play 3) and Akka (Play 2), Play provides predictable and minimal resource consumption (CPU, memory, threads) for highly-scalable applications."
  * http4s (https://http4s.org/)
    * "http4s servers and clients share an immutable model of requests and responses. Standard headers are modeled as semantic types, and entity codecs are done by typeclass."
  * Tapir (https://tapir.softwaremill.com/en/latest/)
    * "Tapir is a library to describe HTTP APIs, expose them as a server, consume as a client, and automatically document using open standards. Tapir is fast and developer-friendly. The endpoint definition APIs are crafted with readability and discoverability in mind. Our Netty-based server is one of the best-performing Scala HTTP servers available."
  * sttp (https://sttp.softwaremill.com)
    * "sttp client is an open-source HTTP client for Scala, supporting various approaches to writing Scala code: synchronous (direct-style), Future-based, and using functional effect systems (cats-effect, ZIO, Monix, Kyo, scalaz)."
  * Scalatra (https://scalatra.org/)
    * "Scalatra is a simple, accessible and free web micro-framework."
  * Finatra (https://twitter.github.io/finatra/)
    * "Finatra builds on TwitterServer and uses Finagle, Finatra at its core is agnostic to the type of service or application being created. It can be used to build anything based on TwitterUtil."
  * Cask (https://com-lihaoyi.github.io/cask/)
    * "Cask is a simple Scala web framework inspired by Python's Flask project. It aims to bring simplicity, flexibility and ease-of-use to Scala webservers, avoiding cryptic DSLs or complicated asynchrony."
  * smithy4s (https://smithy.io/2.0/)
    * "smithy4s is a code generator for building APIs in Scala. It generates code for clients and servers, and supports multiple protocols."
* Data mining
  * Spark (https://spark.apache.org)
    * "Apache Spark is a unified analytics engine for large-scale data processing. It provides high-level APIs in Java, Scala, Python and R, and an optimized engine that supports general execution graphs."
  * Breeze (https://github.com/scalanlp/breeze)
    * Breeze is/was a library for numerical processing. It aims to be generic, clean, and powerful without sacrificing (much) efficiency. Mostly retired at this point.
* Databases
  * Anorm (https://playframework.github.io/anorm/)
    * "Play includes a simple data access layer called Anorm that uses plain  SQL to interact with the database and provides an API to parse and  transform the resulting datasets."
    * The authors make a point that the situation differ between Java and Scala. Complex DSLs are useful in Java, but in Scala transforming data while keeping it type-safe is easy, so there's no need for complex DSLs.
  * Slick (https://scala-slick.org/)
    * "Slick is an advanced, comprehensive database access library for Scala with strongly-typed, highly composable APIs."
    * FRM, not ORM - Function-Relational Mapping
  * Doobie (https://typelevel.org/doobie/index.html)
    * **doobie** is a pure functional JDBC layer for Scala and [**Cats**](http://typelevel.org/cats/). It is not an ORM, nor is it a relational algebra; it simply provides a  functional way to construct programs (and higher-level libraries) that  use JDBC. 
  * Quill (https://zio.dev/zio-quill/)
    * "The library's core is designed to support multiple target languages,  currently featuring specializations for Structured Query Language ([SQL](https://en.wikipedia.org/wiki/SQL)) and Cassandra Query Language ([CQL](https://cassandra.apache.org/doc/latest/cql/))."
  * ScalikeJDBC (https://scalikejdbc.org/)
    * "This library seamlessly wraps JDBC APIs, offering intuitive and highly flexible functionalities. With QueryDSL, your code becomes inherently type-safe and reusable."
    * "If you can access a datastore via the JDBC interface, you can also seamlessly access it through ScalikeJDBC."
    * "If you’re looking to execute SQL queries efficiently, the best approach  is to use ScalikeJDBC along with the appropriate JDBC driver for your  database."
  * ReactiveMongo (NoSQL: Mongo, http://reactivemongo.org/)
    * "[ReactiveMongo](https://github.com/ReactiveMongo/ReactiveMongo/) is a Scala driver that provides fully non-blocking and asynchronous I/O operations."
    * Used by Lichess
  * Redis4Cats (NoSQL: Redis, https://redis4cats.profunktor.dev/)
    * "Redis client built on top of [Cats Effect](https://typelevel.org/cats-effect/), [Fs2](http://fs2.io/) and the async Java client [Lettuce](https://lettuce.io/).`''
  * Sangria
    * "**Sangria** is a Scala [GraphQL](http://facebook.github.io/graphql/) implementation."
* Build tools
  * sbt (https://www.scala-sbt.org/)
    * The most popular Scala build tool
  * Mill (https://mill-build.org)
    * Simple Scala syntax
    * Works for Scala, Java, and Kotlin
  * ScalaCLI (https://scala-cli.virtuslab.org/)
    * "Scala CLI combines *all* the features you need to learn and use Scala in your scripts, playgrounds and (single-module) projects"
    * "Scala CLI will soon become the default Scala runner and will be shipped as `scala`"
  * Gradle (with a plugin: https://docs.gradle.org/current/userguide/scala_plugin.html)
    * "The Scala plugin extends the [Java plugin](https://docs.gradle.org/current/userguide/java_plugin.html#java_plugin) to add support for [Scala](https://www.scala-lang.org/) projects. The plugin also supports *joint compilation*, which allows you to freely mix and match Scala and Java code with dependencies in both directions."
    * Good choice if a project is mainly in Java and you add Scala to it
  * Maven (with a plugin: https://docs.scala-lang.org/tutorials/scala-with-maven.html)
    * Good choice if a project is mainly in Java and you add Scala to it
* IDE (https://docs.scala-lang.org/getting-started/scala-ides.html)
  * IntelliJ IDEA + Scala Plugin (https://www.jetbrains.com/scala)
    * "IntelliJ IDEA with the Scala plugin provides you with all the features  you would expect from a full-blown Scala IDE and much more."
  * VS Code + Metals (https://scalameta.org/metals/docs/editors/vscode/)
    * "Metals is a language server for Scala that works with VS Code, Vim, Emacs, and Sublime Text"
  * Emacs, Vim, Sublime Text, Helix (all + Metals)
  * Eclipse (legacy)
* GUI
  * ScalaFX (https://scalafx.org/)
    * ScalaFX is a UI DSL written within the Scala Language that sits on top of JavaFX. Every ScalaFX application is also a valid Scala application. It supports full interoperability with Java and can run anywhere the Java Virtual Machine (JVM) and JavaFX are supported. 
    * ScalaFX uses a simple, hierarchical pattern for creating new objects and building up the scene graph. Here is a simple, complete application example that creates a new stage (window) with a rectangle that changes color based on mouse events
  * Scala.js (https://www.scala-js.org/)
    * Scala.js is a compiler that compiles Scala code to JavaScript. It allows you to write Scala code that runs in the browser, on the server, or in a Node.js environment.
  * Slinky + React.js (https://slinky.dev/)
    * Slinky is a library for building React components in Scala. It provides a simple, yet powerful API for building React components.
* Native / embedded
  * Scala Native (https://scala-native.org/en/stable/)
    * "Scala Native is an optimizing ahead-of-time compiler and lightweight managed runtime designed specifically for Scala."
  * GraalVM Native Image (https://www.graalvm.org/jdk24/reference-manual/native-image/)
    * "Native Image is a technology to compile Java code ahead-of-time to a binary—a native executable. A native executable includes only the code required at run time, that is the application classes, standard-library classes, the language runtime, and statically-linked native code from the JDK."
* JSON
  * Circe (https://circe.github.io)
    * "circe is a JSON library for Scala. circe depends on cats, and the core project has only one dependency (cats-core)"
  * uPickle (https://com-lihaoyi.github.io/upickle/)
    * "uPickle (pronounced micro-pickle) is a lightweight JSON and binary (MessagePack) serialization library for Scala"
  * Play JSON (https://github.com/playframework/play-json)
    * "Play JSON is a powerful Scala JSON library, originally developed by the Play team for use with Play Framework. It uses Jackson for JSON parsing and has no Play dependencies."
  * Jsoniter (https://github.com/plokhotnyuk/jsoniter-scala)
    * "Scala macros for compile-time generation of safe and ultra-fast JSON codecs."
* Concurrency
  * Akka Streams (https://doc.akka.io/libraries/akka-core)
    * "Akka Streams is a reactive stream processing library for Scala and Java. It provides a powerful and flexible API for building reactive applications."
  * Ox (https://ox.softwaremill.com)
    * "Safe direct-style streaming, concurrency and resiliency for Scala on the JVM. Requires JDK 21+ & Scala 3."
  * Gears (https://lampepfl.github.io/gears/)
    * "An Experimental Asynchronous Programming Library for Scala 3"
  * Monix (https://monix.io)
    * "Monix is a high-performance Scala / Scala.js library for composing asynchronous, event-based programs."
  * Kyo (https://getkyo.io/#/)
    * "Kyo is a powerful toolkit for Scala development, providing a rich standard library for development across Native, JVM, and JavaScript platforms. Kyo introduces a novel approach based on algebraic effects to deliver straightforward APIs in the pure Functional Programming paradigm."
  * FS2 (https://fs2.io/#/)
    * "Functional, effectful, concurrent streams for Scala"
  * ZIO Streams (https://zio.dev/reference/stream)
    * "The primary goal of a streaming library is to introduce a high-level API that abstracts the mechanism of reading and writing operations using data sources and destinations."
  * Signals3 (https://github.com/makingthematrix/signals3)
    * This is a lightweight event streaming library for Scala. You can help me develop it :) 
* Abstract/generic programming
  * Chimney (https://chimney.readthedocs.io)
    * "The battle-tested Scala library for data transformations"
  * Refined (https://github.com/fthomas/refined)
    * "refined is a Scala library for refining types with type-level predicates which constrain the set of values described by the refined type. It started as a port of the refined Haskell library by Nikita Volkov (which also provides an excellent motivation why this kind of library is useful). "
  * Monocle (https://www.optics.dev/Monocle/)
    * "Monocle is a Scala library which offers a simple yet powerful API to access and transform immutable data."
  * Quicklens (https://github.com/softwaremill/quicklens)
    * "Modify deeply nested fields in case classes using developer friendly syntax"
  * Shapeless (https://github.com/milessabin/shapeless)
    * "shapeless is a type class and dependent type based generic programming library for Scala."
  * Magnolia (https://github.com/softwaremill/magnolia)
    * "Magnolia is a generic macro for automatic materialization of typeclasses for datatypes composed from product types (e.g. case classes) and coproduct types (e.g. enums). It supports recursively-defined datatypes out-of-the-box, and incurs no significant time-penalty during compilation."
  * Scalameta (https://scalameta.org/)
    * "Library to read, analyze, transform and generate Scala programs."
* Video game engines
  * Indigo
  * CosPlay
  * LibGDX
  * LWJGL
  * FXGL (JavaFX)