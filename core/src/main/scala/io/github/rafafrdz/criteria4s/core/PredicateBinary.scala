package io.github.rafafrdz.criteria4s.core

import io.github.rafafrdz.criteria4s.core.Criteria._
import io.github.rafafrdz.criteria4s.instances.builder.{Builder1, Builder2}

trait Predicate[T <: CriteriaTag]

trait PredicateUnary[T <: CriteriaTag] extends Predicate[T] {
  def eval[V](ref: Ref[T, V])(implicit show: Show[V, T]): Criteria[T]
}

trait PredicateBinary[T <: CriteriaTag] extends Predicate[T] {
  def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
      showL: Show[L, T],
      showR: Show[R, T]
  ): Criteria[T]
}

object PredicateUnary {
  trait ISNULL[T <: CriteriaTag] extends PredicateUnary[T]

  trait ISNOTNULL[T <: CriteriaTag] extends PredicateUnary[T]

  implicit val isnullBuilder: Builder1[ISNULL] = new Builder1[ISNULL] {
    override def build[T <: CriteriaTag](F: String => String): ISNULL[T] = new ISNULL[T] {
      override def eval[V](ref: Ref[T, V])(implicit show: Show[V, T]): Criteria[T] = pure(
        F(ref.asString)
      )
    }
  }

  implicit val isnotnullBuilder: Builder1[ISNOTNULL] = new Builder1[ISNOTNULL] {
    override def build[T <: CriteriaTag](F: String => String): ISNOTNULL[T] = new ISNOTNULL[T] {
      override def eval[V](ref: Ref[T, V])(implicit show: Show[V, T]): Criteria[T] = pure(
        F(ref.asString)
      )
    }
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
    override def build[T <: CriteriaTag](
        F: (String, String) => String
    ): GT[T] = new GT[T] {
      override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
          showL: Show[L, T],
          showR: Show[R, T]
      ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
    }
  }

  implicit val ltBuilder: Builder2[LT] = new Builder2[LT] {
    override def build[T <: CriteriaTag](F: (String, String) => String): LT[T] = new LT[T] {
      override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
          showL: Show[L, T],
          showR: Show[R, T]
      ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
    }
  }

  implicit val eqBuilder: Builder2[EQ] = new Builder2[EQ] {
    override def build[T <: CriteriaTag](F: (String, String) => String): EQ[T] = new EQ[T] {
      override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
          showL: Show[L, T],
          showR: Show[R, T]
      ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
    }
  }

  implicit val neqBuilder: Builder2[NEQ] = new Builder2[NEQ] {
    override def build[T <: CriteriaTag](F: (String, String) => String): NEQ[T] = new NEQ[T] {
      override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
          showL: Show[L, T],
          showR: Show[R, T]
      ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
    }
  }

  implicit val geqBuilder: Builder2[GEQ] = new Builder2[GEQ] {
    override def build[T <: CriteriaTag](F: (String, String) => String): GEQ[T] = new GEQ[T] {
      override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
          showL: Show[L, T],
          showR: Show[R, T]
      ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
    }
  }

  implicit val leqBuilder: Builder2[LEQ] = new Builder2[LEQ] {
    override def build[T <: CriteriaTag](F: (String, String) => String): LEQ[T] = new LEQ[T] {
      override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
          showL: Show[L, T],
          showR: Show[R, T]
      ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
    }
  }

  implicit val likeBuilder: Builder2[LIKE] = new Builder2[LIKE] {
    override def build[T <: CriteriaTag](F: (String, String) => String): LIKE[T] = new LIKE[T] {
      override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
          showL: Show[L, T],
          showR: Show[R, T]
      ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
    }
  }

  implicit val inBuilder: Builder2[IN] = new Builder2[IN] {
    override def build[T <: CriteriaTag](F: (String, String) => String): IN[T] = new IN[T] {
      override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
          showL: Show[L, T],
          showR: Show[R, T]
      ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
    }
  }

  implicit val notinBuilder: Builder2[NOTIN] = new Builder2[NOTIN] {
    override def build[T <: CriteriaTag](F: (String, String) => String): NOTIN[T] = new NOTIN[T] {
      override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
          showL: Show[L, T],
          showR: Show[R, T]
      ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
    }
  }

  implicit val betweenBuilder: Builder2[BETWEEN] = new Builder2[BETWEEN] {
    override def build[T <: CriteriaTag](F: (String, String) => String): BETWEEN[T] =
      new BETWEEN[T] {
        override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
            showL: Show[L, T],
            showR: Show[R, T]
        ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
      }
  }

  implicit val notbetweenBuilder: Builder2[NOTBETWEEN] = new Builder2[NOTBETWEEN] {
    override def build[T <: CriteriaTag](F: (String, String) => String): NOTBETWEEN[T] =
      new NOTBETWEEN[T] {
        override def eval[L, R](cr1: Ref[T, L], cr2: Ref[T, R])(implicit
            showL: Show[L, T],
            showR: Show[R, T]
        ): Criteria[T] = pure(F(cr1.asString, cr2.asString))
      }
  }

}
