package com.eff3ct.criteria4s.examples

import com.eff3ct.criteria4s.core._
import com.eff3ct.criteria4s.dialect.mongodb.MongoDB
import com.eff3ct.criteria4s.examples.datastores.{MySQL, Postgres, WeirdDatastore}
import com.eff3ct.criteria4s.extensions._
import com.eff3ct.criteria4s.functions._

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
       |Examples for MongoDB instances
       |
       |expr[MongoDB]: ${expr[MongoDB]("USER_ID", UUID.randomUUID())}
       |
       |""".stripMargin
  }
}
