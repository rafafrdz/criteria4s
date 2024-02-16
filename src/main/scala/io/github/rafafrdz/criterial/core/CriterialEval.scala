package io.github.rafafrdz.criterial.core

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag

trait CriterialEval[T <: CriterialTag] {
  def eval(cr1: Criterial[T], cr2: Criterial[T]): Criterial[T]
}
