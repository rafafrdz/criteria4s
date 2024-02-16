package io.github.rafafrdz.criterial.extensions

import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialCondOp._
import io.github.rafafrdz.criterial.{functions => F}

trait conjunctions {

  implicit class CriterialOpsImplicit[T <: CriterialTag](c: Criterial[T]) {
    def and(other: Criterial[T])(implicit H: AND[T]): Criterial[T] = F.and(c, other)
    def or(other: Criterial[T])(implicit H: OR[T]): Criterial[T]   = F.or(c, other)
  }

}

object conjunctions extends conjunctions
