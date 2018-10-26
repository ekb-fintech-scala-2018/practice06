package ru.tinkoff.fintech.lesson06.exercises.parambounds

object Bounded {

  //boundedArgsFunc("42", 13, "28") - можно
  //boundedArgsFunc(42, "13", "28", 22) - можно
  //someFunc можно вызвать только с любым сочетанием Int и String

  //hint - используйте implicit conversion

  type BoundedArg = String // должны придумать сами этот тип и обвязку к нему
  def boundedArgsFunc(args: BoundedArg*) = ??? // тело реализовывать не надо,
                                               // хотя попробуйте прикинуть, как работать с аргументами
}
