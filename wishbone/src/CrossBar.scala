package wishbone

import chisel3._
import chisel3.util.experimental.BitSet

case class CrossBarParameter(
  masters:                 Seq[WishboneInterfaceParameter],
  slaves:                  Seq[WishboneInterfaceParameter],
  reachability:            Seq[Seq[Boolean]],
  masterToSlaveRouteTable: Seq[BitSet]) {
  /* TODO: add some assertion to make sure hardware is valid. */
}

class CrossBar(crossBarParameter: CrossBarParameter) extends Module with StaticRouter {
  val masters:                 Seq[WishboneInterfaceParameter] = crossBarParameter.masters
  val slaves:                  Seq[WishboneInterfaceParameter] = crossBarParameter.slaves
  def masterToSlaveRouteTable: Seq[BitSet] = crossBarParameter.masterToSlaveRouteTable
  def reachability:            Seq[Seq[Boolean]] = crossBarParameter.reachability
  /* invoke lazy hardware at first, in case of any dependency parameter. */
  (i, o, salveToMasterRouteTable)
}
