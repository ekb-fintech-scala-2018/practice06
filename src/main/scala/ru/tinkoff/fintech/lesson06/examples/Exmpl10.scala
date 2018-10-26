package ru.tinkoff.fintech.lesson06.examples

object Exmpl10 {

  object Order1 {
    sealed trait BaseSought
    class Target extends BaseSought
    class Alternative extends BaseSought
    trait Searchable[T <: BaseSought]

    implicit def search[T <: BaseSought](implicit sought: T, canSearch: Searchable[T]): T = sought

    implicit val target = new Target()   // ambiguity
    implicit val alt = new Alternative() // ambiguity

    implicit val canSearchTarget = new Searchable[Target] {}

//    search // : Ambigious implicits
  }

  object Order2 {
    sealed trait BaseSought
    class Target extends BaseSought
    class Alternative extends BaseSought
    trait Searchable[T <: BaseSought]

    implicit def search[T <: BaseSought](implicit canSearch: Searchable[T], sought: T): T = sought

    implicit val target = new Target()   // ambiguity
    implicit val alt = new Alternative() // ambiguity

    implicit val canSearchTarget = new Searchable[Target] {}

    search // : Target
  }
}
