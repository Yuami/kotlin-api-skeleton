package com.codely.course.infrastructure

import com.codely.course.domain.Course
import com.codely.course.domain.CourseRepository

class InMemoryCourseRepository: CourseRepository {
    override fun save(course: Course) {
        TODO("Not yet implemented")
    }
}