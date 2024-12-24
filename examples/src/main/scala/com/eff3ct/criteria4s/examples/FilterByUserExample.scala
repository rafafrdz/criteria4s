/*
 * MIT License
 *
 * Copyright (c) 2024 Rafael Fernandez
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
