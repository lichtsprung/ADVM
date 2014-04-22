package models

import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.Imports._
import com.novus.salat._
import com.mongodb.casbah.commons.MongoDBObject

object Courses {
  private val courses = MongoClient()("advm")("courses")


}
