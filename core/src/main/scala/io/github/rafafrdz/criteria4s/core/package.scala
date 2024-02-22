package io.github.rafafrdz.criteria4s

package object core {

  type CriteriaTag = Criteria.CriteriaTag

  type AND[T <: CriteriaTag] = ConjOp.AND[T]

  type OR[T <: CriteriaTag] = ConjOp.OR[T]

  type GT[T <: CriteriaTag] = PredOp.GT[T]

  type LT[T <: CriteriaTag] = PredOp.LT[T]

  type EQ[T <: CriteriaTag] = PredOp.EQ[T]

  type NEQ[T <: CriteriaTag] = PredOp.NEQ[T]

  type GEQ[T <: CriteriaTag] = PredOp.GEQ[T]

  type LEQ[T <: CriteriaTag] = PredOp.LEQ[T]

  type LIKE[T <: CriteriaTag] = PredOp.LIKE[T]

  type IN[T <: CriteriaTag] = PredOp.IN[T]

  type NOTIN[T <: CriteriaTag] = PredOp.NOTIN[T]

  type ISNULL[T <: CriteriaTag] = PredOp.ISNULL[T]

  type ISNOTNULL[T <: CriteriaTag] = PredOp.ISNOTNULL[T]

  type BETWEEN[T <: CriteriaTag] = PredOp.BETWEEN[T]

  type NOTBETWEEN[T <: CriteriaTag] = PredOp.NOTBETWEEN[T]

}
