import sbt._
import Keys._
import PlayProject._
import com.typesafe.sbtscalariform.ScalariformPlugin._
import scalariform.formatter.preferences._

object ApplicationBuild extends Build {

    val appName         = "$application_name$"
    val appVersion      = "1.0"

    lazy val riformKeys = ScalariformKeys.preferences := FormattingPreferences().setPreference(AlignSingleLineCaseStatements, true)

    val appDependencies = Seq(
      "se.radley" %% "play-plugins-salat" % "$salat_plugin_version$"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      routesImport += "se.radley.plugin.salat.Binders._",
      templatesImport += "org.bson.types.ObjectId",
      resolvers += "Sonatype" at "https://oss.sonatype.org/content/repositories/snapshots"
    ).settings(scalariformSettings: _*).settings(riformKeys)

}
