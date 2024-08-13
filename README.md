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
- MongoDB dialect
  implementation: [criteria4s-mongodb](https://central.sonatype.com/artifact/io.github.rafafrdz/criteria4s-mongodb_2.13)

**SBT**

```scala
libraryDependencies += "io.github.rafafrdz" %% "criteria4s-core" % "<version>" // Core library
libraryDependencies += "io.github.rafafrdz" %% "criteria4s-sql" % "<version>" // SQL implementation
libraryDependencies += "io.github.rafafrdz" %% "criteria4s-mongodb" % "<version>" // MongoDB implementation

```

**Maven**

```xml
<!-- Core library -->
<dependencies>
    <dependency>
        <groupId>io.github.rafafrdz</groupId>
        <artifactId>criteria4s-core_2.13</artifactId>
        <version>0.8.2</version>
    </dependency>

    <!-- SQL implementation -->
    <dependency>
        <groupId>io.github.rafafrdz</groupId>
        <artifactId>criteria4s-core_2.13</artifactId>
        <version>0.8.2</version>
    </dependency>

    <!-- MongoDB implementation -->
    <dependency>
        <groupId>io.github.rafafrdz</groupId>
        <artifactId>criteria4s-mongodb_2.13</artifactId>
        <version>0.8.2</version>
    </dependency>
</dependencies>
```

> [!IMPORTANT]  
> Criteria4s is a work in progress and it is not ready for production use. Also, it is just available for Scala 2.13.

## Dialects

Criteria4s is extensible to support any kind of data stores. Currently, it supports the following **dialects**:

| Dialect     | Package                                                                                    |
|-------------|:-------------------------------------------------------------------------------------------|
| SQL         | [sql](./sql/src/main/scala/io/github/rafafrdz/criteria4s/dialect/sql)                      | 
| MongoDB     | [mongodb](./mongodb/src/main/scala/io/github/rafafrdz/criteria4s/dialect/mongodb)          | 
| PostgresSQL | [postgresql](./postgresql/src/main/scala/io/github/rafafrdz/criteria4s/dialect/postgresql) |

## Examples

Here, we will show some examples of how to use the Criteria DSL. You can find more examples in
the [`criteria4s-examples`](./examples/src/main/scala/io/github/rafafrdz/criteria4s/examples) module.

### Imports

First, we need to import the Criteria4s DSL and the SQL dialect:

```scala
import io.github.rafafrdz.criteria4s.core._
import io.github.rafafrdz.criteria4s.examples.datastores._
import io.github.rafafrdz.criteria4s.extensions._
import io.github.rafafrdz.criteria4s.functions._
```

### Defining Criteria Expressions

We can define criteria expressions in a polymorphic way by using the Criteria DSL. You can find more definitions
examples
in the [`Defining Criteria Expressions`](./doc/defining-criteria-expressions.md) document.

```scala
def expr[T <: CriteriaTag : LEQ : EQ : AND : OR : Show[Column, *]]: Criteria[T] =
  (col[T]("field1") leq lit(3)) and (col[T]("field2") leq lit(4)) or (col[T]("field3") === lit("c"))
```

#### Case of use

```scala
def ageCriteria[T <: CriteriaTag : GT : LT : AND : Show[Column, *]]: Criteria[T] =
  (col[T]("age") gt lit(18)) and (col[T]("age") lt lit(65))

def refCriteria[T <: CriteriaTag : EQ : Show[Column, *]](fieldName: String, id: UUID): Criteria[T] =
  col[T](fieldName) === lit(id.toString)
```

### Evaluating Criteria Expressions

And then we can use those expressions defined belows in order to generate criteria expressions for different
datastores by importing the corresponding dialects. You can find evaluation examples for some different dialects in the
following documents:

- [PostgreSQL Dialect](./doc/postgresql-dialect-evaluating.md)
- [MongoDB Dialect](./doc/mongodb-dialect-evaluating.md)
- [MySQL Dialect](./doc/mysql-dialect-evaluating.md)
- [Custom Dialect](./doc/custom-dialect-evaluating.md)

### Inline Criteria DSL

Or maybe we can use the Criteria DSL inline:

```scala
(col[PostgreSQL]("field1") leq lit(3)) and (col[PostgreSQL]("field2") leq lit(4)) or (col[PostgreSQL]("field3") === lit("c"))
// res: (('field1' <= 3) AND ('field2' <= 4)) OR ('field3' = c)
```

```scala
(col[MongoDB]("field1") leq lit(3)) and (col[MongoDB]("field2") leq lit(4)) or (col[MongoDB]("field3") === lit("c"))
// res: {$or: [{$and: [{"field1": {$lte: 3}}, {"field2": {$lte: 4}}]}, {"field3": {$eq: c}}]}
```

```scala
(col[WeirdDatastore]("field1") leq lit(3)) and (col[WeirdDatastore]("field2") leq lit(4)) or (col[WeirdDatastore]("field3") === lit("c"))
// res: {left: {left: {left: field1, opt: <=, right: 3 }, opt: AND, right: {left: field2, opt: <=, right: 4 } }, opt: OR, right: {left: field3, opt: =, right: c } }
```
