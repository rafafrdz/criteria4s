import sbt.*

object Dependencies {
  lazy val munit = "org.scalameta" %% "munit" % "0.7.29"

  object spark {
    lazy val sql = "org.apache.spark" %% "spark-sql" % "3.5.1"
  }
}
