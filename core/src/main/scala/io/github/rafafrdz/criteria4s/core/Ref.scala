package io.github.rafafrdz.criteria4s.core

sealed trait Ref[D <: CriteriaTag] {
  def ref: Criteria[D]

  override def toString: String = ref.value
}

object Ref {

  trait Value[+V, D <: CriteriaTag] extends Ref[D]

  trait Collection[V, D <: CriteriaTag] extends Value[Seq[V], D]

  trait Col[D <: CriteriaTag] extends Ref[D]

  trait Bool[D <: CriteriaTag] extends Value[Boolean, D] with Criteria[D] {
    self =>

    override def value: String = ref.value

    override def toString: String = value
  }

  private[criteria4s] def nothing[T <: CriteriaTag]: Value[Nothing, T] =
    new Value[Nothing, T] {
      override def ref: Criteria[T] = Criteria.pure("")
    }
  private[criteria4s] def value[V, D <: CriteriaTag](v: V): Value[V, D] =
    new Value[V, D] {
      override def ref: Criteria[D] = Criteria.pure(v.toString)
    }

  private[criteria4s] def col[D <: CriteriaTag](v: String): Col[D] = new Col[D] {
    override def ref: Criteria[D] = Criteria.pure(v)
  }

  private[criteria4s] def bool[D <: CriteriaTag](v: Boolean): Bool[D] =
    new Bool[D] {
      override def ref: Criteria[D] = Criteria.pure(v.toString)
    }

}
