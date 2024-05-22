package io.github.rafafrdz.criteria4s.instances.builder

import io.github.rafafrdz.criteria4s.core.CriteriaTag

trait BuilderBinary[H[_ <: CriteriaTag]] {
  def build[T <: CriteriaTag](F: (String, String) => String): H[T]
}
