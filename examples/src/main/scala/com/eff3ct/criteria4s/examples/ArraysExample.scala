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

object ArraysExample extends App {
  val aIsNull: Criteria[Postgres] = isNull(col("a"))
  def aIsNullAlgebra[
      T <: CriteriaTag: ISNULL: Show[Column, *]
  ]: Criteria[T] = isNull(col("a"))

  val numberInArray: Criteria[Postgres] = in(col("a"), array(1, 2, 3))
  def numberInArrayAlgebra[T <: CriteriaTag: IN: Show[Column, *]: Show[Seq[Int], *]]: Criteria[T] =
    in(col("a"), array(1, 2, 3))

  val combined: Criteria[Postgres]     = or(aIsNull, numberInArray)
  val moreCombined: Criteria[Postgres] = or(combined, ===(col("b"), lit(10)))

  println(aIsNull)
  println(aIsNullAlgebra[Postgres])
  println(aIsNullAlgebra[WeirdDatastore])
  println(aIsNullAlgebra[MongoDB])

  println(numberInArray)
  println(numberInArrayAlgebra[Postgres])
  println(numberInArrayAlgebra[WeirdDatastore])
  println(numberInArrayAlgebra[MongoDB])

  println(combined)
  println(moreCombined)
}
