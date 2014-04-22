package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.json._
import models.Course


object CourseManagement extends Controller{
  implicit val courseWrites = new Writes[Course] {
    override def writes(course: Course): JsValue = Json.toJson(
      Map(
        "id" -> course.id,
        "name" -> course.name
      )
    )
  }


  def getCourse(id: String) = play.mvc.Results.TODO

  def course() = Action(parse.json){
    request =>
      val b = request.body
      val id = b \ "id"
      val name = b \ "name"
      val programmes = Json.fromJson[List[String]](b \ "programmes").get
      println(programmes)
      Ok("")
  }

  def updateCourse(id: String) = play.mvc.Results.TODO

  def removeCourse(id: String) = play.mvc.Results.TODO

  def listCourses() = play.mvc.Results.TODO
}
