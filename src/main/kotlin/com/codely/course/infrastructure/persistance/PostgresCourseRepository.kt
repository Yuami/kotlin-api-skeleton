package com.codely.course.infrastructure.persistance

import com.codely.course.domain.Course
import com.codely.course.domain.CourseRepository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class PostgresCourseRepository(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : CourseRepository {
    override fun save(course: Course) {
        MapSqlParameterSource()
            .addValue("id", course.id.value)
            .addValue("name", course.name.value)
            .addValue("description", course.description.value)
            .addValue("createdAt", course.createdAt)
            .let { params ->
                jdbcTemplate.update(
                    "INSERT INTO course (id, name, description, created_at) VALUES (:id, :name, :description, :createdAt)",
                    params
                )
            }
    }
}
