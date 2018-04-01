import mill._
import mill.scalalib._
import mill.scalajslib._
import coursier.maven.MavenRepository
import publish._

object scalajs extends ScalaJSModule {
  /** Main */
  def mainClass = Some("com.github.sguzman.scala.js.Main")

  /** ScalaJS version */
  def scalaJSVersion = "0.6.22"

  /** Name of project */
  def name = "MillScala.js"

  /** Organization */
  def organization = "com.github.sguzman"

  /** Project version */
  def version = "1.0"

  /** Scala version */
  def scalaVersion = "2.12.4"

  /** Scalac parameters */
  def scalacOptions = Seq("-Ydelambdafy:inline", "-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

  /** Javac parameters */
  def javacOptions = Seq("-server")

  /** Resolvers */
  def repositories = super.repositories ++ Seq(
    MavenRepository("https://repo1.maven.org/maven2"),
    MavenRepository("https://oss.sonatype.org/content/repositories/public"),
    MavenRepository("https://repo.typesafe.com/typesafe/releases"),
    MavenRepository("https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases"),
    MavenRepository("https://oss.sonatype.org/content/repositories/releases"),
    MavenRepository("https://oss.sonatype.org/content/repositories/snapshots"),
    MavenRepository("https://jcenter.bintray.com")
  )

  /** Ivy dependencies */
  def ivyDeps = Agg(
    ivy"com.thoughtworks.binding::dom_sjs0.6:11.0.1",
    ivy"org.scala-js::scalajs-dom_sjs0.6:0.9.5"
  )

  def scalacPluginIvyDeps = super.scalacPluginIvyDeps() ++ Agg(ivy"org.scalamacros:::paradise:2.1.1")

  def forkArgs = Seq("-Xmx4g")
}