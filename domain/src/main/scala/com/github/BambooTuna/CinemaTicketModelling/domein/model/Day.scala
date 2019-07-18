package com.github.BambooTuna.CinemaTicketModelling.domein.model

import enumeratum._

sealed trait Day extends EnumEntry
object Day extends Enum[Day] {

  case object MovieDay   extends Day
  case object Holiday extends Day
  case object Weekday     extends Day

  val values = findValues
}
