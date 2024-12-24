package com.eff3ct.criteria4s

import com.eff3ct.criteria4s.core._

package object functions extends predicates with conjunctions {

  def pred[T <: CriteriaTag, H <: PredicateBinary[T], L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      H: H,
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    H.eval(cr1, cr2)

  def pred[T <: CriteriaTag, H <: PredicateUnary[T], V](ref: Ref[T, V])(implicit
      H: H,
      show: Show[V, T]
  ): Criteria[T] =
    H.eval(ref)

  def cond[T <: CriteriaTag, H <: ConjuctionBinary[T]](cr1: Criteria[T], cr2: Criteria[T])(implicit
      H: H
  ): Criteria[T] =
    H.eval(cr1, cr2)

  def cond[T <: CriteriaTag, H <: ConjuctionUnary[T]](cr: Criteria[T])(implicit
      H: H
  ): Criteria[T] =
    H.eval(cr)

}
