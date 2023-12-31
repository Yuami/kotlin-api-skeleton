package com.codely.course.domain

import java.time.LocalDateTime
import java.util.*

data class CourseId(val value: UUID) {
    companion object {
        fun fromString(id: String) = try {
            CourseId(UUID.fromString(id))
        } catch (exception: Exception) {
            throw InvalidCourseIdException(id, exception)
        }
    }
}

data class CourseName(val value: String) {
    init {
        validate()
    }

    private fun validate() {
        if (value.isEmpty() || value.isBlank()) {
            throw InvalidCourseNameException(value)
        }
    }
}

data class CourseDescription(val value: String) {
    init {
        validate()
    }

    private fun validate() {
        if (value.length > 150) {
            throw InvalidCourseDescriptionException(value)
        }
    }
}

data class Course private constructor(
    val id: CourseId,
    val name: CourseName,
    val description: CourseDescription,
    val createdAt: LocalDateTime
) {
    companion object {
        fun from(id: String, name: String, description: String, createdAt: LocalDateTime) =
            Course(CourseId.fromString(id), CourseName(name), CourseDescription(description), createdAt)
    }
}
