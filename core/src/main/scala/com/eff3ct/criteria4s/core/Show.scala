package com.eff3ct.criteria4s.core

trait Show[-V, D <: CriteriaTag] {
  def show(v: V): String
}

object Show {
  def create[V, D <: CriteriaTag](f: V => String): Show[V, D] = (v: V) => f(v)

  implicit def defaultStringShow[D <: CriteriaTag]: Show[String, D]      = identity
  implicit def defaultIntShow[V <: AnyVal, D <: CriteriaTag]: Show[V, D] = create(_.toString)
}
