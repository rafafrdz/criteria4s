package io.github.rafafrdz.criteria4s

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.instances.builder.{Builder1, Builder2}

package object instances {
  def build[T <: CriteriaTag, H[_ <: CriteriaTag]](F: (String, String) => String)(implicit
      BH: Builder2[H]
  ): H[T] =
    BH.build(F)

  def build1[T <: CriteriaTag, H[_ <: CriteriaTag]](F: String => String)(implicit
      BH: Builder1[H]
  ): H[T] =
    BH.build(F)
}
