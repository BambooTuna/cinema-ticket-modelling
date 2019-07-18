package com.github.BambooTuna.CinemaTicketModelling.domein.model

class TicketPrice(price: Price) {


  
}


object TicketPrice {

  def apply(price: Price): TicketPrice = new TicketPrice(price)

}