package io.github.rafafrdz.examples

import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialPredOp.EQ
import io.github.rafafrdz.criterial.extensions._
import io.github.rafafrdz.criterial.functions._
import io.github.rafafrdz.examples.datastores.Postgres._
import io.github.rafafrdz.examples.datastores.{Postgres, WeirdDatastore}

import java.util.UUID

object FilterByUserExample extends App {

  def expr[T <: CriterialTag: EQ](fieldName: String, id: UUID): Criterial[T] =
    col[T](fieldName) === lit(id.toString)

  println {
    s"""Examples for Postgres instances
       |
       |expr[Postgres]: ${expr[Postgres]("USER_ID", UUID.randomUUID())}
       |
       |Examples for WeirdDatastore instances
       |
       |expr[WeirdDatastore]: ${expr[WeirdDatastore]("USER_ID", UUID.randomUUID())}
       |
       |""".stripMargin
  }
}
