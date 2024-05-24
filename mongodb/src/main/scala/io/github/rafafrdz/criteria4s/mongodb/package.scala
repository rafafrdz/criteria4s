package io.github.rafafrdz.criteria4s

package object mongodb extends MongoDb.MongoDbExpr[MongoDb] {
  type MongoDbExpr[T <: MongoDb] = MongoDb.MongoDbExpr[T]
}
