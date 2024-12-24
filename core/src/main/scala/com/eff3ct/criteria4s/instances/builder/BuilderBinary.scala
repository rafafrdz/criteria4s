package com.eff3ct.criteria4s.instances.builder

import com.eff3ct.criteria4s.core.CriteriaTag

trait BuilderBinary[H[_ <: CriteriaTag]] {
  def build[T <: CriteriaTag](F: (String, String) => String): H[T]
}
