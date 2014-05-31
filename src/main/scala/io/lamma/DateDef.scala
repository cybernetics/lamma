package io.lamma

import io.lamma.Shifter.NoShift
import io.lamma.Selector.SameDay
import io.lamma.Anchor.{OtherDateDef, PeriodEnd, PeriodStart}

case class DateDef(name: String,
                   relativeTo: Anchor = PeriodEnd,
                   shifter: Shifter = NoShift,
                   selector: Selector = SameDay,
                   cal: HolidayCalendar = WeekendHolidayCalendar) {

  /**
   * @param period
   * @param populated a map of already populated dates
   * @return
   */
  def populate(period: Period, populated: Map[String, Date] = Map.empty) = {
    val anchorDate = relativeTo match {
      case PeriodStart => period.from
      case PeriodEnd => period.to
      case OtherDateDef(name) => populated(name)
    }

    val shiftedDate = Shifter.shift(anchorDate, shifter, cal)

    Selector.select(shiftedDate, selector, cal)
  }
}

object DateDef {
  def validate(defs: List[DateDef]) {
    val names = defs.map(_.name)
    require(names.size == names.toSet.size, s"Name of DateDef should be unique. Defined names: ${names.mkString(",")}")

    // validate OtherDateDef position
    (Set.empty[String] /: defs) {
      (availableName, dateDef) =>
        dateDef.relativeTo match {
          case OtherDateDef(name) =>
            if (! availableName.contains(name)) {
              if (names.contains(name)) {
                throw new IllegalArgumentException(s"$dateDef should come after anchor date $name")
              } else {
                throw new IllegalArgumentException(s"$dateDef is referencing to an non-exist anchor date $name")
              }
            }
          case _ =>
        }
        availableName + dateDef.name
    }
  }
}
