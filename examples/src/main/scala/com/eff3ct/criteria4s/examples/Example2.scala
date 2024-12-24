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
import com.eff3ct.criteria4s.examples.datastores.Postgres
import com.eff3ct.criteria4s.extensions._
import com.eff3ct.criteria4s.functions._

object Example2 extends App {

  val d: Criteria[Postgres]  = or(and(lt(col("a"), lit(3)), lt(col("b"), lit(4))), bool(true))
  val d2: Criteria[Postgres] = col[Postgres]("a") leq lit(3)
  val d3: Criteria[Postgres] = col[Postgres]("b") leq lit(4)
  val d4: Criteria[Postgres] = and(d2, d3)
  val d5: Criteria[Postgres] = col[Postgres]("c") === lit("c")
  val d6: Criteria[Postgres] = or(d4, d5)

  val expr: Criteria[Postgres] =
    (col[Postgres]("a") leq lit(3)) and
      (col[Postgres]("b") leq lit(4)) or
      (col[Postgres]("c") === lit("c"))

  val inlineExpr: Criteria[Postgres] =
    (col[Postgres]("a") leq lit(3)) and (col[Postgres]("b") leq lit(4)) or (col[Postgres](
      "c"
    ) === lit("c"))

  println(d6)
  println(expr)
  println(inlineExpr)
}
