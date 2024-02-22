package io.github.rafafrdz.criteria4s.functions

import io.github.rafafrdz.criteria4s.core.Criteria
import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.ConjOp._

private[functions] trait conjunctions {

  def and[T <: CriteriaTag: AND](cr1: Criteria[T], cr2: Criteria[T]): Criteria[T] =
    cond[T, AND[T]](cr1, cr2)

  def or[T <: CriteriaTag: OR](cr1: Criteria[T], cr2: Criteria[T]): Criteria[T] =
    cond[T, OR[T]](cr1, cr2)

}
object conjunctions extends conjunctions
