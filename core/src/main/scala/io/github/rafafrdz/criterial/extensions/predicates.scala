package io.github.rafafrdz.criterial.extensions

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.PredOp._
import io.github.rafafrdz.criterial.core.{Criterial, Ref}
import io.github.rafafrdz.criterial.{functions => F}

trait predicates {

//  implicit def toCriterialValue[V, D <: CriterialTag](v: V): CriterialRef.CriterialValue[V, D] =
//    CriterialRef.value(v)
  implicit class CriterialPredImplicit[T <: CriterialTag](c: Ref[T]) {
    def lt(other: Ref[T])(implicit H: LT[T]): Criterial[T]   = F.lt(c, other)
    def gt(other: Ref[T])(implicit H: GT[T]): Criterial[T]   = F.gt(c, other)
    def leq(other: Ref[T])(implicit H: LEQ[T]): Criterial[T] = F.leq(c, other)

    def geq(other: Ref[T])(implicit H: GEQ[T]): Criterial[T] = F.geq(c, other)

    def ===(other: Ref[T])(implicit H: EQ[T]): Criterial[T] = F.===(c, other)

    def =!=(other: Ref[T])(implicit H: NEQ[T]): Criterial[T] = F.=!=(c, other)

    def like(other: Ref[T])(implicit H: LIKE[T]): Criterial[T] = F.like(c, other)

    def in(other: Ref[T])(implicit H: IN[T]): Criterial[T] = F.in(c, other)

    def notin(other: Ref[T])(implicit H: NOTIN[T]): Criterial[T] = F.notin(c, other)

    def isNull(implicit H: ISNULL[T]): Criterial[T] = F.isNull(c)

    def isNotNull(implicit H: ISNOTNULL[T]): Criterial[T] = F.isNotNull(c)

    def between(other: Ref[T])(implicit H: BETWEEN[T]): Criterial[T] = F.between(c, other)

    def notBetween(other: Ref[T])(implicit H: NOTBETWEEN[T]): Criterial[T] =
      F.notBetween(c, other)

  }

}

object predicates extends predicates
