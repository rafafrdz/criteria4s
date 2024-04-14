package io.github.rafafrdz.criteria4s.core

trait Show[-V, D <: CriteriaTag] {
  def show(v: V): String
}

object Show {
  def create[D <: CriteriaTag]: ShowBuilder[D] = new ShowBuilder[D]

  private[core] final class ShowBuilder[D <: CriteriaTag] {
    def apply[V](f: V => String): Show[V, D] = (v: V) => f(v)
  }

  type ShowColumn[D <: CriteriaTag] = Show[Column, D]

  implicit def defaultStringShow[D <: CriteriaTag]: Show[String, D] = identity
  implicit def defaultIntShow[D <: CriteriaTag]: Show[Int, D] = create(_.toString)
}