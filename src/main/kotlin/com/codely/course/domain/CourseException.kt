package com.codely.course.domain

class InvalidCourseIdException(id: String, exception: Exception) : Throwable() {

}

class InvalidCourseNameException(name: String) : Throwable() {

}
