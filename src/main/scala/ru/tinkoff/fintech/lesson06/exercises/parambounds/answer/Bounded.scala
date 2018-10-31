package ru.tinkoff.fintech.lesson06.exercises.parambounds.answer

object Bounded {
  sealed trait FeasibleArg[T] {
    def value: T
  }

  implicit class IntFeasibleArg(val x: Int) extends FeasibleArg[Int] {
    override def value: Int = x
  }

  implicit class StringFeasibleArg(val x: String) extends FeasibleArg[String] {
    override def value: String = x
  }

  type BoundedArg = FeasibleArg[_]

  def boundedArgsFunc(args: BoundedArg*): Int = args.map {
    case arg: IntFeasibleArg => arg.value
    case arg: StringFeasibleArg => arg.value.length
  }.sum
}

object test {
  import Bounded._

  println(boundedArgsFunc("42", 13, "28"))
  println(boundedArgsFunc(42, "13", "28", 22))
}