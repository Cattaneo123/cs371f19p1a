package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object treeScale {
  def apply(scale: Int, s: Shape): Shape = s match {
    case Rectangle(w: Int, h: Int)              => Location(0, 0, Rectangle(scale * w, scale * h))
    case Ellipse(w: Int, h: Int)                => Location(-w * scale, -h * scale, Rectangle(w * 2 * scale, h * 2 * scale))
    case Location(x: Int, y: Int, shape: Shape) => Location(x * scale, y * scale, treeScale(scale, shape))
    case Group(s @ _*)                          => Group(s.map(sc => treeScale(scale, sc)): _*)
  }
}
