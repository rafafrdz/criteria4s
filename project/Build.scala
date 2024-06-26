import sbt.*
import sbt.Keys.*
import sbt.plugins.JvmPlugin
import sbtassembly.AssemblyKeys.*
import sbtassembly.{MergeStrategy, PathList}

object Build extends AutoPlugin {

  override def requires: Plugins = JvmPlugin

  override def trigger: PluginTrigger = allRequirements

  lazy val jvmSettings: Seq[String] = Seq(
    "-XX:+UseG1GC",
    "-XshowSettings:vm",
    "-XX:+PrintCommandLineFlags"
  )

  lazy val localJvmSettings: Seq[String] =
    Seq("-Xms384M", "-Xmx384M", "-XX:MaxMetaspaceSize=150M", "-XX:+PrintCommandLineFlags")

  override def projectSettings: Seq[Setting[_]] =
    Vector(
      ThisBuild / organization       := "io.github.rafafrdz",
      ThisBuild / name               := "criteria-dsl",
      ThisBuild / scalaVersion       := Version.Scala,
      ThisBuild / crossScalaVersions := Vector(ScalaCross.ScalaVersions: _*),
      ThisBuild / javacOptions       := Seq("-g:none"),
      ThisBuild / run / javaOptions ++= localJvmSettings,
      ThisBuild / run / fork  := true,
      ThisBuild / Test / fork := true,
      ThisBuild / scalacOptions ++= Vector(
        "-target:jvm-1.8",
        "-deprecation", // Emit warning and location for usages of deprecated APIs.
        "-encoding",
        "utf-8",         // Specify character encoding used by source files.
        "-explaintypes", // Explain type errors in more detail.
        "-feature", // Emit warning and location for usages of features that should be imported explicitly.
        "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
        "-language:experimental.macros", // Allow macro definition (besides implementation and application)
        "-language:higherKinds",         // Allow higher-kinded types
        "-language:implicitConversions", // Allow definition of implicit functions called views
        "-unchecked",  // Enable additional warnings where generated code depends on assumptions.
        "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
        //        "-Xfatal-warnings", // Fail the compilation if there are any warnings.
        //        "-Xfuture", // Turn on future language features.
        "-Xlint:adapted-args", // Warn if an argument list is modified to match the receiver.
        //        "-Xlint:by-name-right-associative", // By-name parameter of right associative operator.
        "-Xlint:constant", // Evaluation of a constant arithmetic expression results in an error.
        "-Xlint:delayedinit-select", // Selecting member of DelayedInit.
        "-Xlint:doc-detached",       // A Scaladoc comment appears to be detached from its element.
        "-Xlint:inaccessible",       // Warn about inaccessible types in method signatures.
        //        "-Xlint:infer-any", // Warn when a type argument is inferred to be `Any`.
        "-Xlint:missing-interpolator", // A string literal appears to be missing an interpolator id.
        //        "-Xlint:nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
        "-Xlint:nullary-unit",           // Warn when nullary methods return Unit.
        "-Xlint:option-implicit",        // Option.apply used implicit view.
        "-Xlint:package-object-classes", // Class or object defined in package object.
        "-Xlint:poly-implicit-overload", // Parameterized overloaded implicit methods are not visible as view bounds.
        "-Xlint:private-shadow", // A private field (or class parameter) shadows a superclass field.
        "-Xlint:stars-align",    // Pattern sequence wildcard must align with sequence component.
        "-Xlint:type-parameter-shadow", // A local type parameter shadows a type already in scope.
        //        "-Xlint:unsound-match", // Pattern match may not be typesafe.
        //        "-Yno-adapted-args", // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
        //        "-Ypartial-unification", // Enable partial unification in type constructor inference
        "-Ywarn-dead-code",      // Warn when dead code is identified.
        "-Ywarn-extra-implicit", // Warn when more than one implicit parameter section is defined.
        //        "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
        //        "-Ywarn-infer-any", // Warn when a type argument is inferred to be `Any`.
        //        "-Ywarn-nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
        //        "-Ywarn-nullary-unit", // Warn when nullary methods return Unit.
        //        "-Ywarn-numeric-widen", // Warn when numerics are widened.
        "-Ywarn-unused:implicits", // Warn if an implicit parameter is unused.
        "-Ywarn-unused:imports",   // Warn if an import selector is not referenced.
        "-Ywarn-unused:locals",    // Warn if a local definition is unused.
        "-Ywarn-unused:explicits", // Warn if a value parameter is unused.
        "-Ywarn-unused:params",
        "-Ywarn-unused:patvars",  // Warn if a variable bound in a pattern is unused.
        "-Ywarn-unused:privates", // Warn if a private member is unused.
        "-Ywarn-macros:after",
        "-Ymacro-annotations"
      ),
      // note that the REPL can’t really cope with -Ywarn-unused:imports or -Xfatal-warnings so you should turn them off for the console
      Compile / console / scalacOptions ~= (_.filterNot(
        Set(
          "-Xfatal-warnings",
          "-Ywarn-unused:imports"
        )
      )),
      ThisBuild / updateOptions := updateOptions.value
        .withCachedResolution(cachedResolution = false),
      // do not build and publish scaladocs
      ThisBuild / Compile / doc / sources := Seq.empty,
      // Remove this one because: https://github.com/sbt/sbt-ci-release/issues/168
      // ThisBuild / Compile / packageDoc / publishArtifact := false,
      // show full stack traces and test case durations
      ThisBuild / Test / testOptions += Tests.Argument("-oDF"),
      // -v Log "test run started" / "test started" / "test run finished" events on log level "info" instead of "debug"
      // -a Show stack traces and exception class name for AssertionErrors
      ThisBuild / Test / testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "-a")
    )

  lazy val assemblySettings = Seq(
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x =>
        val oldStrategy = (assembly / assemblyMergeStrategy).value
        oldStrategy(x)
    },
    assembly / assemblyJarName := s"${name.value}-${version.value}.jar"
  )
}
