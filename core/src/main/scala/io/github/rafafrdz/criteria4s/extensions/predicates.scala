package io.github.rafafrdz.criteria4s.extensions

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.PredicateBinary._
import io.github.rafafrdz.criteria4s.core.PredicateUnary._
import io.github.rafafrdz.criteria4s.core.{Criteria, Ref}
import io.github.rafafrdz.criteria4s.{functions => F}

trait predicates {

  implicit class CriteriaPredImplicit[T <: CriteriaTag](c: Ref[T]) {
    def lt(other: Ref[T])(implicit H: LT[T]): Criteria[T]   = F.lt(c, other)
    def gt(other: Ref[T])(implicit H: GT[T]): Criteria[T]   = F.gt(c, other)
    def leq(other: Ref[T])(implicit H: LEQ[T]): Criteria[T] = F.leq(c, other)

    def geq(other: Ref[T])(implicit H: GEQ[T]): Criteria[T] = F.geq(c, other)

    def ===(other: Ref[T])(implicit H: EQ[T]): Criteria[T] = F.===(c, other)

    def =!=(other: Ref[T])(implicit H: NEQ[T]): Criteria[T] = F.=!=(c, other)

    def like(other: Ref[T])(implicit H: LIKE[T]): Criteria[T] = F.like(c, other)

    def in(other: Ref[T])(implicit H: IN[T]): Criteria[T] = F.in(c, other)

    def notin(other: Ref[T])(implicit H: NOTIN[T]): Criteria[T] = F.notin(c, other)

    def isNull(implicit H: ISNULL[T]): Criteria[T] = F.isNull(c)

    def isNotNull(implicit H: ISNOTNULL[T]): Criteria[T] = F.isNotNull(c)

    def between(other: Ref[T])(implicit H: BETWEEN[T]): Criteria[T] = F.between(c, other)

    def notBetween(other: Ref[T])(implicit H: NOTBETWEEN[T]): Criteria[T] =
      F.notBetween(c, other)

  }

}

object predicates extends predicates
