package ru.tinkoff.fintech.lesson06.examples

import scala.language.implicitConversions

object Exmpl02 extends App {
  implicit def str2Int(s: String) = {
    Integer.parseInt(s)
  }

  3 / "3": Int          // arguments conversion: 3 / str2Int("3")
  3 + "3": String       // call site conversion: any2stringadd(3).+("3")
}