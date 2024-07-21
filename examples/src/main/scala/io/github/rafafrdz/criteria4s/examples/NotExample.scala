package io.github.rafafrdz.criteria4s.examples

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.dialect.mongodb.MongoDB
import io.github.rafafrdz.criteria4s.examples.datastores._
import io.github.rafafrdz.criteria4s.extensions._
import io.github.rafafrdz.criteria4s.functions._

object NotExample extends App {

  val simpleNot: Criteria[Postgres] = not(col[Postgres]("a").between(range(1, 10)))

  val symbolNot: Criteria[Postgres] = !!(col[Postgres]("a").between(range(1, 10)))

  def taglessFinalNotExample[
      T <: CriteriaTag: GT: NOT: Show[Column, *]: Show[(Int, Int), *]
  ]: Criteria[T] =
    not(col[T]("column") gt lit(100))

  def taglessFinalNotSymbolExample[
      T <: CriteriaTag: BETWEEN: NOT: Show[Column, *]: Show[(Int, Int), *]
  ]: Criteria[T] =
    !!(col[T]("column") between range(100, 150))

  def weirdExampleWithNot[
      T <: CriteriaTag: NOT: GT: LEQ: AND: Show[Column, *]: Show[(Int, Int), *]
  ]: Criteria[T] =
    not(col[T]("column") gt lit(2)) && (col[T]("column") leq lit(10))

  println(simpleNot)
  println(symbolNot)
  println(taglessFinalNotExample[Postgres])
  println(taglessFinalNotExample[WeirdDatastore])
  println(taglessFinalNotExample[MongoDB])

  println(taglessFinalNotSymbolExample[Postgres])
  println(taglessFinalNotSymbolExample[WeirdDatastore])
  println(taglessFinalNotSymbolExample[MongoDB])

  println(weirdExampleWithNot[Postgres])
  println(weirdExampleWithNot[WeirdDatastore])
  println(weirdExampleWithNot[MongoDB])
}
