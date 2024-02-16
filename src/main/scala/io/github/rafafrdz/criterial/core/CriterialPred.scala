package io.github.rafafrdz.criterial.core

import io.github.rafafrdz.criterial.builder.Builder
import io.github.rafafrdz.criterial.core.Criterial.CriterialTag
import io.github.rafafrdz.criterial.functions._

trait CriterialPred[T <: CriterialTag] extends CriterialEval[T]

object CriterialPred {

  trait GT[T <: CriterialTag] extends CriterialPred[T]

  trait LT[T <: CriterialTag] extends CriterialPred[T]

  trait EQ[T <: CriterialTag] extends CriterialPred[T]

  trait NEQ[T <: CriterialTag] extends CriterialPred[T]

  trait GEQ[T <: CriterialTag] extends CriterialPred[T]

  trait LEQ[T <: CriterialTag] extends CriterialPred[T]

  trait LIKE[T <: CriterialTag] extends CriterialPred[T]

  trait IN[T <: CriterialTag] extends CriterialPred[T]

  trait NOTIN[T <: CriterialTag] extends CriterialPred[T]

  trait ISNULL[T <: CriterialTag] extends CriterialPred[T]

  trait ISNOTNULL[T <: CriterialTag] extends CriterialPred[T]

  trait BETWEEN[T <: CriterialTag] extends CriterialPred[T]

  trait NOTBETWEEN[T <: CriterialTag] extends CriterialPred[T]

  trait ARRAY[T <: CriterialTag] extends CriterialCollection[T]

  implicit val eqBuilder: Builder[EQ] = new Builder[EQ] {
    override def build[T <: CriterialTag](F: (String, String) => String): EQ[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val neqBuilder: Builder[NEQ] = new Builder[NEQ] {
    override def build[T <: CriterialTag](F: (String, String) => String): NEQ[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val leqBuilder: Builder[LEQ] = new Builder[LEQ] {
    override def build[T <: CriterialTag](F: (String, String) => String): LEQ[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val geqBuilder: Builder[GEQ] = new Builder[GEQ] {
    override def build[T <: CriterialTag](F: (String, String) => String): GEQ[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }
  implicit val ltBuilder: Builder[LT] = new Builder[LT] {
    override def build[T <: CriterialTag](F: (String, String) => String): LT[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val gtBuilder: Builder[GT] = new Builder[GT] {
    override def build[T <: CriterialTag](F: (String, String) => String): GT[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val likeBuilder: Builder[LIKE] = new Builder[LIKE] {
    override def build[T <: CriterialTag](F: (String, String) => String): LIKE[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val inBuilder: Builder[IN] = new Builder[IN] {
    override def build[T <: CriterialTag](F: (String, String) => String): IN[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val notinBuilder: Builder[NOTIN] = new Builder[NOTIN] {
    override def build[T <: CriterialTag](F: (String, String) => String): NOTIN[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val isnullBuilder: Builder[ISNULL] = new Builder[ISNULL] {
    override def build[T <: CriterialTag](F: (String, String) => String): ISNULL[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val isnotnullBuilder: Builder[ISNOTNULL] = new Builder[ISNOTNULL] {
    override def build[T <: CriterialTag](F: (String, String) => String): ISNOTNULL[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val betweenBuilder: Builder[BETWEEN] = new Builder[BETWEEN] {
    override def build[T <: CriterialTag](F: (String, String) => String): BETWEEN[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

  implicit val notbetweenBuilder: Builder[NOTBETWEEN] = new Builder[NOTBETWEEN] {
    override def build[T <: CriterialTag](F: (String, String) => String): NOTBETWEEN[T] =
      (cr1: Criterial[T], cr2: Criterial[T]) => lit(F(cr1.value, cr2.value))
  }

}
