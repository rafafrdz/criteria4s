package io.github.rafafrdz.criteria4s.examples.datastores

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.instances._
import io.github.rafafrdz.criteria4s.sql.{SQL, _}

trait Postgres  extends SQL
object Postgres extends SQLExpr[Postgres] {

  /**
   * That's not the right symbol for Postgres but it's just an example of how to override the
   * default implementation
   */

  val C: String => String                     = s => s"`$s`"
  val V: String => String                     = s => s"'$s'"
  override implicit val symRef: Sym[Postgres] = sym[Postgres](C, V)
}
