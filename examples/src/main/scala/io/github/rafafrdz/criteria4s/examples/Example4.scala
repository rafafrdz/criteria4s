package io.github.rafafrdz.criteria4s.examples

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.examples.datastores.{MySQL, Postgres, WeirdDatastore}
import io.github.rafafrdz.criteria4s.extensions._
import io.github.rafafrdz.criteria4s.functions._
import io.github.rafafrdz.criteria4s.mongodb.MongoDB

object Example4 extends App {

  def expr[T <: CriteriaTag: LEQ: EQ: AND: OR: Show[Column, *]]: Criteria[T] =
    (col[T]("a") leq lit(3)) and
      (col[T]("b") leq lit(4)) or
      (col[T]("c") === lit("c"))

  def inlineExpr[T <: CriteriaTag: LEQ: EQ: AND: OR: Show[Column, *]]: Criteria[T] =
    (col[T]("a") leq lit(3)) and (col[T]("b") leq lit(4)) or (col[T]("c") === lit("c"))

  println {
    s"""Examples for Postgres instances
             |
             |expr[Postgres]: ${expr[Postgres]}
             |
             |inlineExpr[Postgres]: ${inlineExpr[Postgres]}
             |
             |Examples for MySQL instances
             |
             |expr[MySQL]: ${expr[MySQL]}
             |
             |inlineExpr[MySQL]: ${inlineExpr[MySQL]}
             |
             |Examples for WeirdDatastore instances
             |
             |expr[WeirdDatastore]: ${expr[WeirdDatastore]}
             |
             |inlineExpr[WeirdDatastore]: ${inlineExpr[WeirdDatastore]}
             |
             |Examples for MongoDB instances
             |
             |expr[MongoDB]: ${expr[MongoDB]}
             |
             |inlineExpr[MongoDB]: ${inlineExpr[MongoDB]}
             |""".stripMargin
  }
}
