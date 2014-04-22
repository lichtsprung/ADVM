package models

import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.Imports._
import com.novus.salat._
import com.mongodb.casbah.commons.MongoDBObject
import play.api.libs.json.{Json, JsValue, Writes}

object Schedules {

  object Implicits{
    implicit val studentWrites = new Writes[Schedule] {
      override def writes(schedule: Schedule): JsValue = Json.toJson(Map(
        "test" -> "test"
      ))
    }
  }

  private val schedules = MongoClient()("advm")("schedules")

}
