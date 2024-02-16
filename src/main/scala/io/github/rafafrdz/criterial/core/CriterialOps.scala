package io.github.rafafrdz.criterial.core

import io.github.rafafrdz.criterial.builder.Builder
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.functions._

trait CriterialOps[T <: CriterialTag] extends CriterialEval[T]

object CriterialOps {
  trait OR[T <: CriterialTag] extends CriterialEval[T]

  trait AND[T <: CriterialTag] extends CriterialEval[T]

  implicit val orBuilder: Builder[OR] = new Builder[OR] {
    override def build[T <: CriterialTag](F: (String, String) => String): OR[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val andBuilder: Builder[AND] = new Builder[AND] {
    override def build[T <: CriterialTag](F: (String, String) => String): AND[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }
}
