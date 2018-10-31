package ru.tinkoff.fintech.lesson06.examples

object Exmpl17 {
  trait Foo[T]
  trait Bar[T]

//  implicit def root[T]: Bar[T] = new Bar[T] {}
  implicit def bar[T: Bar]: Foo[T] = new Foo[T] {}
  implicit def foo[T: Foo](x: T) = x

  foo[Int](42) // ошибка could not find implicit Foo[Int], хотя на самом деле проблема в Bar[T]
}
