package ru.tinkoff.fintech.lesson06.examples

  object Exmpl01 {
  println(1 to 42)
  1 to 42
  Predef.intWrapper(1).to(42)

  println(10.5 + "42")
  10.5 + "42"
  Predef.any2stringadd(10.5) + "42"

  println("foo" -> 13)
  "foo" -> 13
  Predef.ArrowAssoc("foo").->(13)

  println(List(3 -> 1, 1 -> 2, 1 -> 1, 2 -> 5).sorted)
  List(3 -> 1, 1 -> 2, 1 -> 1, 2 -> 5).sorted
  List(
    Predef.ArrowAssoc(3).->(1),
    Predef.ArrowAssoc(1).->(2),
    Predef.ArrowAssoc(1).->(1),
    Predef.ArrowAssoc(2).->(5)
  ).sorted(
    scala.math.Ordering.Tuple2(
      scala.math.Ordering.Int,
      scala.math.Ordering.Int
    )
  )
}
