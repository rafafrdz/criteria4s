package io.github.rafafrdz.criteria4s.examples

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.functions._
import io.github.rafafrdz.criteria4s.examples.datastores.Postgres
import io.github.rafafrdz.criteria4s.functions._

object Example extends App {

  val d: Criteria[Postgres] = or(and(lt(col("a"), lit(3)), lt(col("b"), lit(4))), bool(true))

  val example: Criteria[Postgres] =
    or(
      and(
        lt(col("col1"), lit(3)),
        geq(col("col2"), lit(4))
      ),
      and(isNull(col("col3")), =!=(col("col4"), col("col5")))
    )

  println(d)
  println(example)
}
