ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.2"

val standardOptions = Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-encoding",
  "utf8"
)

val scala3Options = Seq(
  "-explain",
  "-Wsafe-init",
  "-Ycheck-all-patmat",
  "-Wunused:imports",
  "-no-indent"
)

lazy val root = (project in file("."))
  .settings(
    name := "FP_in_Scala",
    idePackagePrefix := Some("org.fpinscala"),
    scalacOptions ++= standardOptions ++ scala3Options
  )

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.13.0",
  "org.typelevel" %% "cats-effect" % "3.6.0"
)
