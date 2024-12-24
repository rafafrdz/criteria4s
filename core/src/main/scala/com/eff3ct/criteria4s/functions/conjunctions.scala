package com.eff3ct.criteria4s.functions

import com.eff3ct.criteria4s.core._

private[functions] trait conjunctions {

  def and[T <: CriteriaTag: AND](cr1: Criteria[T], cr2: Criteria[T]): Criteria[T] =
    cond[T, AND[T]](cr1, cr2)

  def &&[T <: CriteriaTag: AND](cr1: Criteria[T], cr2: Criteria[T]): Criteria[T] =
    and(cr1, cr2)

  def or[T <: CriteriaTag: OR](cr1: Criteria[T], cr2: Criteria[T]): Criteria[T] =
    cond[T, OR[T]](cr1, cr2)

  def ||[T <: CriteriaTag: OR](cr1: Criteria[T], cr2: Criteria[T]): Criteria[T] =
    or(cr1, cr2)

  def not[T <: CriteriaTag: NOT](cr: Criteria[T]): Criteria[T] =
    cond[T, NOT[T]](cr)

  def !![T <: CriteriaTag: NOT](cr: Criteria[T]): Criteria[T] = not(cr)

}
object conjunctions extends conjunctions
