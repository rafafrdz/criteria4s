package io.github.rafafrdz.criteria4s.functions

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.PredOp._
import io.github.rafafrdz.criteria4s.core.Ref.{Bool, Col, Value}
import io.github.rafafrdz.criteria4s.core.{Criteria, Ref}

private[functions] trait predicates {

  def lit[T <: CriteriaTag, V](v: V): Value[V, T] = Ref.value(v)

  def bool[T <: CriteriaTag](v: Boolean): Bool[T] = Ref.bool(v)

  private[criteria4s] def __[T <: CriteriaTag]: Value[Nothing, T] = Ref.nothing[T]

  def col[T <: CriteriaTag](ref: String): Col[T] = Ref.col(ref)

//  private def array_[T <: CriteriaTag: ARRAY](values: Criteria[T]*): Criteria[T] = pred[T, ARRAY[T]](values: _*)
//
//  def array[T <: CriteriaTag: ARRAY, V](values: V*): Criteria[T] = array_(values.map(lit[T, V]): _*)
//
  def lt[T <: CriteriaTag: LT](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, LT[T]](cr1, cr2)

  def gt[T <: CriteriaTag: GT](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, GT[T]](cr1, cr2)

  def ===[T <: CriteriaTag: EQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, EQ[T]](cr1, cr2)

  def =!=[T <: CriteriaTag: NEQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, NEQ[T]](cr1, cr2)

  def neq[T <: CriteriaTag: NEQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, NEQ[T]](cr1, cr2)

  def geq[T <: CriteriaTag: GEQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, GEQ[T]](cr1, cr2)

  def leq[T <: CriteriaTag: LEQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, LEQ[T]](cr1, cr2)

  def like[T <: CriteriaTag: LIKE](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, LIKE[T]](cr1, cr2)

  def in[T <: CriteriaTag: IN](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, IN[T]](cr1, cr2)

  def notin[T <: CriteriaTag: NOTIN](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    pred[T, NOTIN[T]](cr1, cr2)

  def isNull[T <: CriteriaTag: ISNULL](cr1: Ref[T]): Criteria[T] =
    pred[T, ISNULL[T]](cr1, __)

  def isNotNull[T <: CriteriaTag: ISNOTNULL](cr1: Ref[T]): Criteria[T] =
    pred[T, ISNOTNULL[T]](cr1, __)

  def between[T <: CriteriaTag: BETWEEN](
                                           cr1: Ref[T],
                                           cr2: Ref[T]
  ): Criteria[T] =
    pred[T, BETWEEN[T]](cr1, cr2)

  def notBetween[T <: CriteriaTag: NOTBETWEEN](
                                                 cr1: Ref[T],
                                                 cr2: Ref[T]
  ): Criteria[T] =
    pred[T, NOTBETWEEN[T]](cr1, cr2)
}

object predicates extends predicates
