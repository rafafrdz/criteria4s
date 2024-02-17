lazy val `criterial-dsl`: Project =
  project
    .in(file("."))
    .disablePlugins(AssemblyPlugin)
    .aggregate(core, sql, examples)
    .settings(
      name := "criterial-dsl"
    )

lazy val core: Project =
  (project in file("core"))
    .settings(
      name           := "core",
      publish / skip := false
    )

lazy val sql: Project =
  (project in file("sql"))
    .settings(
      name           := "sql",
      publish / skip := true
    )
    .dependsOn(core)


lazy val examples: Project =
  (project in file("examples"))
    .settings(
      name           := "examples",
      publish / skip := true
    )
    .dependsOn(core, sql)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
