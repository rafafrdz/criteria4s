package io.github.rafafrdz.criteria4s.core

import io.github.rafafrdz.criteria4s.core.Criteria._
import io.github.rafafrdz.criteria4s.instances.builder.Builder2

trait ConjOp[T <: CriteriaTag] {
  def eval(cr1: Criteria[T], cr2: Criteria[T]): Criteria[T]
}

object ConjOp {
  def eval[T <: CriteriaTag](cr1: Criteria[T], cr2: Criteria[T])(implicit
      ev: ConjOp[T]
  ): Criteria[T] =
    ev.eval(cr1, cr2)

  trait OR[T <: CriteriaTag] extends ConjOp[T]

  trait AND[T <: CriteriaTag] extends ConjOp[T]

  implicit val orBuilder: Builder2[OR] = new Builder2[OR] {
    override def build[T <: CriteriaTag](F: (String, String) => String): OR[T] =
      (cr1: Criteria[T], cr2: Criteria[T]) => pure(F(cr1.value, cr2.value))
  }

  implicit val andBuilder: Builder2[AND] = new Builder2[AND] {
    override def build[T <: CriteriaTag](F: (String, String) => String): AND[T] =
      (cr1: Criteria[T], cr2: Criteria[T]) => pure(F(cr1.value, cr2.value))
  }

}
