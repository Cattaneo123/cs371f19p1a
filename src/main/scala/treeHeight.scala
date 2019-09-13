package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object treeHeight {
  def apply(s: Shape): Int = s match {
    case Rectangle(w: Int, h: Int)              => 1
    case Ellipse(w: Int, h: Int)                => 1
    case Location(x: Int, y: Int, shape: Shape) => 1 + apply(shape)
    case Group(s @ _*) =>
      val Nheight = s.map(shape => treeHeight(shape))
      Nheight.max + 1
  }
}
