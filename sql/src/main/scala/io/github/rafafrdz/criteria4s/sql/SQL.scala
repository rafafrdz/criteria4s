package io.github.rafafrdz.criteria4s.sql

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.ConjOp._
import io.github.rafafrdz.criteria4s.core.PredOp._
import io.github.rafafrdz.criteria4s.instances.{build, build1}

trait SQL extends CriteriaTag

object SQL {

  trait SQLExpr[T <: SQL] {

    private def opeExpr(symbol: String)(a: String, b: String): String = s"($a $symbol $b)"

    private def opeExpr1(symbol: String)(a: String): String = s"($a $symbol)"

    implicit val ltPred: LT[T] = build[T, LT](opeExpr("<"))

    implicit val gtPred: GT[T] = build[T, GT](opeExpr(">"))

    implicit val orOp: OR[T] = build[T, OR](opeExpr("OR"))

    implicit val andOp: AND[T] = build[T, AND](opeExpr("AND"))

    implicit val eqPred: EQ[T] = build[T, EQ](opeExpr("="))

    implicit val neqPred: NEQ[T] = build[T, NEQ](opeExpr("!="))

    implicit val leqPred: LEQ[T] = build[T, LEQ](opeExpr("<="))

    implicit val geqPred: GEQ[T] = build[T, GEQ](opeExpr(">="))

    implicit val likePred: LIKE[T] = build[T, LIKE](opeExpr("LIKE"))

    implicit val inPred: IN[T] = build[T, IN](opeExpr("IN"))

    implicit val notinPred: NOTIN[T] = build[T, NOTIN](opeExpr("NOT IN"))

    implicit val isnullPred: ISNULL[T] = build1[T, ISNULL](opeExpr1("IS NULL"))

    implicit val isnotnullPred: ISNOTNULL[T] =
      build1[T, ISNOTNULL](opeExpr1("IS NOT NULL"))

    implicit val betweenPred: BETWEEN[T] = build[T, BETWEEN](opeExpr("BETWEEN"))

    implicit val notbetweenPred: NOTBETWEEN[T] =
      build[T, NOTBETWEEN](opeExpr("NOT BETWEEN"))
  }

}
