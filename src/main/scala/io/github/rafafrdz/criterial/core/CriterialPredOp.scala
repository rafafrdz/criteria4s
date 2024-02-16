package io.github.rafafrdz.criterial.core

import io.github.rafafrdz.criterial.core.Criterial._
import io.github.rafafrdz.criterial.instances.builder.{Builder1, Builder2}

trait CriterialPredOp[T <: CriterialTag] {
  def eval(cr1: CriterialRef[T], cr2: CriterialRef[T]): Criterial[T]
}

object CriterialPredOp {

  trait GT[T <: CriterialTag] extends CriterialPredOp[T]

  trait LT[T <: CriterialTag] extends CriterialPredOp[T]

  trait EQ[T <: CriterialTag] extends CriterialPredOp[T]

  trait NEQ[T <: CriterialTag] extends CriterialPredOp[T]

  trait GEQ[T <: CriterialTag] extends CriterialPredOp[T]

  trait LEQ[T <: CriterialTag] extends CriterialPredOp[T]

  trait LIKE[T <: CriterialTag] extends CriterialPredOp[T]

  trait IN[T <: CriterialTag] extends CriterialPredOp[T]

  trait NOTIN[T <: CriterialTag] extends CriterialPredOp[T]

  trait ISNULL[T <: CriterialTag] extends CriterialPredOp[T]

  trait ISNOTNULL[T <: CriterialTag] extends CriterialPredOp[T]

  trait BETWEEN[T <: CriterialTag] extends CriterialPredOp[T]

  trait NOTBETWEEN[T <: CriterialTag] extends CriterialPredOp[T]

  implicit val gtBuilder: Builder2[GT] = new Builder2[GT] {
    override def build[T <: CriterialTag](F: (String, String) => String): GT[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val ltBuilder: Builder2[LT] = new Builder2[LT] {
    override def build[T <: CriterialTag](F: (String, String) => String): LT[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val eqBuilder: Builder2[EQ] = new Builder2[EQ] {
    override def build[T <: CriterialTag](F: (String, String) => String): EQ[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val neqBuilder: Builder2[NEQ] = new Builder2[NEQ] {
    override def build[T <: CriterialTag](F: (String, String) => String): NEQ[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val geqBuilder: Builder2[GEQ] = new Builder2[GEQ] {
    override def build[T <: CriterialTag](F: (String, String) => String): GEQ[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val leqBuilder: Builder2[LEQ] = new Builder2[LEQ] {
    override def build[T <: CriterialTag](F: (String, String) => String): LEQ[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val likeBuilder: Builder2[LIKE] = new Builder2[LIKE] {
    override def build[T <: CriterialTag](F: (String, String) => String): LIKE[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val inBuilder: Builder2[IN] = new Builder2[IN] {
    override def build[T <: CriterialTag](F: (String, String) => String): IN[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val notinBuilder: Builder2[NOTIN] = new Builder2[NOTIN] {
    override def build[T <: CriterialTag](F: (String, String) => String): NOTIN[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val isnullBuilder: Builder1[ISNULL] = new Builder1[ISNULL] {
    override def build[T <: CriterialTag](F: String => String): ISNULL[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value))
  }

  implicit val isnotnullBuilder: Builder1[ISNOTNULL] = new Builder1[ISNOTNULL] {
    override def build[T <: CriterialTag](F: String => String): ISNOTNULL[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value))
  }

  implicit val betweenBuilder: Builder2[BETWEEN] = new Builder2[BETWEEN] {
    override def build[T <: CriterialTag](F: (String, String) => String): BETWEEN[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val notbetweenBuilder: Builder2[NOTBETWEEN] = new Builder2[NOTBETWEEN] {
    override def build[T <: CriterialTag](F: (String, String) => String): NOTBETWEEN[T] =
      (cr1: CriterialRef[T], cr2: CriterialRef[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

}
