package ru.tinkoff.fintech.lesson06.examples

object Exmpl14 {
  object Case1 {
    for {
      x <- List(1, 2, 3)
      y <- Some('x')
    } yield (x, y)
    // превращается в

    List(1, 2, 3).flatMap(x => Some('x').map(y => (x, y)))
    // но Some не Iterable, поэтому превращается в

    List(1, 2, 3).flatMap(x => Option.option2Iterable(Some('x')).map(y => (x, y)))
    // поиск implicit производился в object Option
  }

  object Case2 {
    List(1, 2, 3).sorted
    // для sorted еужен Ordering, и это выражение преврашается в

    List(1, 2, 3).sorted(Ordering.Int)
    // поиск implicit производился в expected type companion object - Ordering
  }
}
