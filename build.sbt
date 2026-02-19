name := "my-sbt-project"
version := "0.1.0"
scalaVersion := "2.13.12"

enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-ember-server" % "0.23.23",
  "org.http4s" %% "http4s-dsl"          % "0.23.23",
  "ch.qos.logback" % "logback-classic"  % "1.4.11"
)
