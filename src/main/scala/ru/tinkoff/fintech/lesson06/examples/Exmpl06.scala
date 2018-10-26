package ru.tinkoff.fintech.lesson06.examples


object Greeter {
  implicit val times: Int = 0
  def greetings(name: String)(implicit times: Int): Unit =  println("Hi " * times + name)
}

object Exmpl06 extends App {
  implicit val times: Int = 3
  Greeter.greetings("Michael") // Hi Hi Hi Michael, beacuse of call site resolve
}
