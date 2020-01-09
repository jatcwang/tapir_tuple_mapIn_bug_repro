val v = "0.12.12"
lazy val root = Project("root", file("."))
  .settings(commonSettings)
  .settings(
    name := "Scala Starter",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.1.0",
      "com.softwaremill.sttp.tapir" %% "tapir-core" % v,
      "com.softwaremill.sttp.tapir" %% "tapir-sttp-client" % v,
      "org.scalatest" %% "scalatest" % "3.1.0" % "test",
    ),
  )

lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := "2.13.1",
  scalacOptions --= {
    if (sys.env.get("CI").isDefined) {
      Seq.empty
    } else {
      Seq("-Xfatal-warnings")
    }
  },
)
