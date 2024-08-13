# MySQL Dialect

The `MySQL` dialect is not yet available. The examples provided illustrate what the output would look like if a MySQL
dialect were implemented. The results are intentionally generated using non-official expressions to highlight the
differences that occur when applying the same criteria expression across different dialects.

We are currently working on the official MySQL dialect. In the meantime, you can use the SQL dialect to implement your
own MySQL dialect.

For these examples we will use the defined expressions in
the [Defining Criteria Expressions](defining-criteria-expressions.md) document.

```scala
expr[MySQL]
// res: ((field1 <<< '3') AND (field2 <<< '4')) OR (field3 = 'c')
```

## Case of use

```scala
ageCriteria[MySQL]
// res: ((age > '18') AND (age < '65'))
```

```scala
refCriteria[MySQL]("id", UUID.randomUUID())
// res: id = '07715cee-5d87-427d-99a7-cc03f2b5ef4a'
```

### Using `IS NULL` expression

```scala
isNullExpr[MySQL]("field")
// res: field IS NULL
```

### Using `NOT` expression

```scala
notExpr[Mysql]("field")
// res: (NOT (field > '2')) AND (field <= '10')
```

### Using `BETWEEN` expression

```scala
betweenExpr[MySQL]("field")
// res: field BETWEEN 100 AND 150
```

### Using `ARRAY` expression

```scala
arrayExpr[MySQL]("field")
// res: field IN (1, 2, 3)
```

### Using `LIKE` expression

```scala
likeExpr[MySQL]("field")
// res: field LIKE 'a%'
```