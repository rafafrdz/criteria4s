package io.github.rafafrdz.criterial.examples.datastores

import io.github.rafafrdz.criterial.core.PredOp._
import io.github.rafafrdz.criterial.instances._
import io.github.rafafrdz.criterial.sql._

trait MySQL extends SQL

object MySQL extends SQLExpr[MySQL] {

  private def opeExpr(symbol: String)(a: String, b: String): String = s"($a $symbol $b)"

  // That's not the right symbol for MySQL but it's just an example of how to override the default implementation
  implicit override val leqPred: LEQ[MySQL] = build[MySQL, LEQ](opeExpr("<<<"))

}
