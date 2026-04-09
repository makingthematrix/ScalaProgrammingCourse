
enum WeekDay(val label: String) extends java.lang.Enum[WeekDay] {
  case Mon extends WeekDay("Monday")
  case Tue extends WeekDay("Tuesday")
  case Wed extends WeekDay("Wednesday")
  case Thu extends WeekDay("Thursday")
  case Fri extends WeekDay("Friday")
  case Sat extends WeekDay("Saturday")
  case Sun extends WeekDay("Sunday")

  def isOnWeekend: Boolean = this == Sat || this == Sun
}

object WeekDay {
  def hasRInName(day: WeekDay): Boolean = day.label.contains('r')
}

/*	@main def main(): Unit = 
		val day = WeekDay.Sat
		day match
			case WeekDay.Mon => ???
			case WeekDay.Tue => ???
			case WeekDay.Wed => ???
			case WeekDay.Thu => ???
			case WeekDay.Fri => ???
			case WeekDay.Sat => ???
			case WeekDay.Sun => ???
		
*/