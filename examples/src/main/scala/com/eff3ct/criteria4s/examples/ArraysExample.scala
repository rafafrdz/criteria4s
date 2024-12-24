package com.eff3ct.criteria4s.examples

import com.eff3ct.criteria4s.core._
import com.eff3ct.criteria4s.dialect.mongodb.MongoDB
import com.eff3ct.criteria4s.examples.datastores.{Postgres, WeirdDatastore}
import com.eff3ct.criteria4s.functions._

object ArraysExample extends App {
  val aIsNull: Criteria[Postgres] = isNull(col("a"))
  def aIsNullAlgebra[
      T <: CriteriaTag: ISNULL: Show[Column, *]
  ]: Criteria[T] = isNull(col("a"))

  val numberInArray: Criteria[Postgres] = in(col("a"), array(1, 2, 3))
  def numberInArrayAlgebra[T <: CriteriaTag: IN: Show[Column, *]: Show[Seq[Int], *]]: Criteria[T] =
    in(col("a"), array(1, 2, 3))

  val combined: Criteria[Postgres]     = or(aIsNull, numberInArray)
  val moreCombined: Criteria[Postgres] = or(combined, ===(col("b"), lit(10)))

  println(aIsNull)
  println(aIsNullAlgebra[Postgres])
  println(aIsNullAlgebra[WeirdDatastore])
  println(aIsNullAlgebra[MongoDB])

  println(numberInArray)
  println(numberInArrayAlgebra[Postgres])
  println(numberInArrayAlgebra[WeirdDatastore])
  println(numberInArrayAlgebra[MongoDB])

  println(combined)
  println(moreCombined)
}
