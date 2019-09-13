package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object boundingBox {
  def apply(s: Shape): Location = s match {
    case Rectangle(w: Int, h: Int) => Location(0, 0, Rectangle(w, h))
    case Ellipse(w: Int, h: Int)   => Location(-w, -h, Rectangle(w * 2, h * 2))
    case Location(x: Int, y: Int, shape: Shape) =>
      val NBB = boundingBox(shape)
      var rectW = NBB.shape.asInstanceOf[Rectangle].width
      var rectH = NBB.shape.asInstanceOf[Rectangle].height
      var XInner = NBB.x
      var YInner = NBB.y
      Location((x + XInner), (y + YInner), Rectangle(rectW, rectH))

    case Group(s @ _*) =>
      val NShapes = s.map(shape => boundingBox(shape))
      val xs = NShapes.map(L => L.x)
      val ys = NShapes.map(L => L.y)
      val ws = NShapes.map(L => L.shape.asInstanceOf[Rectangle].width)
      val hs = NShapes.map(L => L.shape.asInstanceOf[Rectangle].height)

      val maxX = xs.min
      val maxY = ys.min
      val maxW = NShapes.map(L => L.x + L.shape.asInstanceOf[Rectangle].width - maxX).max
      val maxH = NShapes.map(L => L.y + L.shape.asInstanceOf[Rectangle].height - maxY).max

      Location(maxX, maxY, Rectangle(maxW, maxH))
    case _ => Location(0, 0, Rectangle(0, 0)) // not yet implemented
  }
}
