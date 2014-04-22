package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.json._
import models.{Students, Student}
import Students.Implicits._


object StudentManagement extends Controller {


  def student = Action(parse.json) {
    request =>
      val firstname = request.body \ "firstname"
      val lastname = request.body \ "lastname"
      val registration = request.body \ "registrationNumber"
      val id = request.body \ "id"
      val degreeProgramme = request.body \ "degreeProgramme"

      val stu = Student(firstname.as[String], lastname.as[String], registration.as[String], id.as[String], degreeProgramme.as[String])
      val oID = Students.add(stu)
      Ok(
        s"""
           |{
           |"id":\"$oID\"
           |}
         """.stripMargin)
  }

  def getStudent(id: String) = Action {
    val studentOption = Students.get(id)
    studentOption match {
      case Some(student) =>
        val json = Json.toJson(student)
        Ok(Json.stringify(json))
      case None =>
        NotFound(s"Student with $id does not exist!")
    }

  }

  def removeStudent(id: String) = Action {
    Students.remove(id)
    Ok(s"Student with id $id removed")
  }

  def updateStudent(id: String) = Action(parse.json) {
    request =>
      if (Students.exists(id)) {
        Ok("")
      } else {
        NotFound(s"Student with $id does not exist!")
      }

  }

  def listStudents() = Action {
    val json = Json.toJson(Students.all())
    Ok(Json.stringify(json))
  }
}
