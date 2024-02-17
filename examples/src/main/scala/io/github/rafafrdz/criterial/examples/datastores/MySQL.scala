package io.github.rafafrdz.criterial.examples.datastores

import io.github.rafafrdz.criterial.core.CriterialPredOp._
import io.github.rafafrdz.criterial.instances._
import io.github.rafafrdz.criterial.sql.SQL
import io.github.rafafrdz.criterial.sql.SQL.SQLExpr

trait MySQL extends SQL

object MySQL extends SQLExpr[MySQL] {

  private def opeExpr(symbol: String)(a: String, b: String): String = s"($a $symbol $b)"

  // That's not the right symbol for MySQL but it's just an example of how to override the default implementation
  implicit override val leqPred: LEQ[MySQL] = build[MySQL, LEQ](opeExpr("<<<"))

}
