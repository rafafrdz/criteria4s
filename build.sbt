lazy val criterialDSL: Project =
  project
    .in(file("."))
    .disablePlugins(AssemblyPlugin)
    .enablePlugins(NoPublish)
    .dependsOn(core, examples)

lazy val core: Project =
  (project in file("core"))
    .settings(
      name := "core"
    )

lazy val examples: Project =
  (project in file("examples"))
    .settings(
      name           := "examples",
      publish / skip := true
    )
    .dependsOn(core)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
