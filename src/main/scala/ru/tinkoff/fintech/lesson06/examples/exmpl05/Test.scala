package ru.tinkoff.fintech.lesson06.examples.exmpl05

object Test extends App {
  import eitherSyntax._

  val lft = Left[String,Int]("some") // Left[String,Int]
  val rgt = Right[String,Int](42)    // Right[String,Int]

  val lfts = "some".asLeft[Int] // Either[String,Int]
  val rgts = 42.asRight[String] // Either[String,Int]
}
