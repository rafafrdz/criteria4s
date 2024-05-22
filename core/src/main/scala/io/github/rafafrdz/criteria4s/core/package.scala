package io.github.rafafrdz.criteria4s

package object core {

  type CriteriaTag = Criteria.CriteriaTag

  type AND[T <: CriteriaTag] = Conjuction.AND[T]

  type OR[T <: CriteriaTag] = Conjuction.OR[T]

  type GT[T <: CriteriaTag] = PredicateBinary.GT[T]

  type LT[T <: CriteriaTag] = PredicateBinary.LT[T]

  type EQ[T <: CriteriaTag] = PredicateBinary.EQ[T]

  type NEQ[T <: CriteriaTag] = PredicateBinary.NEQ[T]

  type GEQ[T <: CriteriaTag] = PredicateBinary.GEQ[T]

  type LEQ[T <: CriteriaTag] = PredicateBinary.LEQ[T]

  type LIKE[T <: CriteriaTag] = PredicateBinary.LIKE[T]

  type IN[T <: CriteriaTag] = PredicateBinary.IN[T]

  type NOTIN[T <: CriteriaTag] = PredicateBinary.NOTIN[T]

  type ISNULL[T <: CriteriaTag] = PredicateUnary.ISNULL[T]

  type ISNOTNULL[T <: CriteriaTag] = PredicateUnary.ISNOTNULL[T]

  type BETWEEN[T <: CriteriaTag] = PredicateBinary.BETWEEN[T]

  type NOTBETWEEN[T <: CriteriaTag] = PredicateBinary.NOTBETWEEN[T]

}
