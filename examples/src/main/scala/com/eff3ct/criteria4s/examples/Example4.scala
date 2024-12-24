package com.eff3ct.criteria4s.examples

import com.eff3ct.criteria4s.core._
import com.eff3ct.criteria4s.dialect.mongodb.MongoDB
import com.eff3ct.criteria4s.examples.datastores.{MySQL, Postgres, WeirdDatastore}
import com.eff3ct.criteria4s.extensions._
import com.eff3ct.criteria4s.functions._

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
