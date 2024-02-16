package io.github.rafafrdz.criterial.examples

import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialCondOp.{AND, OR}
import io.github.rafafrdz.criterial.core.CriterialPredOp.{GEQ, ISNULL, LT, NEQ}
import io.github.rafafrdz.criterial.examples.datastores.{Postgres, WeirdDatastore}
import io.github.rafafrdz.criterial.functions._

object Example3 extends App {

  def example1[T <: CriterialTag: LT: AND: OR]: Criterial[T] =
    or(and(lt(col("a"), lit(3)), lt(col("b"), lit(4))), bool(true))

  def example2[T <: CriterialTag: LT: AND: OR: GEQ: ISNULL: NEQ]: Criterial[T] =
    or(
      and(
        lt(col("col1"), lit(3)),
        geq(col("col2"), lit(4))
      ),
      and(isNull(col("col3")), =!=(col("col4"), col("col5")))
    )

  println {
    s"""Examples for Postgres instances
       |
       |example1[Postgres]: ${example1[Postgres]}
       |
       |example2[Postgres]: ${example2[Postgres]}
       |
       |Examples for WeirdDatastore instances
       |
       |example1[WeirdDatastore]: ${example1[WeirdDatastore]}
       |
       |example2[WeirdDatastore]: ${example2[WeirdDatastore]}
       |""".stripMargin
  }
}
