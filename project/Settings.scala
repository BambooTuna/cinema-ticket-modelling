import sbt.Keys._
import sbt._
import com.lucidchart.sbt.scalafmt.ScalafmtCorePlugin.autoImport._

object Settings {
  lazy val commonSettings = Seq(
    organization := "com.github.BambooTuna",
    scalaVersion := "2.12.8",
    libraryDependencies ++= Seq(
      ScalaTest.version     % Test,
      ScalaCheck.scalaCheck % Test,
      ScalaMock.version     % Test,
      Enumeratum.version,
      Logback.classic,
      LogstashLogbackEncoder.encoder,
    ),
    scalafmtOnCompile in Compile := true,
    scalafmtTestOnCompile in Compile := true
  )
}
