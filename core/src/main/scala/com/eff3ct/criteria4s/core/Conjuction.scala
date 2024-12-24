package com.eff3ct.criteria4s.core

import com.eff3ct.criteria4s.core
import com.eff3ct.criteria4s.core.Criteria._
import com.eff3ct.criteria4s.instances.builder._

trait ConjuctionBinary[T <: CriteriaTag] {
  def eval(cr1: Criteria[T], cr2: Criteria[T]): Criteria[T]
}

trait ConjuctionUnary[T <: CriteriaTag] {
  def eval(cr: Criteria[T]): Criteria[T]
}

object ConjuctionBinary {

  def eval[T <: CriteriaTag](cr1: Criteria[T], cr2: Criteria[T])(implicit
      ev: ConjuctionBinary[T]
  ): Criteria[T] =
    ev.eval(cr1, cr2)

  trait OR[T <: CriteriaTag] extends ConjuctionBinary[T]

  trait AND[T <: CriteriaTag] extends ConjuctionBinary[T]

  implicit val orBuilder: BuilderBinary[OR] = new BuilderBinary[OR] {
    override def build[T <: CriteriaTag](F: (String, String) => String): OR[T] =
      (cr1: Criteria[T], cr2: Criteria[T]) => pure(F(cr1.value, cr2.value))
  }

  implicit val andBuilder: BuilderBinary[AND] = new BuilderBinary[AND] {
    override def build[T <: CriteriaTag](F: (String, String) => String): AND[T] =
      (cr1: Criteria[T], cr2: Criteria[T]) => pure(F(cr1.value, cr2.value))
  }

}

object ConjuctionUnary {

  trait NOT[T <: CriteriaTag] extends ConjuctionUnary[T]

  implicit val notBuilder: BuilderUnary[NOT] = new BuilderUnary[NOT] {
    override def build[T <: core.CriteriaTag](F: String => String): NOT[T] =
      (cr: Criteria[T]) => pure(F(cr.value))
  }

}
