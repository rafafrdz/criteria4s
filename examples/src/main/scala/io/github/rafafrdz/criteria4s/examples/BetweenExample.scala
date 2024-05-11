package io.github.rafafrdz.criteria4s.examples

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.examples.datastores.{Postgres, WeirdDatastore}
import io.github.rafafrdz.criteria4s.extensions._
import io.github.rafafrdz.criteria4s.functions._

object BetweenExample extends App {
  val simpleBetween: Criteria[Postgres]    = col[Postgres]("a").between(range(1, 10))
  val simpleNotBetween: Criteria[Postgres] = col[Postgres]("b").notBetween(range("A", "Z"))

  def taglessFinalBetweenExample[
      T <: CriteriaTag: BETWEEN: Show[Column, *]: Show[(Int, Int), *]
  ]: Criteria[T] =
    col[T]("column") between range(100, 150)

  println(simpleBetween)
  println(simpleNotBetween)
  println(taglessFinalBetweenExample[Postgres])
  println(taglessFinalBetweenExample[WeirdDatastore])
}
