package io.github.rafafrdz.criteria4s.functions

import io.github.rafafrdz.criteria4s.core.{Column, Criteria, CriteriaTag, Ref, Show}
import io.github.rafafrdz.criteria4s.core.PredicateBinary._
import io.github.rafafrdz.criteria4s.core.PredicateUnary._
import io.github.rafafrdz.criteria4s.core.Ref._

private[functions] trait predicates {

  def lit[T <: CriteriaTag, V](v: V): Value[T, V] =
    Ref.value(v)

  def bool[T <: CriteriaTag](v: Boolean): Bool[T] =
    Ref.bool(v)

  private[criteria4s] def __[T <: CriteriaTag]: Value[T, Nothing] = Ref.nothing[T]

  def col[T <: CriteriaTag](ref: String): Col[T] = Ref.col(Column(ref))

  def array[T <: CriteriaTag, V](vs: V*): Collection[T, V] = Ref.array(vs: _*)

  def range[T <: CriteriaTag, V](left: V, right: V): Ref.Range[T, V] = Ref.range(left, right)

  def lt[T <: CriteriaTag: LT, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, LT[T], L, R](cr1, cr2)

  def gt[T <: CriteriaTag: GT, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, GT[T], L, R](cr1, cr2)

  def ===[T <: CriteriaTag: EQ, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, EQ[T], L, R](cr1, cr2)

  def =!=[T <: CriteriaTag: NEQ, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, NEQ[T], L, R](cr1, cr2)

  def neq[T <: CriteriaTag: NEQ, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, NEQ[T], L, R](cr1, cr2)

  def geq[T <: CriteriaTag: GEQ, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, GEQ[T], L, R](cr1, cr2)

  def leq[T <: CriteriaTag: LEQ, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, LEQ[T], L, R](cr1, cr2)

  def like[T <: CriteriaTag: LIKE, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, LIKE[T], L, R](cr1, cr2)

  def in[T <: CriteriaTag: IN, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, IN[T], L, R](cr1, cr2)

  def notIn[T <: CriteriaTag: NOTIN, L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, NOTIN[T], L, R](cr1, cr2)

  def isNull[T <: CriteriaTag: ISNULL, V](cr1: Ref[T, V])(implicit show: Show[V, T]): Criteria[T] =
    pred[T, ISNULL[T], V](cr1)

  def isNotNull[T <: CriteriaTag: ISNOTNULL, V](cr1: Ref[T, V])(implicit
      show: Show[V, T]
  ): Criteria[T] =
    pred[T, ISNOTNULL[T], V](cr1)

  def between[T <: CriteriaTag: BETWEEN, L, R](
      cr1: Ref[T, L],
      cr2: Ref[T, R]
  )(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, BETWEEN[T], L, R](cr1, cr2)

  def notBetween[T <: CriteriaTag: NOTBETWEEN, L, R](
      cr1: Ref[T, L],
      cr2: Ref[T, R]
  )(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T] =
    pred[T, NOTBETWEEN[T], L, R](cr1, cr2)
}

object predicates extends predicates
