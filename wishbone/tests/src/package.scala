package wishbone

import freechips.rocketchip._
import diplomacy._
import config._
import subsystem._

package object tests {
  def configToLazyModule[L <: LazyModule](lazyModuleClass: Class[L], config: Config): L = {
    lazyModuleClass.getConstructors()(0).newInstance(config.toInstance).asInstanceOf[L]
  }
}
