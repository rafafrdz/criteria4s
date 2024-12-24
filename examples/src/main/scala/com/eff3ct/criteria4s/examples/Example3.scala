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
import com.eff3ct.criteria4s.examples.datastores.{Postgres, WeirdDatastore}
import com.eff3ct.criteria4s.functions._

object Example3 extends App {

  def example1[T <: CriteriaTag: LT: AND: OR: Show[Column, *]]: Criteria[T] =
    or(and(lt(col("a"), lit(3)), lt(col("b"), lit(4))), bool(true))

  def example2[T <: CriteriaTag: LT: AND: OR: GEQ: ISNULL: NEQ: Show[Column, *]]: Criteria[T] =
    or(
      and(
        lt(col("col1"), lit(3)),
        geq(col("col2"), lit(4))
      ),
      and(isNull(col("col3")), =!=(col("col4"), col("col5")))
    )

  println {
    s"""Examples for Postgres instances
       |
       |example1[Postgres]: ${example1[Postgres]}
       |
       |example2[Postgres]: ${example2[Postgres]}
       |
       |Examples for WeirdDatastore instances
       |
       |example1[WeirdDatastore]: ${example1[WeirdDatastore]}
       |
       |example2[WeirdDatastore]: ${example2[WeirdDatastore]}
       |
       |Examples for MongoDB instances
       |
       |example1[MongoDB]: ${example1[MongoDB]}
       |
       |example2[MongoDB]: ${example2[MongoDB]}
       |""".stripMargin
  }
}
