package io.github.rafafrdz.criterial

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.instances.builder.{Builder1, Builder2}

package object instances {
  def build[T <: CriterialTag, H[_ <: CriterialTag]](F: (String, String) => String)(implicit
      BH: Builder2[H]
  ): H[T] =
    BH.build(F)

  def build1[T <: CriterialTag, H[_ <: CriterialTag]](F: String => String)(implicit
      BH: Builder1[H]
  ): H[T] =
    BH.build(F)
}
