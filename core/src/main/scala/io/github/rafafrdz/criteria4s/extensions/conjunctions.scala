package io.github.rafafrdz.criteria4s.extensions

import io.github.rafafrdz.criteria4s.core.Criteria
import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.ConjOp._
import io.github.rafafrdz.criteria4s.{functions => F}

trait conjunctions {

  implicit class CriteriaOpsImplicit[T <: CriteriaTag](c: Criteria[T]) {
    def and(other: Criteria[T])(implicit H: AND[T]): Criteria[T] = F.and(c, other)
    def or(other: Criteria[T])(implicit H: OR[T]): Criteria[T]   = F.or(c, other)
  }

}

object conjunctions extends conjunctions
