package io.github.rafafrdz.criteria4s.examples

import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.examples.datastores.{MySQL, Postgres, WeirdDatastore}
import io.github.rafafrdz.criteria4s.extensions._
import io.github.rafafrdz.criteria4s.functions._
import io.github.rafafrdz.criteria4s.mongodb.MongoDb

import java.util.UUID

object FilterByUserExample extends App {

  def expr[T <: CriteriaTag: EQ: Show[Column, *]](fieldName: String, id: UUID): Criteria[T] =
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
       |Examples for MongoDb instances
       |
       |expr[MongoDb]: ${expr[MongoDb]("USER_ID", UUID.randomUUID())}
       |
       |""".stripMargin
  }
}
