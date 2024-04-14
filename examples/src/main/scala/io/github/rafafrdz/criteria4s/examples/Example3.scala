package io.github.rafafrdz.criteria4s.examples

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.examples.datastores.{Postgres, WeirdDatastore}
import io.github.rafafrdz.criteria4s.functions._

object Example3 extends App {

  def example1[T <: CriteriaTag: LT: AND: OR : ({type A[D <: CriteriaTag] = Show[Column, D]})#A]: Criteria[T] =
    or(and(lt(col("a"), lit(3)), lt(col("b"), lit(4))), bool(true))

  def example2[T <: CriteriaTag: LT: AND: OR: GEQ: ISNULL: NEQ: ({type A[D <: CriteriaTag] = Show[Column, D]})#A]: Criteria[T] =
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
