package io.github.rafafrdz.criterial.functions

import io.github.rafafrdz.criterial.core.Criterial
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialPred._

private[functions] trait predicates {

  def lit[T <: CriterialTag, V](v: V): Criterial[T] = Criterial.value(v.toString)

  private[criterial] def __[T <: CriterialTag]: Criterial[T] = lit("")

  def col[T <: CriterialTag](ref: String): Criterial[T] = lit(ref)

  private def array_[T <: CriterialTag: ARRAY](values: Criterial[T]*): Criterial[T] = eval[T, ARRAY[T]](values: _*)

  def array[T <: CriterialTag: ARRAY, V](values: V*): Criterial[T] = array_(values.map(lit[T, V]): _*)

  def lt[T <: CriterialTag: LT](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, LT[T]](cr1, cr2)

  def gt[T <: CriterialTag: GT](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, GT[T]](cr1, cr2)

  def ===[T <: CriterialTag: EQ](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, EQ[T]](cr1, cr2)

  def =!=[T <: CriterialTag: NEQ](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, NEQ[T]](cr1, cr2)

  def neq[T <: CriterialTag: NEQ](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, NEQ[T]](cr1, cr2)

  def geq[T <: CriterialTag: GEQ](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, GEQ[T]](cr1, cr2)

  def leq[T <: CriterialTag: LEQ](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, LEQ[T]](cr1, cr2)

  def like[T <: CriterialTag: LIKE](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, LIKE[T]](cr1, cr2)

  def in[T <: CriterialTag: IN](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, IN[T]](cr1, cr2)

  def notin[T <: CriterialTag: NOTIN](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] = eval[T, NOTIN[T]](cr1, cr2)

  def isNull[T <: CriterialTag: ISNULL](cr1: Criterial[T]): Criterial[T] = eval[T, ISNULL[T]](cr1, __)

  def isNotNull[T <: CriterialTag: ISNOTNULL](cr1: Criterial[T]): Criterial[T] = eval[T, ISNOTNULL[T]](cr1, __)

  def between[T <: CriterialTag: BETWEEN](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] =
    eval[T, BETWEEN[T]](cr1, cr2)

  def notBetween[T <: CriterialTag: NOTBETWEEN](cr1: Criterial[T], cr2: Criterial[T]): Criterial[T] =
    eval[T, NOTBETWEEN[T]](cr1, cr2)
}

object predicates extends predicates
