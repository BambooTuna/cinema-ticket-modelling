import Settings._

lazy val domain = (project in file("domain"))
  .settings(commonSettings)
  .settings(
    name := "cinema-ticket-modelling-domain",
    libraryDependencies ++= Seq(
    )
  )