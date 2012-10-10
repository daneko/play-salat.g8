// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "$play_version$")

// Use scalaRiform
//addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "latest.integration")
addSbtPlugin("com.typesafe.sbtscalariform" % "sbtscalariform" % "0.4.0")

