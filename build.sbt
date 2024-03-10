import Dependencies._

lazy val criteria4s: Project =
  project
    .in(file("."))
    .disablePlugins(AssemblyPlugin)
    .aggregate(core, sql, examples)
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

lazy val `spark-sql`: Project =
  (project in file("spark-sql"))
    .settings(
      name           := "criteria4s-spark",
      publish / skip := false,
      libraryDependencies += spark.sql % "provided"
    )
    .dependsOn(core, sql)

lazy val examples: Project =
  (project in file("examples"))
    .settings(
      name := "criteria4s-examples"
    )
    .dependsOn(core, sql)
