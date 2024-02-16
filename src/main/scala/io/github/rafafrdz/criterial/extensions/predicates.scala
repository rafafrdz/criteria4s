package io.github.rafafrdz.criterial.extensions

import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialPred._
import io.github.rafafrdz.criterial.{functions => F}

trait predicates {

  implicit class CriterialPredImplicit[T <: CriterialTag](c: Criterial[T]) {
    def lt[M <: CriterialTag: LT](other: Criterial[M]): Criterial[M] = F.lt(c, other)
    def gt[M <: CriterialTag: GT](other: Criterial[M]): Criterial[M] = F.gt(c, other)
    def leq[M <: CriterialTag: LEQ](other: Criterial[M]): Criterial[M] = F.leq(c, other)
    def geq[M <: CriterialTag: GEQ](other: Criterial[M]): Criterial[M] = F.geq(c, other)
    def ===[M <: CriterialTag: EQ](other: Criterial[M]): Criterial[M] = F.===(c, other)
    def =!=[M <: CriterialTag: NEQ](other: Criterial[M]): Criterial[M] = F.=!=(c, other)
    def like[M <: CriterialTag: LIKE](other: Criterial[M]): Criterial[M] = F.like(c, other)
    def like[M <: CriterialTag: LIKE](other: Criterial[M]): Criterial[M] = F.like(c, other)
    def in[M <: CriterialTag: IN](other: Criterial[M]): Criterial[M] = F.in(c, other)
    def notin[M <: CriterialTag: NOTIN](other: Criterial[M]): Criterial[M] = F.notin(c, other)
    def isNull[M <: CriterialTag: ISNULL]: Criterial[M] = F.isNull(c)
    def isNotNull[M <: CriterialTag: ISNOTNULL]: Criterial[M] = F.isNotNull(c)
    def between[M <: CriterialTag: BETWEEN](other: Criterial[M]): Criterial[M] = F.between(c, other)
    def notBetween[M <: CriterialTag: NOTBETWEEN](other: Criterial[M]): Criterial[M] = F.notBetween(c, other)

  }

}

object predicates extends predicates
