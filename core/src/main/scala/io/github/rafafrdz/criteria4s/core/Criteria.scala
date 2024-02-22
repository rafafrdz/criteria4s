package io.github.rafafrdz.criteria4s.core


trait Criteria[T <: CriteriaTag] {
  def value: String

  override def toString: String = value
}

object Criteria {
  def pure[T <: CriteriaTag](v: String): Criteria[T] = new Criteria[T] {

    override def value: String = v
  }
  trait CriteriaTag
}
