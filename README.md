# Criterial DSL
## Formal Definition of Criterial Expressions

TODO: Add a formal definition of the Criterial DSL

```text
Criterial   := ConjC Criterial Criterial | PredOp RefC RefC | ValueC<Bool>
RefC        := ValueC<T> | ColC
```
alternativamente
```text
Criterial   := ConjC Criterial Criterial | PredOp RefC RefC | ValueC<Bool>
RefC        := ValueC<T> | ColC | FuncC | CollectionC
```