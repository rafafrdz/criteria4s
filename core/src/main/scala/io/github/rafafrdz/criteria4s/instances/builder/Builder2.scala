package io.github.rafafrdz.criteria4s.instances.builder

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag

trait Builder2[H[_ <: CriteriaTag]] {
  def build[T <: CriteriaTag](F: (String, String) => String): H[T]
}
