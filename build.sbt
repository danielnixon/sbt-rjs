sbtPlugin := true

organization := "org.danielnixon"
licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
publishMavenStyle := true
publishArtifact in Test := false
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
homepage := Some(url("https://github.com/danielnixon/sbt-rjs"))
pomExtra := {
  <scm>
    <url>git@github.com:danielnixon/sbt-rjs.git</url>
    <connection>scm:git:git@github.com:danielnixon/sbt-rjs.git</connection>
  </scm>
    <developers>
      <developer>
        <id>danielnixon</id>
        <name>Daniel Nixon</name>
        <url>https://danielnixon.org/</url>
      </developer>
    </developers>
}

name := "sbt-rjs"

version := "1.0.10-SNAPSHOT"

scalaVersion := "2.10.6"

scalacOptions += "-feature"

libraryDependencies ++= Seq(
  "org.webjars.npm" % "requirejs" % "2.3.2"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.1.4")
addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.4.0")

scriptedSettings

scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }
