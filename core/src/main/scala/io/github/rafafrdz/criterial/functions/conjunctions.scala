package io.github.rafafrdz.criterial.functions

import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialCondOp._

private[functions] trait conjunctions {

  def and[T <: CriterialTag: AND](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] =
    cond[T, AND[T]](cr1, cr2)

  def or[T <: CriterialTag: OR](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] =
    cond[T, OR[T]](cr1, cr2)

}
object conjunctions extends conjunctions
