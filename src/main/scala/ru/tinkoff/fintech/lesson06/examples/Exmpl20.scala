package ru.tinkoff.fintech.lesson06.examples

object Exmpl20 extends App {
  trait CallLogger extends RecursiveLog{
    def log[T1, T2, R](f: {def curried: T1 => T2 => R})
                          (implicit un: Unwind[T1, T2 => R]): un.Res = un.apply(f.curried)

    def log[T1, R](f: T1 => R)
                      (implicit un: Unwind[T1, R]): un.Res = un.apply(f)
  }

  trait Unwind[A, B] {
    type Res
    def apply(f: A => B): Res

  }

  trait LowLog {
    implicit def f1Unwind[A, B] = new Unwind[A, B] {
      type Res = A => B

      def apply(f: A => B): Res = {x =>
        println(x)
        f.apply(x)
      }
    }
  }

  trait RecursiveLog extends LowLog {
    implicit def fNUnwind[A, B, C](implicit un: Unwind[B, C]) = new Unwind[A, B => C] {
      type Res = A => un.Res
      def apply(f: A => B => C): Res = {a =>
        println(a)
        un.apply(f.apply(a))
      }
    }
  }

  object call_logga extends CallLogger


  import call_logga._

  val fn1: Int => Int = {_ + 1}
  val fn3: (Int, Int, Int) => Int = {_ + _ + _ + 1}

  val logFn1 = log(fn1)
  val logFn3 = log(fn3)

  println(logFn1(10))
  println(logFn3(20)(21)(22))
}
