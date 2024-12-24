package com.eff3ct.criteria4s

import com.eff3ct.criteria4s.core.CriteriaTag
import com.eff3ct.criteria4s.instances.builder.{BuilderBinary, BuilderUnary}

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
