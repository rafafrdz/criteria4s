package io.github.rafafrdz.criterial.core

sealed trait Ref[D <: CriterialTag] {
  def ref: Criterial[D]

  override def toString: String = ref.value
}

object Ref {

  trait Value[+V, D <: CriterialTag] extends Ref[D]

  trait Collection[V, D <: CriterialTag] extends Value[Seq[V], D]

  trait Col[D <: CriterialTag] extends Ref[D]

  trait Bool[D <: CriterialTag] extends Value[Boolean, D] with Criterial[D] {
    self =>

    override def value: String = ref.value

    override def toString: String = value
  }

  private[criterial] def nothing[T <: CriterialTag]: Value[Nothing, T] =
    new Value[Nothing, T] {
      override def ref: Criterial[T] = Criterial.pure("")
    }
  private[criterial] def value[V, D <: CriterialTag](v: V): Value[V, D] =
    new Value[V, D] {
      override def ref: Criterial[D] = Criterial.pure(v.toString)
    }

  private[criterial] def col[D <: CriterialTag](v: String): Col[D] = new Col[D] {
    override def ref: Criterial[D] = Criterial.pure(v)
  }

  private[criterial] def bool[D <: CriterialTag](v: Boolean): Bool[D] =
    new Bool[D] {
      override def ref: Criterial[D] = Criterial.pure(v.toString)
    }

}
