package ru.tinkoff.fintech.lesson06.examples

object Exmpl07 {
  object Funcy {
    // baz - полиморфный неявный параметр
    def tostr[T](str: String, bar: T)(implicit int: Int, baz: T) = s"$str - $int - $baz"
  }

  object Rule1 {
    implicit def impInt = 42
    def dble = 1.0

//    Funcy.tostr("hello", 2.0) // не найден implicit для double
  }


  object Rule2 {
    implicit def impInt = 42
    object inner {
      implicit def dble = 1.0
    }

    //err//Funcy.tostr("hello", 2.0) // не найден implicit для double, вне области видимости
  }

  object Rule3 {
    implicit def impInt = 42
    implicit def dble1 = 1.0
    implicit def dble2 = -1.0

    //err//Funcy.tostr("hello", 2.0) // не найден implicit для double (ambigious)
  }

  object Rule4 {
    implicit val impInt: Int = 42
    implicit def toDouble(implicit x: Int): Double = x.toDouble

    Funcy.tostr("hello", 2.0) // найден! implicit для double double -> toDouble -> int
  }

  object Rule5 {
    implicit def impInt = 42
    implicit def dble = 1.0

    println(Funcy.tostr("hello", 2.0)(32, 32.0)) // hello - 32 - 32.0
  }
}