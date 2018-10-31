package ru.tinkoff.fintech.lesson06.exercises.show.part1.answer

object Show {
  implicit class IntShow(val value: Int) extends AnyVal {
    def show: String = s"int: $value"
  }
  implicit class DoubleShow(val value: Double) extends AnyVal {
    def show: String = s"double: $value"
  }
  implicit class StringShow(val value: String) extends AnyVal {
    def show: String = s"string: $value"
  }
}

object Test {
  import Show._

  42.show
  42.0.show
  "42".show
}
