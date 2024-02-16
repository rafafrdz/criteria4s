package io.github.rafafrdz.criterial.instances.builder

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag

trait Builder1[H[_ <: CriterialTag]] {
  def build[T <: CriterialTag](F: String => String): H[T]
}
