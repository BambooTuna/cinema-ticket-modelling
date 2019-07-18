package com.github.BambooTuna.CinemaTicketModelling.domein.model.user

case class Age(value: Long) {
  require(value >= 0)

  def >(age: Age): Boolean  = this.value > age.value
  def >=(age: Age): Boolean = this.value >= age.value

  def <(age: Age): Boolean  = this.value < age.value
  def <=(age: Age): Boolean = this.value <= age.value

  def ==(age: Age): Boolean = this.value == age.value

}
