package io.github.rafafrdz.criteria4s

import io.github.rafafrdz.criteria4s.core.CriteriaTag
import io.github.rafafrdz.criteria4s.instances.builder.{BuilderBinary, BuilderUnary}

package object instances {
  def build[T <: CriteriaTag, H[_ <: CriteriaTag]](F: (String, String) => String)(implicit
      BH: BuilderBinary[H]
  ): H[T] =
    BH.build(F)

  def build[T <: CriteriaTag, H[_ <: CriteriaTag]](F: String => String)(implicit
      BH: BuilderUnary[H]
  ): H[T] =
    BH.build(F)
}
