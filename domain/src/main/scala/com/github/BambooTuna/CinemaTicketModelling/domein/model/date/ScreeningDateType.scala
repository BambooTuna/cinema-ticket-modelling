package com.github.BambooTuna.CinemaTicketModelling.domein.model.date

import enumeratum._

sealed trait DivisionType extends EnumEntry

sealed trait Weekday extends DivisionType
object Weekday extends Enum[Weekday] {

  case object FirstHalf  extends Weekday
  case object LatterHalf extends Weekday

  val values = findValues
}

sealed trait Holiday extends DivisionType
object Holiday extends Enum[Holiday] {

  case object FirstHalf  extends Holiday
  case object LatterHalf extends Holiday

  val values = findValues
}

sealed trait EventDay extends DivisionType
object EventDay extends Enum[EventDay] {

  case object MovieDay extends EventDay

  val values = findValues
}
