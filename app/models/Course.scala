package models


case class Course(
                   name: String,
                   id: String,
                   professors: List[Professor],
                   students: List[Student])
