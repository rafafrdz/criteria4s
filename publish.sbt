import xerial.sbt.Sonatype.*

ThisBuild / organization         := "io.github.rafafrdz"
ThisBuild / organizationName     := "rafafrdz"
ThisBuild / sonatypeProfileName  := "io.github.rafafrdz"
ThisBuild / organizationHomepage := Some(url("https://github.com/rafafrdz"))
ThisBuild / homepage             := Some(url("https://github.com/rafafrdz/criteria4s"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/rafafrdz/criteria4s"),
    "scm:git@github.com:rafafrdz/criteria4s.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id = "rafafrdz",
    name = "Rafael Fernández Ortiz",
    email = "criteria4s@rafaelfernandez.dev",
    url = url("https://github.com/rafafrdz")
  )
)
ThisBuild / description := "A simple DSL to create criterias for filtering data in Scala."
ThisBuild / licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / publish / skip       := true
ThisBuild / versionScheme        := Some("early-semver")
ThisBuild / pomIncludeRepository := { _ => false }

/** Reference the project OSS repository */
// Repository for releases on Maven Central using Sonatype
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
ThisBuild / sonatypeRepository     := "https://s01.oss.sonatype.org/service/local"
ThisBuild / sonatypeProjectHosting := Some(
  GitHubHosting(
    user = "rafafrdz",
    repository = "criteria4s",
    email = "criteria4s@rafaelfernandez.dev"
  )
)
