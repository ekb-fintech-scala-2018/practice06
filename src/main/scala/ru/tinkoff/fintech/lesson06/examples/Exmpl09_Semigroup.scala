package ru.tinkoff.fintech.lesson06.examples

object Exmpl09_Semigroup {
  trait Semigroup[T] {
    def ap(t1: T, t2: T): T
  }

  object Semigroup {
    implicit def intInstance[In]: Semigroup[Int] = new Semigroup[Int] {
      def ap(t1: Int, t2: Int): Int = t1 + t2
    }

    implicit def listInstance[T: Semigroup]: Semigroup[List[T]] = new Semigroup[List[T]] {
      def ap(t1: List[T], t2: List[T]): List[T] = {
        val semigoupT = implicitly[Semigroup[T]]
        t1.zip(t2).map(xy => semigoupT.ap(xy._1, xy._2))
      }
    }
  }

  import Semigroup._

  val forIntList = implicitly[Semigroup[List[Int]]]
  forIntList.ap(List(1,2,3), List(4,5,6))


  implicit class SemigroupOps[T: Semigroup](val self: T) {
    def |+|(other: T): T = implicitly[Semigroup[T]].ap(self, other)
  }

  List(1,2,3) |+| List(4,5,6)
}