package ru.tinkoff.fintech.lesson06.exercises.show.part2

trait Show[T] {
  def show: String
}

object ShowSyntax {
/*
  implicit class ShowOps(???) {
    def show: String: ???
  }
*/
}

trait ShowInstances {
/*
  implicit val stringShow = new Show[String] {
    ???
  }

  etc
*/
}

object Show

object Test {
  import Show._

  // 42.show
  // 42.0.show
  // "42".show
  // Map("key" -> 135).show
  // Map(135 -> 13.5).show
  // List(12,13,14).show
  // ...
}
