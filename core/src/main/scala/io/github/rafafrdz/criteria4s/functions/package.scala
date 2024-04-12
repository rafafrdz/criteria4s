package io.github.rafafrdz.criteria4s

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core._

package object functions extends predicates with conjunctions {

  def predBinary[T <: CriteriaTag, H <: PredicateBinary[T]](cr1: Ref[T], cr2: Ref[T])(
      implicit H: H
  ): Criteria[T] =
    H.eval(cr1, cr2)

  def predUnary[T <: CriteriaTag, H <: PredicateUnary[T]](ref: Ref[T])(
      implicit H: H
  ): Criteria[T] =
    H.eval(ref)

  def cond[T <: CriteriaTag, H <: ConjOp[T]](cr1: Criteria[T], cr2: Criteria[T])(
      implicit H: H
  ): Criteria[T] =
    H.eval(cr1, cr2)

}
