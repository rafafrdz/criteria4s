package io.github.rafafrdz.criterial.extensions

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialPredOp._
import io.github.rafafrdz.criterial.core.{Criterial, CriterialRef}
import io.github.rafafrdz.criterial.{functions => F}

trait predicates {

  implicit class CriterialPredImplicit[T <: CriterialTag](c: CriterialRef[T]) {
    def lt(other: CriterialRef[T])(implicit H: LT[T]): Criterial[T]   = F.lt(c, other)
    def gt(other: CriterialRef[T])(implicit H: GT[T]): Criterial[T]   = F.gt(c, other)
    def leq(other: CriterialRef[T])(implicit H: LEQ[T]): Criterial[T] = F.leq(c, other)

    def geq(other: CriterialRef[T])(implicit H: GEQ[T]): Criterial[T] = F.geq(c, other)

    def ===(other: CriterialRef[T])(implicit H: EQ[T]): Criterial[T] = F.===(c, other)

    def =!=(other: CriterialRef[T])(implicit H: NEQ[T]): Criterial[T] = F.=!=(c, other)

    def like(other: CriterialRef[T])(implicit H: LIKE[T]): Criterial[T] = F.like(c, other)

    def in(other: CriterialRef[T])(implicit H: IN[T]): Criterial[T] = F.in(c, other)

    def notin(other: CriterialRef[T])(implicit H: NOTIN[T]): Criterial[T] = F.notin(c, other)

    def isNull(implicit H: ISNULL[T]): Criterial[T] = F.isNull(c)

    def isNotNull(implicit H: ISNOTNULL[T]): Criterial[T] = F.isNotNull(c)

    def between(other: CriterialRef[T])(implicit H: BETWEEN[T]): Criterial[T] = F.between(c, other)

    def notBetween(other: CriterialRef[T])(implicit H: NOTBETWEEN[T]): Criterial[T] =
      F.notBetween(c, other)

  }

}

object predicates extends predicates
