package io.github.rafafrdz

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialOps._
import io.github.rafafrdz.criterial.core.CriterialPred._
import io.github.rafafrdz.criterial.functions.build

trait Postgres extends CriterialTag

object Postgres {

  implicit val ltPred: LT[Postgres] = build[Postgres, LT]((a, b) => s"($a < $b)")

  implicit val gtPred: GT[Postgres] = build[Postgres, GT]((a, b) => s"($a > $b)")

  implicit val orOp: OR[Postgres] = build[Postgres, OR]((a, b) => s"($a OR $b)")

  implicit val andOp: AND[Postgres] = build[Postgres, AND]((a, b) => s"($a AND $b)")

  implicit val eqPred: EQ[Postgres] = build[Postgres, EQ]((a, b) => s"($a = $b)")

  implicit val neqPred: NEQ[Postgres] = build[Postgres, NEQ]((a, b) => s"($a != $b)")

  implicit val leqPred: LEQ[Postgres] = build[Postgres, LEQ]((a, b) => s"($a <= $b)")

  implicit val geqPred: GEQ[Postgres] = build[Postgres, GEQ]((a, b) => s"($a >= $b)")

  implicit val likePred: LIKE[Postgres] = build[Postgres, LIKE]((a, b) => s"($a LIKE $b)")

  implicit val inPred: IN[Postgres] = build[Postgres, IN]((a, b) => s"($a IN $b)")

  implicit val notinPred: NOTIN[Postgres] = build[Postgres, NOTIN]((a, b) => s"($a NOT IN $b)")

  implicit val isnullPred: ISNULL[Postgres] = build[Postgres, ISNULL]((a, _) => s"($a IS NULL)")

  implicit val isnotnullPred: ISNOTNULL[Postgres] = build[Postgres, ISNOTNULL]((a, _) => s"($a IS NOT NULL)")

  implicit val betweenPred: BETWEEN[Postgres] = build[Postgres, BETWEEN]((a, b) => s"($a BETWEEN $b)")

  implicit val notbetweenPred: NOTBETWEEN[Postgres] = build[Postgres, NOTBETWEEN]((a, b) => s"($a NOT BETWEEN $b)")

}
