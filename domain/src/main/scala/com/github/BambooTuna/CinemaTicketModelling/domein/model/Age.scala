package com.github.BambooTuna.CinemaTicketModelling.domein.model

case class Age(value: Long) {
  require(value >= 0)
}
