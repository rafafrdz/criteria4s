package io.github.rafafrdz.criteria4s.examples.datastores

import io.github.rafafrdz.criteria4s.sql._
import io.github.rafafrdz.criteria4s.sql.SQL

trait Postgres extends SQL
object Postgres extends SQLExpr[Postgres]
