package io.github.rafafrdz.criterial.core

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag

sealed trait CriterialRef[D <: CriterialTag] {
  def ref: Criterial[D]

  override def toString: String = ref.value
}

object CriterialRef {

  trait CriterialValue[+V, D <: CriterialTag] extends CriterialRef[D]

  trait CriterialCollection[V, D <: CriterialTag] extends CriterialValue[Seq[V], D]

  trait CriterialCol[D <: CriterialTag] extends CriterialRef[D]

  trait CriterialBool[D <: CriterialTag] extends CriterialValue[Boolean, D] with Criterial[D] {
    self =>

    override def value: String = ref.value

    override def toString: String = value
  }

  private[criterial] def nothing[T <: CriterialTag]: CriterialValue[Nothing, T] = new CriterialValue[Nothing, T] {
    override def ref: Criterial[T] = Criterial.pure("")
  }
  private[criterial] def value[V, D <: CriterialTag](v: V): CriterialValue[V, D] = new CriterialValue[V, D] {
    override def ref: Criterial[D] = Criterial.pure(v.toString)
  }

  private[criterial] def col[D <: CriterialTag](v: String): CriterialCol[D] = new CriterialCol[D] {
    override def ref: Criterial[D] = Criterial.pure(v)
  }

  private[criterial] def bool[D <: CriterialTag](v: Boolean): CriterialBool[D] = new CriterialBool[D] {
    override def ref: Criterial[D] = Criterial.pure(v.toString)
  }

}
