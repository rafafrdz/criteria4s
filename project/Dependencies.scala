import sbt._

object Dependencies {
  lazy val munit = "org.scalameta" %% "munit" % "0.7.29"

  implicit class ProjectOps(val prj: Project) extends AnyVal {
    def withKindProjector: Project = prj.settings(
      addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full)
    )
  }
}
