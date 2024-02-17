val tagWithQualifier: String => String => String =
  qualifier => tagVersion => s"%s.%s.%s-${qualifier}%s".format(tagVersion.split("\\."): _*)

val tagAlpha: String => String     = tagWithQualifier("a")
val tagBeta: String => String      = tagWithQualifier("b")
val tagMilestone: String => String = tagWithQualifier("m")
val tagRC: String => String        = tagWithQualifier("rc")

val defaultVersion: String = "0.0.0-a0"
val versionFromTag: String = sys.env
  .get("GITHUB_REF_TYPE")
  .filter(_ == "tag")
  .flatMap(_ => sys.env.get("GITHUB_REF_NAME"))
  .flatMap { t =>
    t.headOption.map {
      case 'a' => tagAlpha(t.tail)     // Alpha build, a1.2.3.4
      case 'b' => tagBeta(t.tail)      // Beta build, b1.2.3.4
      case 'm' => tagMilestone(t.tail) // Milestone build, m1.2.3.4
      case 'r' => tagRC(t.tail)        // RC build, r1.2.3.4
      case 'v' => t.tail               // Production build, should be v1.2.3
      case _   => defaultVersion
    }
  }
  .getOrElse(defaultVersion)

ThisBuild / organization         := "io.github.rafafrdz"
ThisBuild / organizationName     := "rafafrdz"
ThisBuild / organizationHomepage := Some(url("https://github.com/rafafrdz"))
ThisBuild / description := "A simple DSL to create criterias for filtering data in Scala."
ThisBuild / developers := List(
  Developer(
    id    = "rafafrdz",
    name  = "Rafael Fernández Ortiz",
    email = "youremail@address.com",
    url   = url("https://github.com/rafafrdz")
  )
)
ThisBuild / licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / publish / skip       := true
ThisBuild / publishMavenStyle    := true
ThisBuild / versionScheme        := Some("early-semver")
ThisBuild / publishTo := Some(
  "GitHub Package Registry" at "https://maven.pkg.github.com/rafafrdz/criterial-dsl"
)
ThisBuild / credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  "rafafrdz",
  sys.env.getOrElse("GITHUB_TOKEN", "")
)
