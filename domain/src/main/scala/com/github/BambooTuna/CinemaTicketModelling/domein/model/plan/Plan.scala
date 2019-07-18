package com.github.BambooTuna.CinemaTicketModelling.domein.model.plan

import com.github.BambooTuna.CinemaTicketModelling.domein.model.date.{ DivisionType, EventDay, Holiday, Weekday }
import com.github.BambooTuna.CinemaTicketModelling.domein.model.ticket.TicketPrice
import com.github.BambooTuna.CinemaTicketModelling.domein.model.user.Age
import enumeratum._

sealed trait Plan extends EnumEntry {
  def ageLimit(age: Age): Boolean
  def orderBySection(divisionType: DivisionType): TicketPrice = ???
  //備考
  val remarks: Option[String] = None
}

//TODO domain "model"内に具体的な値を入れるのはどうなんだろうか...違う気がする...
object Plan extends Enum[Plan] {

  case object General extends Plan {
    def ageLimit(age: Age): Boolean = true
    override def orderBySection(divisionType: DivisionType): TicketPrice = {
      val price: Long = divisionType match {
        case Weekday.FirstHalf => ???
        case Weekday.FirstHalf => ???
        case Holiday.FirstHalf => ???
        case Holiday.FirstHalf => ???
        case EventDay.MovieDay => ???
      }
      TicketPrice(price)
    }
  }

  case object CinemaCitizen extends Plan {
    def ageLimit(age: Age): Boolean = true
    override val remarks            = Option("※平日なら「映画の日」に関係なく1,000円！")
  }

  case object CinemaCitizenSenior extends Plan {
    def ageLimit(age: Age): Boolean =
      age < Age(60L)
  }

  case object Senior extends Plan {
    def ageLimit(age: Age): Boolean =
      age >= Age(70L)
    override val remarks = Option("身分証をご提示下さい。")
  }

  case object Toddler extends Plan {
    def ageLimit(age: Age): Boolean =
      age >= Age(3L)
  }

  // TODO 17歳で大学生の人もいて、年齢で制限すると例外に対応できない可能性あり？
  case object UniversityStudent extends Plan {
    def ageLimit(age: Age): Boolean = true
    override val remarks            = Option("学生証をご提示下さい。")
  }
  case object HighSchoolStudent extends Plan {
    def ageLimit(age: Age): Boolean = true
    override val remarks            = Option("生徒手帳をご提示下さい。")
  }
  case object MiddleSchoolStudent extends Plan {
    def ageLimit(age: Age): Boolean = true
    override val remarks            = Option("生徒手帳をご提示下さい。")
  }
  case object PrimarySchoolChildren extends Plan {
    def ageLimit(age: Age): Boolean = true
  }
  case object HandicappedMoreThanStudents extends Plan {
    def ageLimit(age: Age): Boolean = true
    override val remarks            = Option("同伴者１名様も同額。手帳をご提示下さい。")
  }
  case object HandicappedUnderHighSchoolStudents extends Plan {
    def ageLimit(age: Age): Boolean = true
    override val remarks            = Option("同伴者１名様も同額。手帳をご提示下さい。")
  }

  val values = findValues
}
