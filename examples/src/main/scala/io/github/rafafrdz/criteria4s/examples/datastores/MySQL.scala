package io.github.rafafrdz.criteria4s.examples.datastores

import io.github.rafafrdz.criteria4s.core.PredOp._
import io.github.rafafrdz.criteria4s.instances._
import io.github.rafafrdz.criteria4s.sql._

trait MySQL extends SQL

object MySQL extends SQLExpr[MySQL] {

  /**
   * That's not the right symbol for MySQL but it's just an example of how to override the default
   * implementation
   */
  implicit override val leqPred: LEQ[MySQL] = build[MySQL, LEQ](predExpr("<<<"))

}
