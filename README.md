# Criterial DSL

## Formal Definition of Criterial Expressions

The Criterial DSL is a simple language to define criterial expressions for different datastores. The formal definition
of the Criterial DSL is as follows:

```text
Criterial   := ConjOp Criterial Criterial | PredOp Ref Ref | Value<Boolean>
RefC        := Value<T> | Col
```

Where:

- `Criterial` is the main expression of the DSL
- `ConjOp` is the conjunction operator expression
- `PredOp` is the predicate operator expression
- `Ref` is a reference to a value or a column
- `Value<T>` is a value expression of a certain type `T`
- `Col` is a column expression

## Examples

Here, we will show some examples of how to use the Criterial DSL.

```scala
import io.github.rafafrdz.criterial.core._
import io.github.rafafrdz.criterial.examples.datastores._
import io.github.rafafrdz.criterial.extensions._
import io.github.rafafrdz.criterial.functions._

def ageCriterial[T <: CriterialTag : GT : LT : AND]: Criterial[T] =
  (col[T]("age") gt lit(18)) and (col[T]("age") lt lit(65))

def expr[T <: CriterialTag : LEQ : EQ : AND : OR]: Criterial[T] =
  (col[T]("a") leq lit(3)) and (col[T]("b") leq lit(4)) or (col[T]("c") === lit("c"))

def expr2[T <: CriterialTag : EQ](fieldName: String, id: UUID): Criterial[T] =
  col[T](fieldName) === lit(id.toString)
```

And then we can use the `ageCriterial`, `expr` and `expr2` functions to generate criterial expressions for different
datastores:

```scala
ageCriterial[WeirdDatastore]
// res: {left: {left: age, opt: >, right: 18 }, opt: AND, right: {left: age, opt: <, right: 65 } }

expr[MySQL]
// res: (((a <<< 3) AND (b <<< 4)) OR (c = c))

expr2[Postgres]("USER_ID", UUID.randomUUID())
// res: (USER_ID = 7c4f9bd3-45ed-4eca-9b21-eafe73d75cc8)
```

Or maybe we can use the Criteria DSL inline:

```scala
(col[WeirdDatastore]("a") leq lit(3)) and (col[WeirdDatastore]("b") leq lit(4)) or (col[WeirdDatastore]("c") === lit("c"))
// res: {left: {left: {left: a, opt: <=, right: 3 }, opt: AND, right: {left: b, opt: <=, right: 4 } }, opt: OR, right: {left: c, opt: =, right: c } }
```

## Todo Features

- [x] Add a formal definition of the Criterial DSL
- [ ] Add formal definition for Collection Values
- [ ] Add traits for semantic of RefC (both `ValueC<T>` and `ColC`)
- [ ] Complete SQL predicate expressions
- [ ] Define conjunction and predicates operation methods by using symbols
- [ ] Upload the artifact to Maven Central Repository
