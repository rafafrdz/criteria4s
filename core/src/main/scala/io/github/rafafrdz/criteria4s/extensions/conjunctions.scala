package io.github.rafafrdz.criteria4s.extensions

import io.github.rafafrdz.criteria4s.{functions => F}
import io.github.rafafrdz.criteria4s.core._

trait conjunctions {

  implicit class CriteriaOpsImplicit[T <: CriteriaTag](c: Criteria[T]) {
    def and(other: Criteria[T])(implicit H: AND[T]): Criteria[T] = F.and(c, other)
    def &&(other: Criteria[T])(implicit H: AND[T]): Criteria[T]  = F.and(c, other)
    def or(other: Criteria[T])(implicit H: OR[T]): Criteria[T]   = F.or(c, other)
    def ||(other: Criteria[T])(implicit H: OR[T]): Criteria[T]   = F.or(c, other)
  }

}

object conjunctions extends conjunctions
