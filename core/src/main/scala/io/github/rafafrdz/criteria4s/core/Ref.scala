package io.github.rafafrdz.criteria4s.core

sealed trait Ref[D <: CriteriaTag, V] {
  def asString(implicit show: Show[V, D]): String
}

object Ref {

  trait Value[D <: CriteriaTag, V]      extends Ref[D, V]
  trait Collection[D <: CriteriaTag, V] extends Ref[D, Seq[V]]
  trait Col[D <: CriteriaTag]           extends Ref[D, Column]
  trait Bool[D <: CriteriaTag]          extends Value[D, Boolean] with Criteria[D]
  trait Range[D <: CriteriaTag, V]      extends Ref[D, (V, V)]

  private[criteria4s] def nothing[T <: CriteriaTag]: Value[T, Nothing] =
    (_: Show[Nothing, T]) => ""

  private[criteria4s] def value[V, D <: CriteriaTag](v: V): Value[D, V] =
    (show: Show[V, D]) => show.show(v)

  private[criteria4s] def col[D <: CriteriaTag](v: Column): Col[D] =
    (show: Show[Column, D]) => show.show(v)

  private[criteria4s] def bool[D <: CriteriaTag](v: Boolean): Bool[D] =
    new Bool[D] {
      override def value: String                                     = v.toString
      override def asString(implicit show: Show[Boolean, D]): String = v.toString
    }

  private[criteria4s] def array[V, D <: CriteriaTag](vs: V*): Collection[D, V] =
    (show: Show[Seq[V], D]) => show.show(vs)

  private[criteria4s] def range[V, D <: CriteriaTag](left: V, right: V): Range[D, V] =
    (show: Show[(V, V), D]) => show.show((left, right))

}

case class Column(colName: String) extends AnyVal
