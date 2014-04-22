package models

import org.joda.time.DateTime


case class Schedule(degreeProgramme: String, course: String, dates: Map[Int, ScheduleEntry])

case class ScheduleEntry(startTime: Int, endTime: Int, date: DateTime)