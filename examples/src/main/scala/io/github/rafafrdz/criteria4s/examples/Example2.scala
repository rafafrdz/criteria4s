package io.github.rafafrdz.criteria4s.examples

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.examples.datastores.Postgres
import io.github.rafafrdz.criteria4s.extensions._
import io.github.rafafrdz.criteria4s.functions._

object Example2 extends App {

  val d: Criteria[Postgres]  = or(and(lt(col("a"), lit(3)), lt(col("b"), lit(4))), bool(true))
  val d2: Criteria[Postgres] = col[Postgres]("a") leq lit(3)
  val d3: Criteria[Postgres] = col[Postgres]("b") leq lit(4)
  val d4: Criteria[Postgres] = and(d2, d3)
  val d5: Criteria[Postgres] = col[Postgres]("c") === lit("c")
  val d6: Criteria[Postgres] = or(d4, d5)

  val expr: Criteria[Postgres] =
    (col[Postgres]("a") leq lit(3)) and
      (col[Postgres]("b") leq lit(4)) or
      (col[Postgres]("c") === lit("c"))

  val inlineExpr: Criteria[Postgres] =
    (col[Postgres]("a") leq lit(3)) and (col[Postgres]("b") leq lit(4)) or (col[Postgres](
      "c"
    ) === lit("c"))

  println(d6)
  println(expr)
  println(inlineExpr)
}
