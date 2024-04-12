package io.github.rafafrdz.criteria4s.functions

import io.github.rafafrdz.criteria4s.core.Criteria.CriteriaTag
import io.github.rafafrdz.criteria4s.core.PredicateBinary._
import io.github.rafafrdz.criteria4s.core.PredicateUnary._
import io.github.rafafrdz.criteria4s.core.Ref.{Bool, Col, Value}
import io.github.rafafrdz.criteria4s.core.{Criteria, Ref, Sym}

private[functions] trait predicates {

  def lit[T <: CriteriaTag: Sym, V](v: V): Value[V, T] =
    implicitly[Sym[T]].value[V](Ref.value(v))

  def bool[T <: CriteriaTag: Sym](v: Boolean): Bool[T] =
    implicitly[Sym[T]].bool(Ref.bool(v))

  private[criteria4s] def __[T <: CriteriaTag]: Value[Nothing, T] = Ref.nothing[T]

  def col[T <: CriteriaTag: Sym](ref: String): Col[T] = implicitly[Sym[T]].col(Ref.col(ref))

//  private def array_[T <: CriteriaTag: ARRAY](values: Criteria[T]*): Criteria[T] = pred[T, ARRAY[T]](values: _*)
//
//  def array[T <: CriteriaTag: ARRAY, V](values: V*): Criteria[T] = array_(values.map(lit[T, V]): _*)
//
  def lt[T <: CriteriaTag: LT](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, LT[T]](cr1, cr2)

  def gt[T <: CriteriaTag: GT](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, GT[T]](cr1, cr2)

  def ===[T <: CriteriaTag: EQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, EQ[T]](cr1, cr2)

  def =!=[T <: CriteriaTag: NEQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, NEQ[T]](cr1, cr2)

  def neq[T <: CriteriaTag: NEQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, NEQ[T]](cr1, cr2)

  def geq[T <: CriteriaTag: GEQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, GEQ[T]](cr1, cr2)

  def leq[T <: CriteriaTag: LEQ](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, LEQ[T]](cr1, cr2)

  def like[T <: CriteriaTag: LIKE](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, LIKE[T]](cr1, cr2)

  def in[T <: CriteriaTag: IN](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, IN[T]](cr1, cr2)

  def notin[T <: CriteriaTag: NOTIN](cr1: Ref[T], cr2: Ref[T]): Criteria[T] =
    predBinary[T, NOTIN[T]](cr1, cr2)

  def isNull[T <: CriteriaTag: ISNULL](cr1: Ref[T]): Criteria[T] =
    predUnary[T, ISNULL[T]](cr1)

  def isNotNull[T <: CriteriaTag: ISNOTNULL](cr1: Ref[T]): Criteria[T] =
    predUnary[T, ISNOTNULL[T]](cr1)

  def between[T <: CriteriaTag: BETWEEN](
      cr1: Ref[T],
      cr2: Ref[T]
  ): Criteria[T] =
    predBinary[T, BETWEEN[T]](cr1, cr2)

  def notBetween[T <: CriteriaTag: NOTBETWEEN](
      cr1: Ref[T],
      cr2: Ref[T]
  ): Criteria[T] =
    predBinary[T, NOTBETWEEN[T]](cr1, cr2)
}

object predicates extends predicates
