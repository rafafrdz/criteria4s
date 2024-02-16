package io.github.rafafrdz.criterial.functions

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.CriterialPredOp._
import io.github.rafafrdz.criterial.core.CriterialRef.{CriterialBool, CriterialCol, CriterialValue}
import io.github.rafafrdz.criterial.core.{Criterial, CriterialRef}

private[functions] trait predicates {

  def lit[T <: CriterialTag, V](v: V): CriterialValue[V, T] = CriterialRef.value(v)

  def bool[T <: CriterialTag](v: Boolean): CriterialBool[T] = CriterialRef.bool(v)

  private[criterial] def __[T <: CriterialTag]: CriterialValue[Nothing, T] = CriterialRef.nothing[T]

  def col[T <: CriterialTag](ref: String): CriterialCol[T] = CriterialRef.col(ref)

//  private def array_[T <: CriterialTag: ARRAY](values: Criterial[T]*): Criterial[T] = pred[T, ARRAY[T]](values: _*)
//
//  def array[T <: CriterialTag: ARRAY, V](values: V*): Criterial[T] = array_(values.map(lit[T, V]): _*)
//
  def lt[T <: CriterialTag: LT](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, LT[T]](cr1, cr2)

  def gt[T <: CriterialTag: GT](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, GT[T]](cr1, cr2)

  def ===[T <: CriterialTag: EQ](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, EQ[T]](cr1, cr2)

  def =!=[T <: CriterialTag: NEQ](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, NEQ[T]](cr1, cr2)

  def neq[T <: CriterialTag: NEQ](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, NEQ[T]](cr1, cr2)

  def geq[T <: CriterialTag: GEQ](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, GEQ[T]](cr1, cr2)

  def leq[T <: CriterialTag: LEQ](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, LEQ[T]](cr1, cr2)

  def like[T <: CriterialTag: LIKE](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, LIKE[T]](cr1, cr2)

  def in[T <: CriterialTag: IN](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, IN[T]](cr1, cr2)

  def notin[T <: CriterialTag: NOTIN](cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T] =
    pred[T, NOTIN[T]](cr1, cr2)

  def isNull[T <: CriterialTag: ISNULL](cr1: CriterialRef[T]): Criterial[T] =
    pred[T, ISNULL[T]](cr1, __)

  def isNotNull[T <: CriterialTag: ISNOTNULL](cr1: CriterialRef[T]): Criterial[T] =
    pred[T, ISNOTNULL[T]](cr1, __)

  def between[T <: CriterialTag: BETWEEN](
      cr1: CriterialRef[T],
      cr2: CriterialRef[T]
  ): Criterial[T] =
    pred[T, BETWEEN[T]](cr1, cr2)

  def notBetween[T <: CriterialTag: NOTBETWEEN](
      cr1: CriterialRef[T],
      cr2: CriterialRef[T]
  ): Criterial[T] =
    pred[T, NOTBETWEEN[T]](cr1, cr2)
}

object predicates extends predicates
