name := """advm"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.2.1-2",
  "org.webjars" % "angularjs" % "1.2.13"
)

libraryDependencies += "org.mongodb" %% "casbah" % "2.7.0"

libraryDependencies += "com.novus" %% "salat" % "1.9.6"

play.Project.playScalaSettings

requireJs += "app.js"

requireJsShim += "app.js"

