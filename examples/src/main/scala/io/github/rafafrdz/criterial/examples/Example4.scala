package io.github.rafafrdz.criterial.examples

import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialCondOp.{AND, OR}
import io.github.rafafrdz.criterial.core.CriterialPredOp.{EQ, LEQ}
import io.github.rafafrdz.criterial.examples.datastores.{MySQL, Postgres, WeirdDatastore}
import io.github.rafafrdz.criterial.extensions._
import io.github.rafafrdz.criterial.functions._

object Example4 extends App {

  def expr[T <: CriterialTag: LEQ: EQ: AND: OR]: Criterial[T] =
    (col[T]("a") leq lit(3)) and
      (col[T]("b") leq lit(4)) or
      (col[T]("c") === lit("c"))

  def inlineExpr[T <: CriterialTag: LEQ: EQ: AND: OR]: Criterial[T] =
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
             |""".stripMargin
  }
}
