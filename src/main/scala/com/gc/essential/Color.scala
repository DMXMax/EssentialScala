package com.gc.essential

sealed trait Color {
  def red:Int
  def green:Int
  def blue:Int

}

case object Red extends Color {
  val red = 255
  val green = 0
  val blue = 0
}
