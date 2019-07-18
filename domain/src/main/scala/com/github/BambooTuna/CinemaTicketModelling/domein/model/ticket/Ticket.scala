package com.github.BambooTuna.CinemaTicketModelling.domein.model.ticket

import com.github.BambooTuna.CinemaTicketModelling.domein.model.date.ScreeningDate
import com.github.BambooTuna.CinemaTicketModelling.domein.model.plan.Plan
import com.github.BambooTuna.CinemaTicketModelling.domein.model.user.Age

case class Ticket(price: TicketPrice)

object Ticket {

  def purchase(age: Age, plan: Plan, date: ScreeningDate): Ticket = {
    //年齢制限
    require(plan.ageLimit(age))

    //TODO 最安検索機能があるといい？
    order(plan, date)
  }

  private def order(plan: Plan, date: ScreeningDate): Ticket =
    Ticket(
      plan
        .orderBySection(
          date.screeningSection
        )
    )

}
