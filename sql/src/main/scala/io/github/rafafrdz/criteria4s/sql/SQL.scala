package io.github.rafafrdz.criteria4s.sql

import io.github.rafafrdz.criteria4s.core.ConjOp._
import io.github.rafafrdz.criteria4s.core.PredicateBinary._
import io.github.rafafrdz.criteria4s.core.PredicateUnary._
import io.github.rafafrdz.criteria4s.core.{Column, CriteriaTag, Show}
import io.github.rafafrdz.criteria4s.instances._

trait SQL extends CriteriaTag

object SQL {

  private def unaryPredExpr(symbol: String)(a: String): String             = s"$a $symbol"
  private def binaryPredExpr(symbol: String)(a: String, b: String): String = s"$a $symbol $b"
  private def opExpr(symbol: String)(a: String, b: String): String         = s"($a) $symbol ($b)"

  implicit val showColumn: Show[Column, SQL] = Show.create(col => s"'${col.colName}'")

  trait SQLExpr[T <: SQL] {

    implicit val ltPred: LT[T] = build[T, LT](binaryPredExpr("<"))

    implicit val gtPred: GT[T] = build[T, GT](binaryPredExpr(">"))

    implicit val orOp: OR[T] = build[T, OR](opExpr("OR"))

    implicit val andOp: AND[T] = build[T, AND](opExpr("AND"))

    implicit val eqPred: EQ[T] = build[T, EQ](binaryPredExpr("="))

    implicit val neqPred: NEQ[T] = build[T, NEQ](binaryPredExpr("!="))

    implicit val leqPred: LEQ[T] = build[T, LEQ](binaryPredExpr("<="))

    implicit val geqPred: GEQ[T] = build[T, GEQ](binaryPredExpr(">="))

    implicit val likePred: LIKE[T] = build[T, LIKE](binaryPredExpr("LIKE"))

    implicit val inPred: IN[T] = build[T, IN](binaryPredExpr("IN"))

    implicit val notInPred: NOTIN[T] = build[T, NOTIN](binaryPredExpr("NOT IN"))

    implicit val isNullPred: ISNULL[T] = build1[T, ISNULL](unaryPredExpr("IS NULL"))

    implicit val isNotNullPred: ISNOTNULL[T] =
      build1[T, ISNOTNULL](unaryPredExpr("IS NOT NULL"))

    implicit val betweenPred: BETWEEN[T] = build[T, BETWEEN](binaryPredExpr("BETWEEN"))

    implicit val notBetweenPred: NOTBETWEEN[T] =
      build[T, NOTBETWEEN](binaryPredExpr("NOT BETWEEN"))
  }

}
