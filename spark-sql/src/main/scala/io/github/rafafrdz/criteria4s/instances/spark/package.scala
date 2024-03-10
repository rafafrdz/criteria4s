package io.github.rafafrdz.criteria4s.instances

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.Sym
import io.github.rafafrdz.criteria4s.instances.builder.{Builder1, Builder2}
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions.expr

package object spark {
  def sym[T <: CriteriaTag](colF: String => Column, valueF: String => Column): Sym[T] =
    Sym.sym(colF.andThen(_.toString()), valueF.andThen(_.toString()))

  def build[T <: CriteriaTag, H[_ <: CriteriaTag]](F: (Column, Column) => Column)(implicit
      BH: Builder2[H]
  ): H[T] =
    BH.build((c1, c2) => F(expr(c1), expr(c2)).toString())

  def build1[T <: CriteriaTag, H[_ <: CriteriaTag]](F: Column => Column)(implicit
      BH: Builder1[H]
  ): H[T] =
    BH.build(c => F(expr(c)).toString())

  def buildLeft[T <: CriteriaTag, H[_ <: CriteriaTag]](F: (Column, String) => Column)(implicit
      BH: Builder2[H]
  ): H[T] =
    BH.build((c1, c2) => F(expr(c1), c2).toString())
}
