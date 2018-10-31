package ru.tinkoff.fintech.lesson06.exercises.show.part2.answer

trait Show[T] {
  def show(x: T): String
}

object ShowSyntax {
  implicit class ShowOps[T: Show](val self: T) {
    def show: String = implicitly[Show[T]].show(self)
  }
}

trait ShowInstances {
  import ShowSyntax._

  // instances для примитивных типов
  implicit val stringShow = new Show[String] {
    override def show(x: String): String = x
  }

  implicit val intShow = new Show[Int] {
    override def show(x: Int): String = x.toString
  }

  implicit val doubleShow = new Show[Double] {
    override def show(x: Double): String = x.toString
  }


  // derive some
  implicit def listShow[T: Show] = new Show[List[T]] {
    override def show(xs: List[T]): String = {
      xs.map(x => x.show).mkString(",")
    }
  }

  implicit def mapShow[K: Show, V: Show] = new Show[Map[K, V]] {
    override def show(xs: Map[K, V]): String = {
      xs.map(kv => s"${kv._1.show} -> ${kv._2.show}").mkString(",")
    }
  }
}

object Show extends ShowInstances
