package ru.tinkoff.fintech.lesson06.examples

object Exmpl13 {
  def add(x: Int)(implicit y: Int) = x + y

  implicit val n: Int = 5
  add(5) // текущая область видимости

  import scala.collection.JavaConversions.mapAsScalaMap
  def env = System.getenv() // java map
  val term = env("TERM") // scala map импорт "mapAsScalaMap"

  def sum[T : Integral](list: List[T]): T = {
    val integral = implicitly[Integral[T]]
    import integral._   // wildcard import of Integral implicits для операции (_ + _)
    list.foldLeft(integral.zero)(_ + _)
  }
}