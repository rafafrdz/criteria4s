package io.github.rafafrdz.criterial.examples

import io.github.rafafrdz.criterial.core._
import io.github.rafafrdz.criterial.examples.datastores.{MySQL, Postgres, WeirdDatastore}
import io.github.rafafrdz.criterial.extensions._
import io.github.rafafrdz.criterial.functions._

import java.util.UUID

object FilterByUserExample extends App {

  def expr[T <: CriterialTag: EQ](fieldName: String, id: UUID): Criterial[T] =
    col[T](fieldName) === lit(id.toString)

  println {
    s"""Examples for Postgres instances
       |
       |expr[Postgres]: ${expr[Postgres]("USER_ID", UUID.randomUUID())}
       |
       |Examples for MySQL instances
       |
       |expr[MySQL]: ${expr[MySQL]("USER_ID", UUID.randomUUID())}
       |
       |Examples for WeirdDatastore instances
       |
       |expr[WeirdDatastore]: ${expr[WeirdDatastore]("USER_ID", UUID.randomUUID())}
       |
       |""".stripMargin
  }
}
