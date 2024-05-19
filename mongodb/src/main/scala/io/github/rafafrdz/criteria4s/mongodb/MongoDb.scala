package io.github.rafafrdz.criteria4s.mongodb

import io.github.rafafrdz.criteria4s.core.ConjOp.{AND, OR}
import io.github.rafafrdz.criteria4s.core.{Column, CriteriaTag, Show}
import io.github.rafafrdz.criteria4s.core.PredicateBinary._
import io.github.rafafrdz.criteria4s.core.PredicateUnary._
import io.github.rafafrdz.criteria4s.instances._

trait MongoDb extends CriteriaTag

object MongoDb {
  private def binaryPredExpr(symbol: String)(a: String, b: String): String =
    s"{ $a: { $$$symbol: $b } }"
  private def opExpr(symbol: String)(a: String, b: String): String =
    s"{ $$$symbol: [ { $a }, { $b } ] }"

  implicit val showColumn: Show[Column, MongoDb] = Show.create(col => s"\"${col.colName}\"")
  implicit def showSeq[T](implicit show: Show[T, MongoDb]): Show[Seq[T], MongoDb] =
    Show.create(_.map(show.show).mkString("[", ", ", "]"))
  implicit def betweenShow[T](implicit show: Show[T, MongoDb]): Show[(T, T), MongoDb] =
    Show.create { case (l, r) => s"{ $$gte }" }

  trait MongoDbExpr[T <: MongoDb] {
    implicit val ltPred: LT[T] = build[T, LT](binaryPredExpr("lt"))

    implicit val gtPred: GT[T] = build[T, GT](binaryPredExpr("gt"))

    implicit val orOp: OR[T] = build[T, OR](opExpr("or"))

    implicit val andOp: AND[T] = build[T, AND](opExpr("and"))

    implicit val eqPred: EQ[T] = build[T, EQ](binaryPredExpr("eq"))

    implicit val neqPred: NEQ[T] = build[T, NEQ](binaryPredExpr("ne"))

    implicit val leqPred: LEQ[T] = build[T, LEQ](binaryPredExpr("lte"))

    implicit val geqPred: GEQ[T] = build[T, GEQ](binaryPredExpr("gte"))

    implicit val likePred: LIKE[T] = build[T, LIKE] { case (ref, regex) =>
      binaryPredExpr("regex")(ref, s"\\$regex\\")
    }

    implicit val inPred: IN[T] = build[T, IN](binaryPredExpr("in"))

    implicit val notInPred: NOTIN[T] = build[T, NOTIN](binaryPredExpr("nin"))

    implicit val isNullPred: ISNULL[T] = build1[T, ISNULL](ref => s"{ $ref: null }")

    implicit val isNotNullPred: ISNOTNULL[T] =
      build1[T, ISNOTNULL](ref => s"{ $ref: { $$ne: null } }")

    implicit val betweenPred: BETWEEN[T] = build[T, ISNOTNULL] { case (ref, range) =>
      s"{ $ref : { $} }"
    }
  }
}
