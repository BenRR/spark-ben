import sbt._
import sbt.Keys._

object AssemblySettings {
  import sbtassembly.AssemblyPlugin._
  import sbtassembly.AssemblyKeys._
  lazy val sbtAssemblySettings = assemblySettings ++ Seq(
    jarName in assembly := {
      name.value + "-" + version.value + ".jar"
    }
  )
}

object SparkBenBuild extends Build {

  val sparkCore = "org.apache.spark"%%"spark-core"%"1.2.0"% "provided"
  lazy val sparkbenbuild = Project(
    id = "spark-ben",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "spark-ben",
      organization := "com.melbourne.ben",
      version := "0.0.1",
      scalaVersion := "2.10.2",
      libraryDependencies ++= Seq(sparkCore)
    ) ++ AssemblySettings.sbtAssemblySettings 
  )
}
