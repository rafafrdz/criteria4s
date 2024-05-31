package io.github.rafafrdz.criteria4s.examples.datastores

import io.github.rafafrdz.criteria4s.core.{Column, Show}
import io.github.rafafrdz.criteria4s.dialect.sql.{SQL, _}

trait Postgres  extends SQL
object Postgres extends SQLExpr[Postgres] {

  /**
   * That's not the right symbol for Postgres but it's just an example of how to override the
   * default implementation
   */

  implicit val showColumn: Show[Column, Postgres] = Show.create(col => s"'${col.colName}'")
  implicit def showSeq[T](implicit show: Show[T, Postgres]): Show[Seq[T], Postgres] =
    Show.create(_.map(show.show).mkString("(", ", ", ")"))
  implicit def betweenShow[T](implicit show: Show[T, Postgres]): Show[(T, T), Postgres] =
    Show.create { case (l, r) => s"${show.show(l)} TO ${show.show(r)}" }
}
