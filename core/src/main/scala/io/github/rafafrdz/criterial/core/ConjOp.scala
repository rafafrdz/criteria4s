package io.github.rafafrdz.criterial.core

import io.github.rafafrdz.criterial.core.Criterial._
import io.github.rafafrdz.criterial.instances.builder.Builder2

trait ConjOp[T <: CriterialTag] {
  def eval(cr1: Criterial[T], cr2: Criterial[T]): Criterial[T]
}

object ConjOp {
  def eval[T <: CriterialTag](cr1: Criterial[T], cr2: Criterial[T])(implicit
      ev: ConjOp[T]
  ): Criterial[T] =
    ev.eval(cr1, cr2)

  trait OR[T <: CriterialTag] extends ConjOp[T]

  trait AND[T <: CriterialTag] extends ConjOp[T]

  implicit val orBuilder: Builder2[OR] = new Builder2[OR] {
    override def build[T <: CriterialTag](F: (String, String) => String): OR[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => pure(F(cr1.value, cr2.value))
  }

  implicit val andBuilder: Builder2[AND] = new Builder2[AND] {
    override def build[T <: CriterialTag](F: (String, String) => String): AND[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => pure(F(cr1.value, cr2.value))
  }

}
