package com.eff3ct.criteria4s.dialect

package object mongodb extends MongoDB.MongoDBExpr[MongoDB] {
  type MongoDBExpr[T <: MongoDB] = MongoDB.MongoDBExpr[T]
}
