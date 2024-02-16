package io.github.rafafrdz

import io.github.rafafrdz.Postgres._
import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.extensions._
import io.github.rafafrdz.criterial.functions._

object Example2 extends App {

//  val d: Criterial[Postgres] = or(and(lt(col("a"), lit(3)), lt(col("b"), lit(4))), lit("c"))
  val d2: Criterial[Postgres] = (col("a") leq lit(3))
  val d3: Criterial[Postgres] = (col("b") leq lit(4))
  val d4: Criterial[Postgres] = and(d2, d3)
  val d5: Criterial[Postgres] = (col("c") === lit("c"))
  val d: Criterial[Postgres] = or(d4, d5)

  println(d)
}
