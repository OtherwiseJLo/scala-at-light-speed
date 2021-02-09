name := "scala-at-light-speed"

version := "0.1"

scalaVersion := "2.13.1"

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.0") // "2.4.0" is just sbt plugin version
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.25")


libraryDependencies += "org.scalameta" %% "scalameta" % "4.4.8"
libraryDependencies += "org.scalameta" %% "munit" % "0.7.21" % Test
// Use %%% for non-JVM projects.
testFrameworks += new TestFramework("munit.Framework")
