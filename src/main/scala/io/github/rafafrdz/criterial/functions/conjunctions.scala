package io.github.rafafrdz.criterial.functions

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialOps._
import io.github.rafafrdz.criterial.core.Criterial

private[functions] trait conjunctions {

  def and[T <: CriterialTag: AND](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, AND[T]](cr1, cr2)

  def or[T <: CriterialTag: OR](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, OR[T]](cr1, cr2)

}
object conjunctions extends conjunctions
