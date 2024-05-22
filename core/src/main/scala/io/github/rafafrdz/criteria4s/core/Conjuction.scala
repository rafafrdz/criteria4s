package io.github.rafafrdz.criteria4s.core

import io.github.rafafrdz.criteria4s.core.Criteria._
import io.github.rafafrdz.criteria4s.instances.builder.BuilderBinary

trait Conjuction[T <: CriteriaTag] {
  def eval(cr1: Criteria[T], cr2: Criteria[T]): Criteria[T]
}

object Conjuction {

  def eval[T <: CriteriaTag](cr1: Criteria[T], cr2: Criteria[T])(implicit
      ev: Conjuction[T]
  ): Criteria[T] =
    ev.eval(cr1, cr2)

  trait OR[T <: CriteriaTag] extends Conjuction[T]

  trait AND[T <: CriteriaTag] extends Conjuction[T]

  implicit val orBuilder: BuilderBinary[OR] = new BuilderBinary[OR] {
    override def build[T <: CriteriaTag](F: (String, String) => String): OR[T] =
      (cr1: Criteria[T], cr2: Criteria[T]) => pure(F(cr1.value, cr2.value))
  }

  implicit val andBuilder: BuilderBinary[AND] = new BuilderBinary[AND] {
    override def build[T <: CriteriaTag](F: (String, String) => String): AND[T] =
      (cr1: Criteria[T], cr2: Criteria[T]) => pure(F(cr1.value, cr2.value))
  }

}
