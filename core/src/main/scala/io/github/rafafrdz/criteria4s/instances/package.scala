package io.github.rafafrdz.criteria4s

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.Sym
import io.github.rafafrdz.criteria4s.instances.builder.{Builder1, Builder2}

package object instances {
  def sym0[T <: CriteriaTag]: Sym[T] = sym1(v => v)

  def sym1[T <: CriteriaTag](symF: String => String): Sym[T] = sym(symF, symF)
  def sym[T <: CriteriaTag](colF: String => String, valueF: String => String): Sym[T] =
    Sym.sym(colF, valueF)

  def build[T <: CriteriaTag, H[_ <: CriteriaTag]](F: (String, String) => String)(implicit
      BH: Builder2[H]
  ): H[T] =
    BH.build(F)

  def build1[T <: CriteriaTag, H[_ <: CriteriaTag]](F: String => String)(implicit
      BH: Builder1[H]
  ): H[T] =
    BH.build(F)
}
