package com.eff3ct.criteria4s.instances.builder

import com.eff3ct.criteria4s.core.CriteriaTag

trait BuilderUnary[H[_ <: CriteriaTag]] {
  def build[T <: CriteriaTag](F: String => String): H[T]
}
