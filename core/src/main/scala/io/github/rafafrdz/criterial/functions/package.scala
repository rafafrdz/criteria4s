package io.github.rafafrdz.criterial

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core._

package object functions extends predicates with conjunctions {

  def pred[T <: CriterialTag, H <: PredOp[T]](cr1: Ref[T], cr2: Ref[T])(
      implicit H: H
  ): Criterial[T] =
    H.eval(cr1, cr2)

  def cond[T <: CriterialTag, H <: ConjOp[T]](cr1: Criterial[T], cr2: Criterial[T])(
      implicit H: H
  ): Criterial[T] =
    H.eval(cr1, cr2)

}
