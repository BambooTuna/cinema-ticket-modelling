package com.github.BambooTuna.CinemaTicketModelling.domein.model.date

import java.time.ZonedDateTime

case class ScreeningDate(date: ZonedDateTime) {

  //TODO　平日、祝日、イベント日の判定
  val screeningSection: DivisionType = ???

}
