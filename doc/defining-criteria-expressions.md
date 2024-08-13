# Defining Criteria Expressions

We can define criteria expressions in a polymorphic way by using the Criteria DSL:

```scala
def expr[T <: CriteriaTag : LEQ : EQ : AND : OR : Show[Column, *]]: Criteria[T] =
  (col[T]("field1") leq lit(3)) and (col[T]("field2") leq lit(4)) or (col[T]("field3") === lit("c"))
```

## Case of use

```scala
def ageCriteria[T <: CriteriaTag : GT : LT : AND : Show[Column, *]]: Criteria[T] =
  (col[T]("age") gt lit(18)) and (col[T]("age") lt lit(65))

def refCriteria[T <: CriteriaTag : EQ : Show[Column, *]](fieldName: String, id: UUID): Criteria[T] =
  col[T](fieldName) === lit(id.toString)
```

### Using `IS NULL` expression

```scala
def isNullExpr[T <: CriteriaTag : ISNULL : Show[Column, *]](fieldName: String): Criteria[T] =
  col[T](fieldName).isNull
```

### Using `NOT` expression

```scala
def notExpr[T <: CriteriaTag : NOT : GT : LEQ : AND : Show[Column, *] : Show[(Int, Int), *]](fieldName: String): Criteria[T] =
  not(col[T](fieldName) gt lit(2)) && (col[T](fieldName) leq lit(10))
```

### Using `BETWEEN` expression

```scala
def betweenExpr[T <: CriteriaTag : BETWEEN : Show[Column, *] : Show[(Int, Int), *]](fieldName: String): Criteria[T] =
  col[T](fieldName) between range(100, 150)
```

### Using `ARRAY` expression

```scala
def arrayExpr[T <: CriteriaTag : IN : Show[Column, *] : Show[Seq[Int], *]](fieldName: String): Criteria[T] =
  col[T](fieldName) in array(1, 2, 3)
```

### Using `LIKE` expression

```scala
def likeExpr[T <: CriteriaTag : LIKE : Show[Column, *]](fieldName: String): Criteria[T] =
  col[T](fieldName) like lit("a%")
```
