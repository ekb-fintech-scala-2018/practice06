package ru.tinkoff.fintech.lesson06.examples

object Exmpl16 {

  class A(val n: Int)
  object A {
    implicit val ord = new Ordering[A] {
      def compare(x: A, y: A) = implicitly[Ordering[Int]].compare(x.n, y.n)
    }
  }

  List(new A(5), new A(2)).sorted
  // требуется Ordering[A], превращается в

  List(new A(5), new A(2)).sorted(A.ord)
  // поиск имплисита в типе A, который являет аргументом типа Ordering[A]
}
