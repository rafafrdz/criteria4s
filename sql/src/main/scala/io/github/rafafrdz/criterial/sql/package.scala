package io.github.rafafrdz.criterial
package object sql extends SQL.SQLExpr[SQL] {

  type SQLExpr[T <: SQL] = SQL.SQLExpr[T]
}
