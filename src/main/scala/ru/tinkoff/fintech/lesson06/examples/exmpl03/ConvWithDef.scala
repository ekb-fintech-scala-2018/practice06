package ru.tinkoff.fintech.lesson06.examples.exmpl03
import scala.language.implicitConversions

object ConvWithDef {
  case class Foo(x: Int)

  class FooOps(foo: Foo) {
    def bar(y: Int) = Foo(foo.x * 3)
  }

  implicit def foo2FooOps(foo: Foo): FooOps = new FooOps(foo)

  def multi(x: FooOps): Foo = x.bar(3)

  multi(Foo(14))    // arguments conversion
  Foo(3).bar(14)    // call site conversion
}
