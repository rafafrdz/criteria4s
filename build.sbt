import Dependencies.ProjectOps

lazy val criteria4s: Project =
  project
    .in(file("."))
    .disablePlugins(Build, AssemblyPlugin, HeaderPlugin)
    .aggregate(core, sql, mongodb, examples)
    .settings(
      name := "criteria4s"
    )

lazy val core: Project =
  (project in file("core"))
    .settings(
      name           := "criteria4s-core",
      publish / skip := false
    )

lazy val sql: Project =
  (project in file("sql"))
    .settings(
      name           := "criteria4s-sql",
      publish / skip := false
    )
    .dependsOn(core)

lazy val mongodb: Project =
  (project in file("mongodb"))
    .settings(
      name := "criteria4s-mongodb",
      publish / skip := false
    )
    .dependsOn(core)

lazy val examples: Project =
  (project in file("examples"))
    .settings(
      name := "criteria4s-examples"
    )
    .dependsOn(core, sql, mongodb)
    .withKindProjector
