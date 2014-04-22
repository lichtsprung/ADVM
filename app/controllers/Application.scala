package controllers

import play.api.mvc.{Action, Controller}
import com.mongodb.casbah.{MongoClientURI, MongoClient}
import com.mongodb.casbah.commons.MongoDBObject
import play.api.libs.json.Json
import com.mongodb.casbah.Imports._
import com.novus.salat._
import com.novus.salat.global._
import models.Student
import models.ctx

object Application extends Controller {

  def studentManagement = Action {
    Ok(views.html.student_management())
  }

  def programmeManagement = Action {
    Ok(views.html.programme_management())
  }

  def courseManagement = Action{
    Ok(views.html.course_management())
  }


}



