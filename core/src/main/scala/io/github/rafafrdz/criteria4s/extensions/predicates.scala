package io.github.rafafrdz.criteria4s.extensions

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.Ref.Collection
import io.github.rafafrdz.criteria4s.core.PredicateBinary._
import io.github.rafafrdz.criteria4s.core.PredicateUnary._
import io.github.rafafrdz.criteria4s.core.{Criteria, Ref, Show}
import io.github.rafafrdz.criteria4s.{functions => F}

trait predicates {

  implicit class CriteriaPredImplicit[T <: CriteriaTag, L](c: Ref[T, L]) {
    def lt[R](
        other: Ref[T, R]
    )(implicit H: LT[T], showL: Show[L, T], showR: Show[R, T]): Criteria[T] = F.lt(c, other)
    def gt[R](
        other: Ref[T, R]
    )(implicit H: GT[T], showL: Show[L, T], showR: Show[R, T]): Criteria[T] = F.gt(c, other)
    def leq[R](
        other: Ref[T, R]
    )(implicit H: LEQ[T], showL: Show[L, T], showR: Show[R, T]): Criteria[T] = F.leq(c, other)

    def geq[R](
        other: Ref[T, R]
    )(implicit H: GEQ[T], showL: Show[L, T], showR: Show[R, T]): Criteria[T] = F.geq(c, other)

    def ===[R](
        other: Ref[T, R]
    )(implicit H: EQ[T], showL: Show[L, T], showR: Show[R, T]): Criteria[T] = F.===(c, other)

    def =!=[R](
        other: Ref[T, R]
    )(implicit H: NEQ[T], showL: Show[L, T], showR: Show[R, T]): Criteria[T] = F.=!=(c, other)

    def like[R](
        other: Ref[T, R]
    )(implicit H: LIKE[T], showL: Show[L, T], showR: Show[R, T]): Criteria[T] = F.like(c, other)

    def in[R](
        other: Collection[T, R]
    )(implicit H: IN[T], showL: Show[L, T], showR: Show[Seq[R], T]): Criteria[T] = F.in(c, other)

    def notIn[R](
        other: Collection[T, R]
    )(implicit H: NOTIN[T], showL: Show[L, T], showR: Show[Seq[R], T]): Criteria[T] = F.notIn(c, other)

    def isNull(implicit H: ISNULL[T], show: Show[L, T]): Criteria[T] = F.isNull(c)

    def isNotNull(implicit H: ISNOTNULL[T], show: Show[L, T]): Criteria[T] = F.isNotNull(c)

    def between[R](
        other: Ref.Range[T, R]
    )(implicit H: BETWEEN[T], showL: Show[L, T], showR: Show[(R, R), T]): Criteria[T] =
      F.between(c, other)

    def notBetween[R](
        other: Ref.Range[T, R]
    )(implicit H: NOTBETWEEN[T], showL: Show[L, T], showR: Show[(R, R), T]): Criteria[T] =
      F.notBetween(c, other)
  }

}

object predicates extends predicates
