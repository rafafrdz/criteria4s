package io.github.rafafrdz.criterial.functions

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.core.PredOp._
import io.github.rafafrdz.criterial.core.Ref.{Bool, Col, Value}
import io.github.rafafrdz.criterial.core.{Criterial, Ref}

private[functions] trait predicates {

  def lit[T <: CriterialTag, V](v: V): Value[V, T] = Ref.value(v)

  def bool[T <: CriterialTag](v: Boolean): Bool[T] = Ref.bool(v)

  private[criterial] def __[T <: CriterialTag]: Value[Nothing, T] = Ref.nothing[T]

  def col[T <: CriterialTag](ref: String): Col[T] = Ref.col(ref)

//  private def array_[T <: CriterialTag: ARRAY](values: Criterial[T]*): Criterial[T] = pred[T, ARRAY[T]](values: _*)
//
//  def array[T <: CriterialTag: ARRAY, V](values: V*): Criterial[T] = array_(values.map(lit[T, V]): _*)
//
  def lt[T <: CriterialTag: LT](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, LT[T]](cr1, cr2)

  def gt[T <: CriterialTag: GT](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, GT[T]](cr1, cr2)

  def ===[T <: CriterialTag: EQ](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, EQ[T]](cr1, cr2)

  def =!=[T <: CriterialTag: NEQ](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, NEQ[T]](cr1, cr2)

  def neq[T <: CriterialTag: NEQ](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, NEQ[T]](cr1, cr2)

  def geq[T <: CriterialTag: GEQ](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, GEQ[T]](cr1, cr2)

  def leq[T <: CriterialTag: LEQ](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, LEQ[T]](cr1, cr2)

  def like[T <: CriterialTag: LIKE](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, LIKE[T]](cr1, cr2)

  def in[T <: CriterialTag: IN](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, IN[T]](cr1, cr2)

  def notin[T <: CriterialTag: NOTIN](cr1: Ref[T], cr2: Ref[T]): Criterial[T] =
    pred[T, NOTIN[T]](cr1, cr2)

  def isNull[T <: CriterialTag: ISNULL](cr1: Ref[T]): Criterial[T] =
    pred[T, ISNULL[T]](cr1, __)

  def isNotNull[T <: CriterialTag: ISNOTNULL](cr1: Ref[T]): Criterial[T] =
    pred[T, ISNOTNULL[T]](cr1, __)

  def between[T <: CriterialTag: BETWEEN](
                                           cr1: Ref[T],
                                           cr2: Ref[T]
  ): Criterial[T] =
    pred[T, BETWEEN[T]](cr1, cr2)

  def notBetween[T <: CriterialTag: NOTBETWEEN](
                                                 cr1: Ref[T],
                                                 cr2: Ref[T]
  ): Criterial[T] =
    pred[T, NOTBETWEEN[T]](cr1, cr2)
}

object predicates extends predicates
