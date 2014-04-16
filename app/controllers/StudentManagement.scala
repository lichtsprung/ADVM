package controllers

import play.api.mvc.{Action, Controller}
import models.Student
import play.api.libs.json.Json


object StudentManagement extends Controller{

  def student = Action(parse.json) {
    request =>
      val firstname = request.body \ "firstname"
      val lastname = request.body \ "lastname"
      val registration = request.body \ "registrationNumber"
      val id = request.body \ "id"
      val degreeProgramme = request.body \ "degreeProgramme"

      val stu = Student(firstname.as[String], lastname.as[String], registration.as[String], id.as[String], Set(),degreeProgramme.as[String])
      Students.add(stu)
      Ok(s"Student added")
  }

  def getStudent(id: String) = Action {
    val studentOption = Students.get(id)
    studentOption match {
      case Some(student) =>
        val json = Json.toJson(
          Map(
            "firstname" -> student.firstname,
            "lastname" -> student.lastname,
            "registrationNumber" -> student.registrationNumber,
            "id" -> student.id
          )
        )
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
      if(Students.exists(id)){
        Ok("")
      }else{
        NotFound(s"Student with $id does not exist!")
      }

  }
}
