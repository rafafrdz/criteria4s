package io.github.rafafrdz.criterial.examples

import io.github.rafafrdz.criterial.core._
import io.github.rafafrdz.criterial.examples.datastores.Postgres
import io.github.rafafrdz.criterial.functions._

object Example extends App {

  val d: Criterial[Postgres] = or(and(lt(col("a"), lit(3)), lt(col("b"), lit(4))), bool(true))

  val example: Criterial[Postgres] =
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
