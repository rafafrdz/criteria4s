package io.github.rafafrdz.criterial

import io.github.rafafrdz.criterial.builder.Builder
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.{Criterial, CriterialCollection, CriterialEval}

package object functions extends predicates with conjunctions {

  def eval[T <: CriterialTag, H <: CriterialEval[T]](cr1: Criterial[T], cr2: Criterial[T])(implicit
      H: H
  ): Criterial[T] =
    H.eval(cr1, cr2)

  def eval[T <: CriterialTag, H <: CriterialCollection[T]](crx: Criterial[T]*)(implicit
      H: H
  ): Criterial[T] =
    H.eval(crx: _*)

  def build[T <: CriterialTag, H[_ <: CriterialTag]](F: (String, String) => String)(implicit BH: Builder[H]): H[T] =
    BH.build(F)

}
