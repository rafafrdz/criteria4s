package io.github.rafafrdz.criteria4s.dialect.mongodb

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.instances._

trait MongoDB extends CriteriaTag

object MongoDB {
  private def predExpr(symbol: String): (String, String) => String =
    (left, right) => s"{$left: {$$$symbol: $right}}"

  private def conjExpr(symbol: String): (String, String) => String =
    (left, right) => s"{$$$symbol: [$left, $right]}"

  private def conjExpr1(symbol: String): String => String =
    right => s"{$$$symbol: $right}"

  private def notExpr: String => String =
    ref => {
      val (left, right): (String, String) =
        (ref.takeWhile(c => c != ':'), ref.dropWhile(c => c != ':'))
      s"$left: {$$not$right}"
    }

  private val likeExpr: (String, String) => String =
    (value, regex) => predExpr("regex")(value, s"\\$regex\\")

  private val isNullExpr: String => String =
    ref => s"{$ref: null}"

  private val isNotNullExpr: String => String =
    ref => s"{$ref: {$$ne: null}}"

  private val betweenExample: (String, String) => String =
    (ref, range) => s"{$ref: $range}"

  implicit val showColumn: Show[Column, MongoDB] =
    Show.create(col => s"\"${col.colName}\"")

  implicit def showSeq[T](implicit show: Show[T, MongoDB]): Show[Seq[T], MongoDB] =
    Show.create(_.map(show.show).mkString("[", ", ", "]"))

  implicit def betweenShow[T](implicit show: Show[T, MongoDB]): Show[(T, T), MongoDB] =
    Show.create { case (l, r) => s"{ $$gte: ${show.show(l)}, $$lt: ${show.show(r)} }" }

  trait MongoDBExpr[T <: MongoDB] {
    implicit val andConj: AND[T]             = build[T, AND](conjExpr("and"))
    implicit val orConj: OR[T]               = build[T, OR](conjExpr("or"))
    implicit val notConj: NOT[T]             = build[T, NOT](notExpr)
    implicit val eqPred: EQ[T]               = build[T, EQ](predExpr("eq"))
    implicit val neqPred: NEQ[T]             = build[T, NEQ](predExpr("ne"))
    implicit val gtPred: GT[T]               = build[T, GT](predExpr("gt"))
    implicit val geqPred: GEQ[T]             = build[T, GEQ](predExpr("gte"))
    implicit val ltPred: LT[T]               = build[T, LT](predExpr("lt"))
    implicit val leqPred: LEQ[T]             = build[T, LEQ](predExpr("lte"))
    implicit val inPred: IN[T]               = build[T, IN](predExpr("in"))
    implicit val notInPred: NOTIN[T]         = build[T, NOTIN](predExpr("nin"))
    implicit val likePred: LIKE[T]           = build[T, LIKE](likeExpr)
    implicit val isNullPred: ISNULL[T]       = build[T, ISNULL](isNullExpr)
    implicit val isNotNullPred: ISNOTNULL[T] = build[T, ISNOTNULL](isNotNullExpr)
    implicit val betweenPred: BETWEEN[T]     = build[T, BETWEEN](betweenExample)
  }
}
