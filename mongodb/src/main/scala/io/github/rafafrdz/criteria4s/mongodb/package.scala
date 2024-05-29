package io.github.rafafrdz.criteria4s

package object mongodb extends MongoDB.MongoDBExpr[MongoDB] {
  type MongoDBExpr[T <: MongoDB] = MongoDB.MongoDBExpr[T]
}
