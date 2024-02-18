package io.github.rafafrdz.criterial.core


trait Criterial[T <: CriterialTag] {
  def value: String

  override def toString: String = value
}

object Criterial {
  def pure[T <: CriterialTag](v: String): Criterial[T] = new Criterial[T] {

    override def value: String = v
  }
  trait CriterialTag
}
