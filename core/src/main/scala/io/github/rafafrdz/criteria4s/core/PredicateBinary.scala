package io.github.rafafrdz.criteria4s.core

import io.github.rafafrdz.criteria4s.core.Criteria._
import io.github.rafafrdz.criteria4s.instances.builder.{Builder1, Builder2}

trait Predicate[T <: CriteriaTag]

trait PredicateUnary[T <: CriteriaTag] extends Predicate[T] {
  def eval(ref: Ref[T]): Criteria[T]
}

trait PredicateBinary[T <: CriteriaTag] extends Predicate[T] {
  def eval(cr1: Ref[T], cr2: Ref[T]): Criteria[T]
}

object PredicateUnary {
  trait ISNULL[T <: CriteriaTag] extends PredicateUnary[T]

  trait ISNOTNULL[T <: CriteriaTag] extends PredicateUnary[T]

  implicit val isnullBuilder: Builder1[ISNULL] = new Builder1[ISNULL] {
    override def build[T <: CriteriaTag](F: String => String): ISNULL[T] =
      (cr1: Ref[T]) => pure(F(cr1.ref.value))
  }

  implicit val isnotnullBuilder: Builder1[ISNOTNULL] = new Builder1[ISNOTNULL] {
    override def build[T <: CriteriaTag](F: String => String): ISNOTNULL[T] =
      (cr1: Ref[T]) => pure(F(cr1.ref.value))
  }
}

object PredicateBinary {

  trait GT[T <: CriteriaTag] extends PredicateBinary[T]

  trait LT[T <: CriteriaTag] extends PredicateBinary[T]

  trait EQ[T <: CriteriaTag] extends PredicateBinary[T]

  trait NEQ[T <: CriteriaTag] extends PredicateBinary[T]

  trait GEQ[T <: CriteriaTag] extends PredicateBinary[T]

  trait LEQ[T <: CriteriaTag] extends PredicateBinary[T]

  trait LIKE[T <: CriteriaTag] extends PredicateBinary[T]

  trait IN[T <: CriteriaTag] extends PredicateBinary[T]

  trait NOTIN[T <: CriteriaTag] extends PredicateBinary[T]

  trait BETWEEN[T <: CriteriaTag] extends PredicateBinary[T]

  trait NOTBETWEEN[T <: CriteriaTag] extends PredicateBinary[T]

  implicit val gtBuilder: Builder2[GT] = new Builder2[GT] {
    override def build[T <: CriteriaTag](F: (String, String) => String): GT[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val ltBuilder: Builder2[LT] = new Builder2[LT] {
    override def build[T <: CriteriaTag](F: (String, String) => String): LT[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val eqBuilder: Builder2[EQ] = new Builder2[EQ] {
    override def build[T <: CriteriaTag](F: (String, String) => String): EQ[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val neqBuilder: Builder2[NEQ] = new Builder2[NEQ] {
    override def build[T <: CriteriaTag](F: (String, String) => String): NEQ[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val geqBuilder: Builder2[GEQ] = new Builder2[GEQ] {
    override def build[T <: CriteriaTag](F: (String, String) => String): GEQ[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val leqBuilder: Builder2[LEQ] = new Builder2[LEQ] {
    override def build[T <: CriteriaTag](F: (String, String) => String): LEQ[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val likeBuilder: Builder2[LIKE] = new Builder2[LIKE] {
    override def build[T <: CriteriaTag](F: (String, String) => String): LIKE[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val inBuilder: Builder2[IN] = new Builder2[IN] {
    override def build[T <: CriteriaTag](F: (String, String) => String): IN[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val notinBuilder: Builder2[NOTIN] = new Builder2[NOTIN] {
    override def build[T <: CriteriaTag](F: (String, String) => String): NOTIN[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val betweenBuilder: Builder2[BETWEEN] = new Builder2[BETWEEN] {
    override def build[T <: CriteriaTag](F: (String, String) => String): BETWEEN[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

  implicit val notbetweenBuilder: Builder2[NOTBETWEEN] = new Builder2[NOTBETWEEN] {
    override def build[T <: CriteriaTag](F: (String, String) => String): NOTBETWEEN[T] =
      (cr1: Ref[T], cr2: Ref[T]) => pure(F(cr1.ref.value, cr2.ref.value))
  }

}
