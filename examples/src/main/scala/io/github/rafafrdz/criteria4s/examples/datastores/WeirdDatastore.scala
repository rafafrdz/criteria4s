package io.github.rafafrdz.criteria4s.examples.datastores

import io.github.rafafrdz.criteria4s.core.ConjOp._
import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.PredicateBinary._
import io.github.rafafrdz.criteria4s.core.PredicateUnary._
import io.github.rafafrdz.criteria4s.core.Show
import io.github.rafafrdz.criteria4s.core.Show.ShowColumn
import io.github.rafafrdz.criteria4s.instances._

trait WeirdDatastore extends CriteriaTag

object WeirdDatastore {

  private def wope(symbol: String)(left: String, right: String): String =
    s"""{left: $left, opt: $symbol, right: $right }""".stripMargin

  private def wope1(symbol: String)(left: String): String =
    s"""{left: $left, opt: $symbol }""".stripMargin

  implicit def showSeq[V](implicit show: Show[V, WeirdDatastore]): Show[Seq[V], WeirdDatastore] =
    Show.create(_.map(show.show).mkString("[", ", ", "]"))

  implicit def showRange[V](implicit show: Show[V, WeirdDatastore]): Show[(V, V), WeirdDatastore] =
    Show.create { case (l, r) => s"[${show.show(l)}, ${show.show(r)}]" }

  implicit val showColumn: ShowColumn[WeirdDatastore] = Show.create(_.colName)

  implicit val ltPred: LT[WeirdDatastore] = build[WeirdDatastore, LT](wope("<"))

  implicit val gtPred: GT[WeirdDatastore] = build[WeirdDatastore, GT](wope(">"))

  implicit val orOp: OR[WeirdDatastore] = build[WeirdDatastore, OR](wope("OR"))

  implicit val andOp: AND[WeirdDatastore] = build[WeirdDatastore, AND](wope("AND"))

  implicit val eqPred: EQ[WeirdDatastore] = build[WeirdDatastore, EQ](wope("="))

  implicit val neqPred: NEQ[WeirdDatastore] = build[WeirdDatastore, NEQ](wope("!="))

  implicit val leqPred: LEQ[WeirdDatastore] = build[WeirdDatastore, LEQ](wope("<="))

  implicit val geqPred: GEQ[WeirdDatastore] = build[WeirdDatastore, GEQ](wope(">="))

  implicit val likePred: LIKE[WeirdDatastore] = build[WeirdDatastore, LIKE](wope("LIKE"))

  implicit val inPred: IN[WeirdDatastore] = build[WeirdDatastore, IN](wope("IN"))

  implicit val notinPred: NOTIN[WeirdDatastore] = build[WeirdDatastore, NOTIN](wope("NOT IN"))

  implicit val isnullPred: ISNULL[WeirdDatastore] = build1[WeirdDatastore, ISNULL](wope1("IS NULL"))

  implicit val isnotnullPred: ISNOTNULL[WeirdDatastore] =
    build1[WeirdDatastore, ISNOTNULL](wope1("IS NOT NULL"))

  implicit val betweenPred: BETWEEN[WeirdDatastore] =
    build[WeirdDatastore, BETWEEN](wope("BETWEEN"))

  implicit val notbetweenPred: NOTBETWEEN[WeirdDatastore] =
    build[WeirdDatastore, NOTBETWEEN](wope("NOT BETWEEN"))

}
