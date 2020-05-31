package com.gc.essential

sealed trait Shape {
  def nSides: Double
  def perimeter: Double
  def area: Double
}

sealed trait Rectangular extends Shape{
  val nSides = 4
  val width:Double
  val height:Double
  override def  perimeter:Double = (width+height)*2
  override def  area:Double = (width*height)
}

case class Circle(radius:Double) extends Shape {
  val nSides = 1
  val perimeter = math.Pi*(2*radius)
  val area = math.Pi*(radius * radius)
}

case class Rectangle(width:Double, height:Double) extends Rectangular
case class Square(side:Double) extends Rectangular{
  val width=side
  val height=side
}
object ScreenPrinter{
  def apply(shape:Shape):Unit ={
    println(Draw(shape))
  }
}

object Draw{
  def apply(shape:Shape):String ={
    shape match {
      case s:Circle => f"A circle with perimeter ${s.perimeter}%.2f and area ${s.area}%.2f"
      case s:Rectangle => f"A rectangle with perimeter ${s.perimeter}%.2f and area ${s.area}%.2f"
      case s:Square => f"A square with perimeter ${s.perimeter}%.2f and area ${s.area}%.2f"
    }
  }
}

object myApp extends App {
  ScreenPrinter(Circle(2.2))
  ScreenPrinter(Rectangle(3,4))
  ScreenPrinter(Square(2.2))
  println(Red.red)

}


