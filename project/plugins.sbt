/** Build */
addSbtPlugin("com.eed3si9n"      % "sbt-assembly" % "2.3.0")
addSbtPlugin("org.scalameta"     % "sbt-scalafmt" % "2.5.2")
addSbtPlugin("de.heikoseeberger" % "sbt-header"   % "5.10.0")

/** Publish */
addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.9.2")