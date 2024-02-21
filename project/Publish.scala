object Publish {

  lazy val tagWithQualifier: String => String => String =
    qualifier => tagVersion => s"%s.%s.%s-${qualifier}%s".format(tagVersion.split("\\."): _*)

  lazy val tagAlpha: String => String     = tagWithQualifier("a")
  lazy val tagBeta: String => String      = tagWithQualifier("b")
  lazy val tagMilestone: String => String = tagWithQualifier("m")
  lazy val tagRC: String => String        = tagWithQualifier("rc")

  lazy val defaultVersion: String = "0.0.0-a0"

  lazy val refFromTag: Option[String] = sys.env
    .get("GITHUB_REF_TYPE")
    .filter(_ == "tag")
    .flatMap(_ => sys.env.get("GITHUB_REF_NAME"))

  lazy val versionFromTagOpt: Option[String] =
    refFromTag
      .flatMap { t =>
        t.headOption.flatMap {
          case 'a' => Option(tagAlpha(t.tail))     // Alpha build, a1.2.3.4
          case 'b' => Option(tagBeta(t.tail))      // Beta build, b1.2.3.4
          case 'm' => Option(tagMilestone(t.tail)) // Milestone build, m1.2.3.4
          case 'r' => Option(tagRC(t.tail))        // RC build, r1.2.3.4
          case 'v' => Option(t.tail)               // Production build, should be v1.2.3
          case _   => Option.empty[String]
        }
      }

  lazy val versionFromTag: String = versionFromTagOpt.getOrElse(defaultVersion)

}
