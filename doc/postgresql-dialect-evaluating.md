# PostgreSQL Dialect

The `PostgreSQL` dialect is not yet available. The examples provided illustrate what the output would look like if a PostgreSQL
dialect were implemented. The results are intentionally generated using non-official expressions to highlight the
differences that occur when applying the same criteria expression across different dialects.

We are currently working on the official PostgreSQL dialect. In the meantime, you can use the SQL dialect to implement your
own PostgreSQL dialect.

For these examples we will use the defined expressions in
the [Defining Criteria Expressions](defining-criteria-expressions.md) document.

```scala
expr[PostgreSQL]
// res: (('field1' <= 3) AND ('field2' <= 4)) OR ('field3' = c)
```

## Case of use

```scala
ageCriteria[PostgreSQL]
// res: ('age' > 18) AND ('age' < 65)
```

```scala
refCriteria[PostgreSQL]("id", UUID.randomUUID())
// res: 'id' = 473a1484-afd8-4ebd-8eb4-312fd51510b3
```

### Using `IS NULL` expression

```scala
isNullExpr[PostgreSQL]("field")
// res: 'field' IS NULL
```

### Using `NOT` expression

```scala
notExpr[PostgreSQL]("field")
// res: (NOT ('field' > 2)) AND ('field' <= 10)
```

### Using `BETWEEN` expression

```scala
betweenExpr[PostgreSQL]("field")
// res: 'field' BETWEEN 100 TO 150
```

### Using `ARRAY` expression

```scala
arrayExpr[PostgreSQL]("field")
// res: 'field' IN (1, 2, 3)
```

### Using `LIKE` expression

```scala
likeExpr[PostgreSQL]("field")
// res: 'field' LIKE a%
```