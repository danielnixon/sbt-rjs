lazy val main = (project in file("."))
  .enablePlugins(SbtWeb)
  .dependsOn(a)
  .settings(
    libraryDependencies += "org.webjars.npm" % "requirejs" % "2.2.0",
    pipelineStages := Seq(rjs)
  )

lazy val a = (project in file("modules/a"))
  .enablePlugins(SbtWeb)
  .dependsOn(b)

lazy val b = (project in file("modules/b"))
  .enablePlugins(SbtWeb)
