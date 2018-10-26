package ru.tinkoff.fintech.lesson06.examples
import scala.language.implicitConversions

object Exmpl09 extends App {
  trait CanBeOther[T] {
    type U
    def value: U
  }
  object CanBeOther {
    type Aux[T0, U0] = CanBeOther[T0] {type U = U0}

    implicit def ev = new CanBeOther[String] {
      type U = Int
      override def value: Int = 42
    }
  }

  implicit val str2Int: String => Int = Integer.parseInt
  implicit def listed[T <% Int]: T => List[Int] = {x => List(x, x)}

  def sum[T,U](x: T)(
    implicit
    ev: CanBeOther.Aux[T, U],
    xs: T => List[U],
    ops: Integral[U]): U =
    xs(x).foldLeft(ops.zero) {(acc, x) => ops.plus(acc, x)}

  sum("42")
}