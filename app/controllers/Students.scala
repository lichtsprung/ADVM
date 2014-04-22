package controllers

import com.mongodb.casbah.{MongoClient, MongoClientURI}

import play.api.libs.json.Json
import com.mongodb.casbah.Imports._
import com.novus.salat._
import com.novus.salat.global._
import models.Student
import models.ctx
import com.mongodb.casbah.commons.MongoDBObject

object Students {
  private val students = MongoClient()("advm")("students")

  def all(): Iterable[Student] = for (st <- students) yield grater[Student].asObject(st)

  def add(student: Student): String = {
    val dobj = grater[Student].asDBObject(student)
    students.insert(dobj)
    dobj.get("_id").asInstanceOf[ObjectId].toString
  }

  def remove(student: Student): Option[Student] = {
    val query = MongoDBObject("id" -> student.id)
    for(removed <- students.findAndRemove(query)) yield grater[Student].asObject(removed)
  }

  def remove(id: String):Option[Student] = {
    val query = MongoDBObject("id" -> id)
    for(removed <- students.findAndRemove(query)) yield grater[Student].asObject(removed)
  }

  def get(id: String): Option[Student] =
    for (st <- students.findOne(MongoDBObject("id" -> id))) yield grater[Student].asObject(st)

  def update(student: Student) ={
    for(old <- students.findOne(MongoDBObject("id" -> student.id))){
      old.update("firstname", student.firstname)
      old.update("lastname", student.lastname)
      old.update("registrationNumber", student.registrationNumber)
      old.update("id", student.id)
      old.update("degreeProgramme", student.degreeProgramme)
    }
  }

  def update(id: String, updates: Map[String, AnyRef]) = {
    for{
      old <- students.findOne(MongoDBObject("id" -> id))
      update <- updates
    }{
      old.update(update._1, update._2)
    }
  }

  def exists(id: String): Boolean = {
    students.findOne(MongoDBObject("id" -> id)) != None
  }
}
