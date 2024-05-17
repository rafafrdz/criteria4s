![Sonatype Nexus (Releases)](https://img.shields.io/nexus/r/io.github.rafafrdz/criteria4s-core_2.13?server=https%3A%2F%2Fs01.oss.sonatype.org&style=flat-square&label=Sonatype&labelColor=%20&color=%2acf45%20%20) [![License](https://img.shields.io/badge/license-Apache%202-blue.svg?style=flat-square&label=License)](https://github.com/rafafrdz/criteria4s?tab=Apache-2.0-1-ov-file#readme)

# Criteria4s

Criteria4s is a simple domain-specific language (DSL) to define criteria and predicate expressions for any data stores
by using Scala type class mechanisms in a type-safe way. It pretends to be agnostic to any data store, and it is
extensible to support any kind of data stores.

## Formal Definition of the Expressions

The formal definition of the Criteria4s' type-classes (expressions) is as follows:

```text
Criteria    :=  Conjuction Criteria Criteria | Predicate | Value<Boolean>
Predicate   :=  UnaryPred Ref | BinaryPred Ref Ref
Ref         :=  Value<T> | Col
Conjuction  :=  AND | OR
UnaryPred   :=  IS_NULL | IS_NOT_NULL ...
BinaryPred  :=  EQ | NEQ | GT | LT | GEQ | LEQ | IN | LIKE ...
```

Where:

- `Criteria` is the main expression of the DSL
- `Conjuction` is the conjunction operator expression
- `UnaryPredOp` is the unary predicate operator expression
- `BinaryPredOp` is the binary predicate operator expression
- `Ref` is a reference to a value or a column
- `Value<T>` is a value expression of a certain type `T`
- `Col` is a column expression

## Getting Started

To use dsl of Criteria4s, you need to add the following dependency to your project:

**SonaType Repository**

- Core library: [criteria4s-core](https://central.sonatype.com/artifact/io.github.rafafrdz/criteria4s-core_2.13)
- SQL implementation: [criteria4s-sql](https://central.sonatype.com/artifact/io.github.rafafrdz/criteria4s-sql_2.13)

**SBT**

```scala
libraryDependencies += "io.github.rafafrdz" %% "criteria4s-core" % "<version>" // Core library
libraryDependencies += "io.github.rafafrdz" %% "criteria4s-sql" % "<version>" // SQL implementation
```

**Maven**

```xml
<!-- Core library -->
<dependency>
    <groupId>io.github.rafafrdz</groupId>
    <artifactId>criteria4s-core_2.13</artifactId>
    <version>0.8.0</version>
</dependency>

<!-- SQL implementation -->
<dependency>
    <groupId>io.github.rafafrdz</groupId>
    <artifactId>criteria4s-core_2.13</artifactId>
    <version>0.8.0</version>
</dependency>
```

> [!IMPORTANT]  
> Criteria4s is a work in progress and it is not ready for production use. Also, it is just available for Scala 2.13.

## Examples

Here, we will show some examples of how to use the Criteria DSL.

```scala
import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.examples.datastores._
import io.github.rafafrdz.criteria4s.extensions._
import io.github.rafafrdz.criteria4s.functions._

def ageCriteria[T <: CriteriaTag : GT : LT : AND : Sym]: Criteria[T] =
  (col[T]("age") gt lit(18)) and (col[T]("age") lt lit(65))

def expr[T <: CriteriaTag : LEQ : EQ : AND : OR : Sym]: Criteria[T] =
  (col[T]("a") leq lit(3)) and (col[T]("b") leq lit(4)) or (col[T]("c") === lit("c"))

def expr2[T <: CriteriaTag : EQ : Sym](fieldName: String, id: UUID): Criteria[T] =
  col[T](fieldName) === lit(id.toString)
```

And then we can use the `ageCriteria`, `expr` and `expr2` functions to generate criteria expressions for different
datastores:

```scala
ageCriteria[WeirdDatastore]
// res: {left: {left: age, opt: >, right: 18 }, opt: AND, right: {left: age, opt: <, right: 65 } }

expr[MySQL]
// res: ((a <<< '3') AND (b <<< '4')) OR (c = 'c')

expr2[Postgres]("USER_ID", UUID.randomUUID())
// res: `USER_ID` = '07715cee-5d87-427d-99a7-cc03f2b5ef4a'
```

Or maybe we can use the Criteria DSL inline:

```scala
(col[WeirdDatastore]("a") leq lit(3)) and (col[WeirdDatastore]("b") leq lit(4)) or (col[WeirdDatastore]("c") === lit("c"))
// res: {left: {left: {left: a, opt: <=, right: 3 }, opt: AND, right: {left: b, opt: <=, right: 4 } }, opt: OR, right: {left: c, opt: =, right: c } }
```

You can find more examples in
the [`criteria4s-examples`](./examples/src/main/scala/io/github/rafafrdz/criteria4s/examples) module.
