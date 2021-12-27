package wishbone

import chisel3._
import chisel3.util.experimental.BitSet

trait StaticRouter extends Router { this: chisel3.Module =>
  /** For each transaction from master,
    * which address should be routed to?
    *
    * @example There are two slaves: s0 and s1
    *          address 0x0000 -> 0x0fff will be route to s0
    *                  0x1000 -> 0x1fff will be route to s1
    *          This should be set to `Seq(0x0???, 0x1???)`
    *
    * This table should be resolved by [[chisel3.util.experimental.decode.decoder.bitset]]
    */
  def masterToSlaveRouteTable: Seq[BitSet]

  /** if a slave received a transaction from any master.
    * correspond index of this register should be altered to
    * id of the master(encoded in OneHot) that sends this transaction.
    */
  lazy val salveToMasterRouteTable: Vec[UInt] = Reg(Vec(slaves.size, UInt(masters.size.W)))
}
