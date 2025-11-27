
val _scalaVersion = "3.7.2"

ThisBuild / version := "0.1.0"

organization := "io.github.makingthematrix"
name := "ReferentialTransparency"
licenses := Seq("GPL 3.0" -> url("https://www.gnu.org/licenses/gpl-3.0.en.html"))
ThisBuild / scalaVersion := _scalaVersion
ThisBuild / versionScheme := Some("semver-spec")
Test / scalaVersion := _scalaVersion

developers := List(
  Developer(
    "makingthematrix",
    "Maciej Gorywoda",
    "makingthematrix@protonmail.com",
    url("https://github.com/makingthematrix"))
)

val standardOptions = Seq(
  "-deprecation", // Show warnings for deprecated features
  "-feature", // Warn about features that should be explicitly imported
  "-unchecked", // Enable additional warnings for unchecked operations (e.g., type erasure)
  "-encoding", // Specify character encoding for source files
  "utf8" // allows for non-ASCII characters in source files
)

val scala3Options = Seq(
  "-explain", // Provide detailed explanations for errors and warnings
  "-Wsafe-init", // Warn about potentially unsafe initialization of fields
  "-Ycheck-all-patmat", // Enable exhaustiveness checking for all pattern matching
  "-Wunused:imports", // Warn about unused imports
  "-no-indent", "-rewrite" // Disable significant indentation syntax and rewrite source files to use braces
)


lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.6.3",
      "org.slf4j" % "slf4j-simple" % "2.0.17",
       "com.github.tototoshi" %% "scala-csv" % "2.0.0",
      "com.softwaremill.macwire" %% "macros" % "2.6.7" % Provided,
      //Test dependencies
      "org.scalameta" %% "munit" % "1.2.1" % Test
    ),
    scalacOptions ++= standardOptions ++ scala3Options
  )

testFrameworks += new TestFramework("munit.Framework")
