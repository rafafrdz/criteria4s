
import Publish.refFromTag

ThisBuild / organization         := "io.github.rafafrdz"
ThisBuild / organizationName     := "rafafrdz"
ThisBuild / organizationHomepage := Some(url("https://github.com/rafafrdz"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/rafafrdz/criteria-dsl"),
    "scm:git@github.com:rafafrdz/criteria-dsl.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id = "rafafrdz",
    name = "Rafael Fernández Ortiz",
    email = "youremail@address.com",
    url = url("https://github.com/rafafrdz")
  )
)
ThisBuild / description := "A simple DSL to create criterias for filtering data in Scala."
ThisBuild / licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / publish / skip    := true
ThisBuild / publishMavenStyle := true
ThisBuild / versionScheme     := Some("early-semver")
ThisBuild / pomIncludeRepository := { _ => false }

ThisBuild / publishTo := {
  val nexus: String = "https://s01.oss.sonatype.org/"
  nexusFromTag(nexus)
}


ThisBuild / homepage := Some(url("https://github.com/rafafrdz/criteria-dsl"))
Global / credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials")
def nexusFromTag(nexus: String): Option[MavenRepository] =
  refFromTag
    .flatMap { t =>
      t.headOption.map {
        case 'v' =>
          Some(
            "releases" at nexus + "service/local/staging/deploy/maven2/"
          ) // Production build, should be v1.2.3
        case _ => Some("snapshots" at nexus + "content/repositories/snapshots/")
      }
    }
    .getOrElse(Some("snapshots" at nexus + "content/repositories/snapshots/"))
