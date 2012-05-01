import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "$application_name$"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      "se.radley" %% "play-plugins-salat" % "$salat_plugin_version$"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      routesImport += "se.radley.plugin.salat.Binders._",
      templatesImport += "org.bson.types.ObjectId"  
    )

}