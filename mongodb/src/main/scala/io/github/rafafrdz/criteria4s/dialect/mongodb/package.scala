package io.github.rafafrdz.criteria4s.dialect

package object mongodb extends MongoDB.MongoDBExpr[MongoDB] {
  type MongoDBExpr[T <: MongoDB] = MongoDB.MongoDBExpr[T]
}
