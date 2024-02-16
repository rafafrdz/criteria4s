package io.github.rafafrdz.criterial.core

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag

trait CriterialCollection[T <: CriterialTag] {
  def eval(crx: Criterial[T]*): Criterial[T]
}
