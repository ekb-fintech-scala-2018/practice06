package ru.tinkoff.fintech.lesson06.examples

object Exmpl04 {
  object Rule1 extends App {
    implicit def str2Int1(s: String): Int = Integer.parseInt(s) // имплисит
    def str2Int2(s: String): Int = Integer.parseInt(s) + 1 // не имплисит!!!

    println(3 / "3": Int)
  }


  object Rule2 extends App {
    implicit def str2Int(s: String): Int = Integer.parseInt(s) // имплисит

    object OutOufScope {
      implicit def str2Int(s: String): Int = Integer.parseInt(s) / 3 // не в области видимости
    }

    println(3 / "3": Int)
  }

  object Rule3  extends App {
    case class Foo(x: Int)
    implicit def foo2Int1(foo: Foo): Int = foo.x
    implicit def any2Int(foo: Any): Int = 42
//    implicit def foo2Int2(foo: Foo): Int = foo.x * 2 // если убрать этот, то появится однозначность

    val x: Int = Foo(21)
  }

  object Rule4  extends App {
    case class Bar(x: Int)
    case class Foo(x: Int)
    implicit def foo2Int(foo: Foo): Int = foo.x
    implicit def bar2Foo(bar: Bar): Foo = Foo(bar.x)

//    val x: Int = Bar(21) // казалось бы можно найти Bar -> Foo -> Int
  }

  object Rule5  extends App {
    implicit def int2String(x: Int) = s"$x$x"

    val intVal = 21 + 21 // преобразование не будет применено, typecheck в порядке
    val strVal: String = 21 + 21 // преобразование будет применено, причем к выражению (21 + 21)

    println(intVal)
    println(strVal)
  }
}
