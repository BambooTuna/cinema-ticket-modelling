package com.github.BambooTuna.CinemaTicketModelling.domein.model.ticket

import com.github.BambooTuna.CinemaTicketModelling.domein.model.date.ScreeningDate
import com.github.BambooTuna.CinemaTicketModelling.domein.model.plan.Plan
import com.github.BambooTuna.CinemaTicketModelling.domein.model.user.Age

case class Ticket(price: TicketPrice)

object Ticket {

  def purchase(age: Age, plans: Seq[Plan], date: ScreeningDate): Ticket = {
    plans
      .filter(
        //年齢制限
        _.ageLimit(age)
      )
      .map(
        order(_, date)
      ).minBy(
      //TODO ない場合の処理を追加する
      _.price
    )
  }

  private def order(plan: Plan, date: ScreeningDate): Ticket =
    Ticket(
      plan
        .orderBySection(
          date.screeningSection
        )
    )

}
