package io.github.rafafrdz.criteria4s.examples.datastores

import io.github.rafafrdz.criteria4s.core.{Column, Show}
import io.github.rafafrdz.criteria4s.sql.{SQL, _}

trait Postgres  extends SQL
object Postgres extends SQLExpr[Postgres] {

  /**
   * That's not the right symbol for Postgres but it's just an example of how to override the
   * default implementation
   */

  implicit val showColumn: Show[Column, Postgres] = Show.create(col => s"'${col.colName}'")
  implicit def showSeq[T](implicit show: Show[T, Postgres]): Show[Seq[T], Postgres] =
    Show.create(_.mkString("(", ", ", ")"))

//  val C: String => String                     = s => s"`$s`"
//  val V: String => String                     = s => s"'$s'"
//  override implicit val symRef: Sym[Postgres] = sym[Postgres](C, V)
}
