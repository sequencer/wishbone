package wishbone
import chisel3.VecInit

/** For Wishbone, it's a master-salve protocol.
  * @note Different from diplomacy, this repository only focus on hardware generator,
  *       which leaves parameter negotiation to other phases.
  *
  */
trait Router { this: chisel3.Module =>
  val masters: Seq[WishboneInterfaceParameter]
  val slaves: Seq[WishboneInterfaceParameter]
  def reachability: Seq[Seq[Boolean]]
  lazy val i = IO(VecInit(masters.map(p => new WishboneInferface(p))))
  lazy val o = IO(VecInit(slaves.map(p => new WishboneInferface(p))))
}
