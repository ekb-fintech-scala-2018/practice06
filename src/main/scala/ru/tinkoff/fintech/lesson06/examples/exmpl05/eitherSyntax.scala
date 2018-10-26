package ru.tinkoff.fintech.lesson06.examples.exmpl05

object eitherSyntax {
  implicit class EitherOps[T](val x: T) extends AnyVal {
    def asLeft[O]: Either[T,O] = Left(x)
    def asRight[O]: Either[O,T] = Right(x)
  }
}