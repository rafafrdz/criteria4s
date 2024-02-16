package io.github.rafafrdz.criterial.core

import io.github.rafafrdz.criterial.core.Criterial.CriterialTag

trait Criterial[T <: CriterialTag] {
  def value: String

  override def toString: String = value
}

object Criterial {
  def value[T <: CriterialTag](v: String): Criterial[T] = new Criterial[T] {

    override def value: String = v
  }
  trait CriterialTag
}
