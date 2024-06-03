package io.github.rafafrdz.criteria4s.dialect.mongodb

import io.github.rafafrdz.criteria4s.core.Conjuction.{AND, OR}
import io.github.rafafrdz.criteria4s.core.{Column, CriteriaTag, Show}
import io.github.rafafrdz.criteria4s.core.PredicateBinary._
import io.github.rafafrdz.criteria4s.core.PredicateUnary._
import io.github.rafafrdz.criteria4s.instances._

trait MongoDB extends CriteriaTag

object MongoDB {
  private def binaryPredExpr(symbol: String): (String, String) => String =
    (left, right) => s"{$left: {$$$symbol: $right}}"

  private def opExpr(symbol: String): (String, String) => String =
    (left, right) => s"{$$$symbol: [{$left}, {$right}]}"

  private val likeExpr: (String, String) => String =
    (value, regex) => binaryPredExpr("regex")(value, s"\\$regex\\")

  private val isNullExpr: String => String =
    ref => s"{$ref: null}"

  private val isNotNullExpr: String => String =
    ref => s"{$ref: {$$ne: null}}"

  private val betweenExample: (String, String) => String =
    (ref, range) => s"{$ref: $range}"

  implicit val showColumn: Show[Column, MongoDB] = Show.create(col => s"\"${col.colName}\"")
  implicit def showSeq[T](implicit show: Show[T, MongoDB]): Show[Seq[T], MongoDB] =
    Show.create(_.map(show.show).mkString("[", ", ", "]"))
  implicit def betweenShow[T](implicit show: Show[T, MongoDB]): Show[(T, T), MongoDB] =
    Show.create { case (l, r) => s"{ $$gte: ${show.show(l)}, $$lt: ${show.show(r)} }" }

  trait MongoDBExpr[T <: MongoDB] {
    implicit val ltPred: LT[T]               = build[T, LT](binaryPredExpr("lt"))
    implicit val gtPred: GT[T]               = build[T, GT](binaryPredExpr("gt"))
    implicit val orOp: OR[T]                 = build[T, OR](opExpr("or"))
    implicit val andOp: AND[T]               = build[T, AND](opExpr("and"))
    implicit val eqPred: EQ[T]               = build[T, EQ](binaryPredExpr("eq"))
    implicit val neqPred: NEQ[T]             = build[T, NEQ](binaryPredExpr("ne"))
    implicit val leqPred: LEQ[T]             = build[T, LEQ](binaryPredExpr("lte"))
    implicit val geqPred: GEQ[T]             = build[T, GEQ](binaryPredExpr("gte"))
    implicit val likePred: LIKE[T]           = build[T, LIKE](likeExpr)
    implicit val inPred: IN[T]               = build[T, IN](binaryPredExpr("in"))
    implicit val notInPred: NOTIN[T]         = build[T, NOTIN](binaryPredExpr("nin"))
    implicit val isNullPred: ISNULL[T]       = build[T, ISNULL](isNullExpr)
    implicit val isNotNullPred: ISNOTNULL[T] = build[T, ISNOTNULL](isNotNullExpr)
    implicit val betweenPred: BETWEEN[T]     = build[T, BETWEEN](betweenExample)
  }
}
