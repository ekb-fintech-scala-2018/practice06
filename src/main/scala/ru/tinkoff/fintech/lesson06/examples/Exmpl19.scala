package ru.tinkoff.fintech.lesson06.examples

object Exmpl19 {
  trait Foo[T]
  trait Bar[T]

  implicit def baz[T: Foo]: Bar[T] = new Bar[T] {}
  implicit def bar[T: Bar]: Foo[T] = new Foo[T] {}
  implicit def foo[T: Foo](x: T) = x

  foo[Int](42) // diverging implicit expansion
}
