# MongoDB Dialect

The `MongoDB` dialect is available. The examples provided illustrate what the output look like using the MongoDB
dialect.

For these examples we will use the defined expressions in
the [Defining Criteria Expressions](defining-criteria-expressions.md) document.

```scala
expr[MongoDB]
// res: {$or: [{$and: [{"field1": {$lte: 3}}, {"field2": {$lte: 4}}]}, {"field3": {$eq: c}}]}
```

## Case of use

```scala
ageCriteria[MongoDB]
// res: {$and: [{"age": {$gt: 18}}, {"age": {$lt: 65}}]}
```

```scala
refCriteria[MongoDB]("id", UUID.randomUUID())
// res: {"id": {$eq: d0ba6ea7-4cff-44e4-b612-ebe12242bd18}}
```

### Using `IS NULL` expression

```scala
isNullExpr[MongoDB]("field")
// res: {"field": null}
```

### Using `NOT` expression

```scala
notExpr[MongoDB]("field")
// res: {$and: [{"field": {$not: {$gt: 2}}}, {"field": {$lte: 10}}]}
```

### Using `BETWEEN` expression

```scala
betweenExpr[MongoDB]("field")
// res: {"field": { $gte: 100, $lt: 150 }}
```

### Using `ARRAY` expression

```scala
arrayExpr[MongoDB]("field")
// res: {"field": {$in: [1, 2, 3]}}
```

### Using `LIKE` expression

```scala
likeExpr[MongoDB]("field")
// res: {"field": {$regex: \a%\}}
```