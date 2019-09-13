package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

import TestFixtures._

class TestBoundingBox extends FunSuite {

  def testBoundingBox(description: String, s: Shape, x: Int, y: Int, width: Int, height: Int) = {
    test(description) {
      val Location(u, v, Rectangle(w, h)) = boundingBox(s)
      assert(x === u)
      assert(y === v)
      assert(width === w)
      assert(height === h)
    }
  }

  def testTreeHeight(description: String, s: Shape, Xheight: Int) = {
    test(description) {
      val Height = treeHeight(s)
      assert(Xheight === Height)
    }
  }

  def testTreeSize(description: String, s: Shape, XSize: Int) = {
    test(description) {
      val Size = treeSize(s)
      assert(XSize === Size)
    }
  }

  def testTreeScale(description: String, s: Shape, factor: Int, GShape: String) = {
    test(description) {
      val NShape = treeScale(factor, s)
      val str: String = NShape + ""
      assert(str === GShape)
    }
  }

  // TODO comment these tests back in

  testBoundingBox("simple ellipse", simpleEllipse, -50, -30, 100, 60)
  testBoundingBox("simple rectangle", simpleRectangle, 0, 0, 80, 120)
  testBoundingBox("simple location", simpleLocation, 70, 30, 80, 120)
  testBoundingBox("basic group", basicGroup, -50, -30, 100, 70)
  testBoundingBox("simple group", simpleGroup, 150, 70, 350, 280)
  testBoundingBox("complex group", complexGroup, 30, 60, 470, 320)
  testTreeHeight("simple ellipse2", simpleEllipse, 1)
  testTreeHeight("simple rectangle2", simpleRectangle, 1)
  testTreeHeight("simple location2", simpleLocation, 2)
  testTreeHeight("basic group2", basicGroup, 2)
  testTreeHeight("simple group2", simpleGroup, 3)
  testTreeHeight("complex group2", complexGroup, 6)
  testTreeSize("simple ellipse3", simpleEllipse, 1)
  testTreeSize("simple rectangle3", simpleRectangle, 1)
  testTreeSize("simple location3", simpleLocation, 1)
  testTreeSize("basic group3", basicGroup, 2)
  testTreeSize("simple group3", simpleGroup, 2)
  testTreeSize("complex group3", complexGroup, 5)

  testTreeScale("simple ellipse4", simpleEllipse, 2, "Location(-100,-60,Rectangle(200,120))")
  testTreeScale("simple Rectangle4", simpleRectangle, 2, "Location(0,0,Rectangle(160,240))")
  testTreeScale("simple Location4", simpleRectangle, 2, "Location(0,0,Rectangle(160,240))")
  testTreeScale("basic group4", basicGroup, 2, "Group(ArrayBuffer(Location(-100,-60,Rectangle(200,120)), Location(0,0,Rectangle(40,80))))")
  testTreeScale("simple group4", simpleGroup, 2, "Group(ArrayBuffer(Location(400,200,Location(-100,-60,Rectangle(200,120))), Location(800,600,Location(0,0,Rectangle(200,100)))))")
  testTreeScale("complex group4", complexGroup, 2, "Location(100,200,Group(ArrayBuffer(Location(-40,-80,Rectangle(80,160)), Location(300,100,Group(ArrayBuffer(Location(0,0,Rectangle(100,60)), Location(0,0,Rectangle(600,120)), Location(200,400,Location(-100,-60,Rectangle(200,120)))))), Location(0,0,Rectangle(200,400)))))")

  println(treeScale(2, simpleEllipse))
  println(treeScale(2, simpleRectangle))
  println(treeScale(2, simpleLocation))
  println(treeScale(2, basicGroup))
  println(treeScale(2, simpleGroup))

  println(treeScale(2, complexGroup))

}
