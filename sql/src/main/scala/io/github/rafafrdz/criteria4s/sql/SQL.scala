package io.github.rafafrdz.criteria4s.sql

import io.github.rafafrdz.criteria4s.core.Conjuction._
import io.github.rafafrdz.criteria4s.core.PredicateBinary._
import io.github.rafafrdz.criteria4s.core.PredicateUnary._
import io.github.rafafrdz.criteria4s.core.{Column, CriteriaTag, Show}
import io.github.rafafrdz.criteria4s.instances._

trait SQL extends CriteriaTag

object SQL {

  private def opExpr(symbol: String)(left: String, right: String): String =
    s"($left) $symbol ($right)"

  private def predExpr(symbol: String)(left: String, right: String): String =
    s"$left $symbol $right"

  private def predExpr1(symbol: String)(value: String): String = s"$value $symbol"

  implicit val showColumn: Show[Column, SQL] = Show.create(col => s"'${col.colName}'")

  trait SQLExpr[T <: SQL] {

    protected def opExpr(symbol: String): (String, String) => String =
      (left: String, right: String) => SQL.opExpr(symbol)(left, right)

    protected def predExpr(symbol: String): (String, String) => String =
      (left: String, right: String) => SQL.predExpr(symbol)(left, right)

    protected def predExpr1(symbol: String): String => String = (value: String) =>
      SQL.predExpr1(symbol)(value)

    implicit val ltPred: LT[T] = build[T, LT](predExpr("<"))

    implicit val gtPred: GT[T] = build[T, GT](predExpr(">"))

    implicit val orOp: OR[T] = build[T, OR](opExpr("OR"))

    implicit val andOp: AND[T] = build[T, AND](opExpr("AND"))

    implicit val eqPred: EQ[T] = build[T, EQ](predExpr("="))

    implicit val neqPred: NEQ[T] = build[T, NEQ](predExpr("!="))

    implicit val leqPred: LEQ[T] = build[T, LEQ](predExpr("<="))

    implicit val geqPred: GEQ[T] = build[T, GEQ](predExpr(">="))

    implicit val likePred: LIKE[T] = build[T, LIKE](predExpr("LIKE"))

    implicit val inPred: IN[T] = build[T, IN](predExpr("IN"))

    implicit val notinPred: NOTIN[T] = build[T, NOTIN](predExpr("NOT IN"))

    implicit val isnullPred: ISNULL[T] = build[T, ISNULL](predExpr1("IS NULL"))

    implicit val isnotnullPred: ISNOTNULL[T] =
      build[T, ISNOTNULL](predExpr1("IS NOT NULL"))

    implicit val betweenPred: BETWEEN[T] = build[T, BETWEEN](predExpr("BETWEEN"))

    implicit val notbetweenPred: NOTBETWEEN[T] =
      build[T, NOTBETWEEN](predExpr("NOT BETWEEN"))
  }

}
