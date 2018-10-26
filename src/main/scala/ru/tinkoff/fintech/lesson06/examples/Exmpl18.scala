package ru.tinkoff.fintech.lesson06.examples

object Exmpl18 {
  object simple {
    trait Foo[T]
    trait Bar[T]

    implicit def root[T]: Bar[T] = new Bar[T] {}
    implicit def bar[T: Bar]: Foo[T] = new Foo[T] {}
    implicit def bar2[T: Bar]: Foo[T] = new Foo[T] {}
    implicit def foo[T: Foo](x: T) = x

    //err//foo[Int](42) // ambiguous implicit values bar bar2
  }
  object strange {
    trait Foo[T]
    trait Bar[T]

    implicit def root[T]: Bar[T] = new Bar[T] {}
    implicit def root2[T]: Bar[T] = new Bar[T] {}
    implicit def bar[T: Bar]: Foo[T] = new Foo[T] {}
    implicit def foo[T: Foo](x: T) = x

    //err//foo[Int](42) // ошибка could not find implicit Foo[Int], хотя на самом деле проблема в ambiguity Bar[T]
  }
}
