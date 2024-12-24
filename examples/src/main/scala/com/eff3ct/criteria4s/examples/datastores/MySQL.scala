package com.eff3ct.criteria4s.examples.datastores

import com.eff3ct.criteria4s.core.PredicateBinary._
import com.eff3ct.criteria4s.core.{Column, Show}
import com.eff3ct.criteria4s.instances._
import com.eff3ct.criteria4s.dialect.sql._

trait MySQL extends SQL

object MySQL extends SQLExpr[MySQL] {

  /**
   * That's not the right symbol for MySQL but it's just an example of how to override the default
   * implementation
   */
  implicit val showColumn: Show[Column, MySQL] = Show.create(_.colName)

  implicit override val leqPred: LEQ[MySQL] = build[MySQL, LEQ](predExpr("<<<"))

}
