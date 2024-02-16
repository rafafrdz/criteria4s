package io.github.rafafrdz.examples

import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.extensions._
import io.github.rafafrdz.criterial.functions._
import io.github.rafafrdz.examples.datastores.Postgres
import io.github.rafafrdz.examples.datastores.Postgres._

object Example2 extends App {

  val d: Criterial[Postgres] = or(and(lt(col("a"), lit(3)), lt(col("b"), lit(4))), bool(true))
  val d2: Criterial[Postgres] = col[Postgres]("a") leq lit(3)
  val d3: Criterial[Postgres] = col[Postgres]("b") leq lit(4)
  val d4: Criterial[Postgres] = and(d2, d3)
  val d5: Criterial[Postgres] = col[Postgres]("c") === lit("c")
  val d6: Criterial[Postgres] = or(d4, d5)

  val expr: Criterial[Postgres] =
    (col[Postgres]("a") leq lit(3)) and
      (col[Postgres]("b") leq lit(4)) or
      (col[Postgres]("c") === lit("c"))

  val inlineExpr: Criterial[Postgres] =
    (col[Postgres]("a") leq lit(3)) and (col[Postgres]("b") leq lit(4)) or (col[Postgres]("c") === lit("c"))

  println(d6)
  println(expr)
  println(inlineExpr)
}
