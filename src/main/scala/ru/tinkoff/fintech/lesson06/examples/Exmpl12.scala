package ru.tinkoff.fintech.lesson06.examples

object Exmpl12 {
  trait Semigroup[T] {
    def ap(t1: T, t2: T): T
  }

  trait implicits0 {
    implicit val sumSemigroup = new Semigroup[Int] {
      override def ap(t1: Int, t2: Int): Int = t1 + t2
    }
  }

  object implicits1 extends implicits0 {
    implicit val mulSemigroup = new Semigroup[Int] {
      override def ap(t1: Int, t2: Int): Int = t1 * t2
    }
  }

  import implicits1._
  implicitly[Semigroup[Int]].ap(12, 12) // 144
}
