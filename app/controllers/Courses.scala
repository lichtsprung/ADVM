package controllers

import play.api.libs.json.Json
import com.mongodb.casbah.Imports._
import com.novus.salat._
import com.novus.salat.global._
import models.Student
import models.ctx
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.MongoClient

object Courses {
  private val courses = MongoClient()("advm")("courses")


}
