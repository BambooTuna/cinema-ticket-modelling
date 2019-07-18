package com.github.BambooTuna.CinemaTicketModelling.domein.model

case class Price(price: Long) {
  require(price >= 0)
}
