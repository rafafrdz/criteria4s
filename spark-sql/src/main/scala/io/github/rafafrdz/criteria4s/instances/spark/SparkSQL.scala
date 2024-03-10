package io.github.rafafrdz.criteria4s.instances.spark

import io.github.rafafrdz.criteria4s.core.ConjOp._
import io.github.rafafrdz.criteria4s.core.PredOp._
import io.github.rafafrdz.criteria4s.core.Sym
import io.github.rafafrdz.criteria4s.sql._
import org.apache.spark.sql.functions._

trait SparkSQL extends SQL
object SparkSQL extends SQLExpr[SparkSQL] {

  override implicit val symRef: Sym[SparkSQL] =
    sym[SparkSQL](lit, col)

  override implicit val ltPred: LT[SparkSQL] = build[SparkSQL, LT]((c1, c2) => c1 < c2)

  override implicit val gtPred: GT[SparkSQL] = build[SparkSQL, GT]((c1, c2) => c1 > c2)

  override implicit val orOp: OR[SparkSQL] = build[SparkSQL, OR]((c1, c2) => c1 || c2)

  override implicit val andOp: AND[SparkSQL] = build[SparkSQL, AND]((c1, c2) => c1 && c2)

  override implicit val eqPred: EQ[SparkSQL] = build[SparkSQL, EQ]((c1, c2) => c1 === c2)

  override implicit val neqPred: NEQ[SparkSQL] = build[SparkSQL, NEQ]((c1, c2) => c1 =!= c2)

  override implicit val leqPred: LEQ[SparkSQL] = build[SparkSQL, LEQ]((c1, c2) => c1 <= c2)

  override implicit val geqPred: GEQ[SparkSQL] = build[SparkSQL, GEQ]((c1, c2) => c1 >= c2)

  override implicit val likePred: LIKE[SparkSQL] = buildLeft[SparkSQL, LIKE]((c1, c2) => c1 like c2)

  override implicit val inPred: IN[SparkSQL] = build[SparkSQL, IN]((c1, c2) => c1 isin c2)

  override implicit val notinPred: NOTIN[SparkSQL] =
    build[SparkSQL, NOTIN]((c1, c2) => !(c1 isin c2))

  override implicit val isnullPred: ISNULL[SparkSQL] =
    build1[SparkSQL, ISNULL](c => c.isNull)

  override implicit val isnotnullPred: ISNOTNULL[SparkSQL] =
    build1[SparkSQL, ISNOTNULL](c => c.isNotNull)

  // todo. fix between and notbetween

//  override implicit val betweenPred: BETWEEN[SparkSQL] =
//    build[SparkSQL, BETWEEN]((c1, c2) => c1 between c2)
//
//  override implicit val notbetweenPred: NOTBETWEEN[SparkSQL] =
//    build[SparkSQL, NOTBETWEEN]((c1, c2) => !(c1 between c2))
}
