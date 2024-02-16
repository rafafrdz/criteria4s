package io.github.rafafrdz.criterial.extensions

import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialOps._
import io.github.rafafrdz.criterial.{functions => F}

trait conjunctions {

  implicit class CriterialOpsImplicit[T <: CriterialTag](c: Criterial[T]) {
    def and[M <: T: AND](other: Criterial[M]): Criterial[M] = F.and(c, other)
    def or[M <: T: OR](other: Criterial[M]): Criterial[M] = F.or(c, other)
  }

}

object conjunctions extends conjunctions
