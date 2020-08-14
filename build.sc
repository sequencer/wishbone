import mill._
import scalalib._
import scalafmt._
import $ivy.`com.lihaoyi::mill-contrib-bsp:$MILL_VERSION`

object wishbone extends ScalaModule with ScalafmtModule {
  def scalaVersion = "2.12.12" 
  def ivyDeps = Agg(
    ivy"edu.berkeley.cs::rocketchip:1.2.1"
  )
  object tests extends Tests {
    override def ivyDeps = Agg(ivy"com.lihaoyi::utest:latest.integration")
    def testFrameworks = Seq("utest.runner.Framework")
  }
}
