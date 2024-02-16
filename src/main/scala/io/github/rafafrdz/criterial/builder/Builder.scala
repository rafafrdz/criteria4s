package io.github.rafafrdz.criterial.builder

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag

trait Builder[H[_ <: CriterialTag]] {
  def build[T <: CriterialTag](F: (String, String) => String): H[T]
}
