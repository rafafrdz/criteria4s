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
import com.eff3ct.criteria4s.examples.datastores._
import com.eff3ct.criteria4s.extensions._
import com.eff3ct.criteria4s.functions._

object NotExample extends App {

  val simpleNot: Criteria[Postgres] = not(col[Postgres]("a").between(range(1, 10)))

  val symbolNot: Criteria[Postgres] = !!(col[Postgres]("a").between(range(1, 10)))

  def taglessFinalNotExample[
      T <: CriteriaTag: GT: NOT: Show[Column, *]: Show[(Int, Int), *]
  ]: Criteria[T] =
    not(col[T]("column") gt lit(100))

  def taglessFinalNotSymbolExample[
      T <: CriteriaTag: BETWEEN: NOT: Show[Column, *]: Show[(Int, Int), *]
  ]: Criteria[T] =
    !!(col[T]("column") between range(100, 150))

  def weirdExampleWithNot[
      T <: CriteriaTag: NOT: GT: LEQ: AND: Show[Column, *]: Show[(Int, Int), *]
  ]: Criteria[T] =
    not(col[T]("column") gt lit(2)) && (col[T]("column") leq lit(10))

  println(simpleNot)
  println(symbolNot)
  println(taglessFinalNotExample[Postgres])
  println(taglessFinalNotExample[WeirdDatastore])
  println(taglessFinalNotExample[MongoDB])

  println(taglessFinalNotSymbolExample[Postgres])
  println(taglessFinalNotSymbolExample[WeirdDatastore])
  println(taglessFinalNotSymbolExample[MongoDB])

  println(weirdExampleWithNot[Postgres])
  println(weirdExampleWithNot[WeirdDatastore])
  println(weirdExampleWithNot[MongoDB])
}
