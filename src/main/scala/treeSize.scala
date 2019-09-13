package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object treeSize {
  def apply(s: Shape): Int = s match {
    case Rectangle(w: Int, h: Int)              => 1
    case Ellipse(w: Int, h: Int)                => 1
    case Location(x: Int, y: Int, shape: Shape) => apply(shape)
    case Group(s @ _*) =>
      var sum = 0
      for (c <- s) {
        sum += apply(c)
      }
      sum
  }
}
