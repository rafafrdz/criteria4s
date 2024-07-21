package io.github.rafafrdz.criteria4s.dialect.sql

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.instances._

trait SQL extends CriteriaTag

object SQL {

  private def conjExpr(symbol: String)(left: String, right: String): String =
    s"($left) $symbol ($right)"

  private def conjExpr1(symbol: String)(right: String): String =
    s"$symbol ($right)"

  private def predExpr(symbol: String)(left: String, right: String): String =
    s"$left $symbol $right"

  private def predExpr1(symbol: String)(value: String): String =
    s"$value $symbol"

  implicit val showColumn: Show[Column, SQL] =
    Show.create(col => s"'${col.colName}'")

  trait SQLExpr[T <: SQL] {

    protected def conjExpr(symbol: String): (String, String) => String =
      (left: String, right: String) => SQL.conjExpr(symbol)(left, right)

    protected def conjExpr1(symbol: String): String => String =
      (right: String) => SQL.conjExpr1(symbol)(right)

    protected def predExpr(symbol: String): (String, String) => String =
      (left: String, right: String) => SQL.predExpr(symbol)(left, right)

    protected def predExpr1(symbol: String): String => String = (value: String) =>
      SQL.predExpr1(symbol)(value)

    implicit val andConj: AND[T]               = build[T, AND](conjExpr("AND"))
    implicit val orConj: OR[T]                 = build[T, OR](conjExpr("OR"))
    implicit val notConj: NOT[T]               = build[T, NOT](conjExpr1("NOT"))
    implicit val eqPred: EQ[T]                 = build[T, EQ](predExpr("="))
    implicit val neqPred: NEQ[T]               = build[T, NEQ](predExpr("!="))
    implicit val gtPred: GT[T]                 = build[T, GT](predExpr(">"))
    implicit val geqPred: GEQ[T]               = build[T, GEQ](predExpr(">="))
    implicit val ltPred: LT[T]                 = build[T, LT](predExpr("<"))
    implicit val leqPred: LEQ[T]               = build[T, LEQ](predExpr("<="))
    implicit val inPred: IN[T]                 = build[T, IN](predExpr("IN"))
    implicit val notinPred: NOTIN[T]           = build[T, NOTIN](predExpr("NOT IN"))
    implicit val likePred: LIKE[T]             = build[T, LIKE](predExpr("LIKE"))
    implicit val isnullPred: ISNULL[T]         = build[T, ISNULL](predExpr1("IS NULL"))
    implicit val isnotnullPred: ISNOTNULL[T]   = build[T, ISNOTNULL](predExpr1("IS NOT NULL"))
    implicit val betweenPred: BETWEEN[T]       = build[T, BETWEEN](predExpr("BETWEEN"))
    implicit val notbetweenPred: NOTBETWEEN[T] = build[T, NOTBETWEEN](predExpr("NOT BETWEEN"))
  }

}
