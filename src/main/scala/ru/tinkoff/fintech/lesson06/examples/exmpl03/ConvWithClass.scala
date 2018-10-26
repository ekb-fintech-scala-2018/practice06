package ru.tinkoff.fintech.lesson06.examples.exmpl03

object ConvWithClass {
  case class Foo(x: Int)

  implicit class FooOps(val foo: Foo) extends AnyVal {
    def bar(y: Int) = Foo(foo.x * 3)
  }

  def multi(x: FooOps): Foo = x.bar(3)

  multi(Foo(14))    // arguments conversion
  Foo(3).bar(14)    // call site conversion
}
