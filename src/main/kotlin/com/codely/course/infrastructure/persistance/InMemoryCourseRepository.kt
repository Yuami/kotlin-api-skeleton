package com.codely.course.infrastructure.persistance

import com.codely.course.domain.Course
import com.codely.course.domain.CourseRepository

class DatabaseConnectionData(var username: String = "", var password: String = "")

class InMemoryCourseRepository(private val databaseConnectionData: DatabaseConnectionData) : CourseRepository {

    override fun save(course: Course) {
        TODO("Not yet implemented")
    }
}
