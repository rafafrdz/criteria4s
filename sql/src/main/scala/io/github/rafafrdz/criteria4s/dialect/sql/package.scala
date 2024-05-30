package io.github.rafafrdz.criteria4s.dialect

package object sql extends SQL.SQLExpr[SQL] {

  type SQLExpr[T <: SQL] = SQL.SQLExpr[T]
}
