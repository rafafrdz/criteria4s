# Custom Dialect

The `WeirdDatastore` dialect using in this document is an own-implemented dialect for a custom or "weird" datastore.
The examples provided illustrate what the output would look like if a `WeirdDatastore` dialect needs be implemented.
The results are intentionally generated using weird expressions to highlight the differences that occur when applying
the same criteria expression across different dialects.

The `WeirdDatastore` dialect implementation is located in the [WeirdDatastore.scala](../examples/src/main/scala/io/github/rafafrdz/criteria4s/examples/datastores/WeirdDatastore.scala) file.

For these examples we will use the defined expressions in
the [Defining Criteria Expressions](defining-criteria-expressions.md) document.

```scala
expr[WeirdDatastore]
// res: {left: {left: {left: field1, opt: <=, right: 3 }, opt: AND, right: {left: field2, opt: <=, right: 4 } }, opt: OR, right: {left: field3, opt: =, right: c } }
```

## Case of use

```scala
ageCriteria[WeirdDatastore]
// res: {left: {left: age, opt: >, right: 18 }, opt: AND, right: {left: age, opt: <, right: 65 } }
```

```scala
refCriteria[WeirdDatastore]("id", UUID.randomUUID())
// res: {left: id, opt: =, right: dfacb848-6d39-404b-9e6b-f8cbc1f52918 }
```

### Using `IS NULL` expression

```scala
isNullExpr[WeirdDatastore]("field")
// res: {left: field, opt: IS NULL }
```

### Using `NOT` expression

```scala
notExpr[WeirdDatastore]("field")
// res: {left: {left: {left: field, opt: >, right: 2 }, opt: NOT }, opt: AND, right: {left: field, opt: <=, right: 10 } }
```

### Using `BETWEEN` expression

```scala
betweenExpr[WeirdDatastore]("field")
// res: {left: field, opt: BETWEEN, right: [100, 150] }
```

### Using `ARRAY` expression

```scala
arrayExpr[WeirdDatastore]("field")
// res: {left: field, opt: IN, right: [1, 2, 3] }
```

### Using `LIKE` expression

```scala
likeExpr[WeirdDatastore]("field")
// res: {left: field, opt: LIKE, right: a% }
```