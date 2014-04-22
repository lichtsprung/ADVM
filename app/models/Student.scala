package models

case class Student(
                    firstname: String,
                    lastname: String,
                    registrationNumber: String,
                    id: String,
                    degreeProgramme: String
                    )

case class Professor(firstname: String, lastname: String, id: String, courses: List[String])