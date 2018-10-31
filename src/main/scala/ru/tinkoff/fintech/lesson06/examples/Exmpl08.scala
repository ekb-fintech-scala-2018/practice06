package ru.tinkoff.fintech.lesson06.examples

object Exmpl08 {
  object ViewBouds {
    def getIndexVB[T, CC <% Seq[T]](seq: CC, value: T) =
      seq.indexOf(value) // view bounds syntax

    def getIndex[T, CC](seq: CC, value: T)(implicit conv: CC => Seq[T]) =
      seq.indexOf(value)

    def getIndexDesugared[T, CC](seq: CC, value: T)(implicit conv: CC => Seq[T]) =
      conv(seq).indexOf(value)

    getIndexVB("fooo", 'o')
  }

  object ContextBouds {
    def sumCB[T : Integral](list: List[T]): T = { // context bound syntax
      val integral = implicitly[Integral[T]]
      import integral._   // импорт implicit преобразований
      list.foldLeft(integral.zero)(_ + _)
    }

    def sum[T](list: List[T])(implicit integral: Integral[T]): T = {
      import integral._   // импорт implicit преобразований
      list.foldLeft(zero)( _ + _)
    }

    def sumDesugared[T](list: List[T])(implicit integral: Integral[T]): T = {
      list.foldLeft(integral.zero){(acc, x) =>
        integral.mkNumericOps(acc).+(x)
      }
    }
  }
}