package edu.luc.cs.laufer.cs372.shapes

/**
  * data Shape = Rectangle(w, h) | Location(x, y, Shape)
  */
sealed trait Shape

case class Rectangle(width: Int, height: Int) extends Shape {
  require(width != 0, "W cannot be 0")
  require(height != 0, "H cannot be 0")

}

case class Group(shapes: Shape*) extends Shape {
  require(shapes != null, "null shape in location") // TODO is this sufficient?

}

case class Ellipse(width: Int, height: Int) extends Shape {
  require(width != 0, "W cannot be 0")
  require(height != 0, "H cannot be 0")
}

case class Location(x: Int, y: Int, shape: Shape) extends Shape {
  require(shape != null, "null shape in location")

}

// TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments
