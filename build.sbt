organization in ThisBuild := "org.jetbrains"

version in ThisBuild := "0.3.11"

scalaVersion in ThisBuild := "2.12.6"

//ideaBuild in ThisBuild := "182.4323.6"
ideaBuild in ThisBuild := "192.6603.28"

ideaPluginName in ThisBuild := "library-test-ijext"

lazy val library = project.in(file("library")).settings(
  name := "library-test",
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val support = project.in(file("ijext")).dependsOn(library).settings(
  name := "library-test-ijext",
  ideaExternalPlugins += IdeaPlugin.Id("Scala", "org.intellij.scala", None),
  ideaInternalPlugins += "java"
).aggregate(library).enablePlugins(SbtIdeaPlugin)

lazy val testProject = project.in(file("test-project"))
  .settings(
//    uncomment and reimport project after running support/publishLocal
//    libraryDependencies += "org.jetbrains" %% "library-test" % (version in ThisBuild).value
  )