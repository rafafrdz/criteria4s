package io.github.rafafrdz.criterial

package object core {

  type CriterialTag = Criterial.CriterialTag

  type AND[T <: CriterialTag] = ConjOp.AND[T]

  type OR[T <: CriterialTag] = ConjOp.OR[T]

  type GT[T <: CriterialTag] = PredOp.GT[T]

  type LT[T <: CriterialTag] = PredOp.LT[T]

  type EQ[T <: CriterialTag] = PredOp.EQ[T]

  type NEQ[T <: CriterialTag] = PredOp.NEQ[T]

  type GEQ[T <: CriterialTag] = PredOp.GEQ[T]

  type LEQ[T <: CriterialTag] = PredOp.LEQ[T]

  type LIKE[T <: CriterialTag] = PredOp.LIKE[T]

  type IN[T <: CriterialTag] = PredOp.IN[T]

  type NOTIN[T <: CriterialTag] = PredOp.NOTIN[T]

  type ISNULL[T <: CriterialTag] = PredOp.ISNULL[T]

  type ISNOTNULL[T <: CriterialTag] = PredOp.ISNOTNULL[T]

  type BETWEEN[T <: CriterialTag] = PredOp.BETWEEN[T]

  type NOTBETWEEN[T <: CriterialTag] = PredOp.NOTBETWEEN[T]

}
