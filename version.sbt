lazy val localVersion: String = s"${Version.Project}-SNAPSHOT"

ThisBuild / version := Publish.versionFromTagOpt.getOrElse(localVersion)
