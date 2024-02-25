package io.github.rafafrdz.criteria4s.core

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.Ref.{Bool, Col, Value}

trait Sym[T <: CriteriaTag] {
  def value[V](v: Value[V, T]): Value[V, T] = v
  def bool(v: Bool[T]): Bool[T]             = v
  def col(c: Col[T]): Col[T]                = c
}
object Sym {

  private[criteria4s] def sym[T <: CriteriaTag](
      C: String => String,
      V: String => String
  ): Sym[T] = new Sym[T] {

    override def value[V](v: Value[V, T]): Value[V, T] =
      new Value[V, T] {
        override def ref: Criteria[T] = Criteria.pure(V(v.ref.value))
      }

    override def col(c: Col[T]): Col[T] = Ref.col(C(c.ref.value))
  }
}
