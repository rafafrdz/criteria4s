package io.github.rafafrdz.criterial.examples.datastores

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialCondOp._
import io.github.rafafrdz.criterial.core.CriterialPredOp._
import io.github.rafafrdz.criterial.instances._

trait Postgres extends CriterialTag

object Postgres {

  private def opeExpr(symbol: String)(a: String, b: String): String = s"($a $symbol $b)"
  private def opeExpr1(symbol: String)(a: String): String           = s"($a $symbol)"

  implicit val ltPred: LT[Postgres] = build[Postgres, LT](opeExpr("<"))

  implicit val gtPred: GT[Postgres] = build[Postgres, GT](opeExpr(">"))

  implicit val orOp: OR[Postgres] = build[Postgres, OR](opeExpr("OR"))

  implicit val andOp: AND[Postgres] = build[Postgres, AND](opeExpr("AND"))

  implicit val eqPred: EQ[Postgres] = build[Postgres, EQ](opeExpr("="))

  implicit val neqPred: NEQ[Postgres] = build[Postgres, NEQ](opeExpr("!="))

  implicit val leqPred: LEQ[Postgres] = build[Postgres, LEQ](opeExpr("<="))

  implicit val geqPred: GEQ[Postgres] = build[Postgres, GEQ](opeExpr(">="))

  implicit val likePred: LIKE[Postgres] = build[Postgres, LIKE](opeExpr("LIKE"))

  implicit val inPred: IN[Postgres] = build[Postgres, IN](opeExpr("IN"))

  implicit val notinPred: NOTIN[Postgres] = build[Postgres, NOTIN](opeExpr("NOT IN"))

  implicit val isnullPred: ISNULL[Postgres] = build1[Postgres, ISNULL](opeExpr1("IS NULL"))

  implicit val isnotnullPred: ISNOTNULL[Postgres] =
    build1[Postgres, ISNOTNULL](opeExpr1("IS NOT NULL"))

  implicit val betweenPred: BETWEEN[Postgres] = build[Postgres, BETWEEN](opeExpr("BETWEEN"))

  implicit val notbetweenPred: NOTBETWEEN[Postgres] =
    build[Postgres, NOTBETWEEN](opeExpr("NOT BETWEEN"))

}
