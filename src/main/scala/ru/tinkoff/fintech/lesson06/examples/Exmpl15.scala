package ru.tinkoff.fintech.lesson06.examples

object Exmpl15 {
  class A(val n: Int) {
    def +(other: A) = new A(n + other.n)
  }
  object A {
    implicit def fromInt(n: Int) = new A(n)
  }

  1 + new A(1)
  // превращается в

  A.fromInt(1) + new A(1)
  // implicit был найден в компаньоне типа A
  // (то есть в области видимости implicit'ов типа аргумента (A))
}
