package ru.tinkoff.fintech.lesson06.examples

object Exmpl11 {
  implicit def default(x: Any): Int = 0
  implicit def dbl(x: Double): Int = (x * x).toInt

  def foo(bar: Int) =
    bar + bar

  foo("some")
  foo(42.0) // подходят и default и dbl, выбран dbl
}
