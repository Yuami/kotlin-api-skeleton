package com.codely.course.application

import com.codely.course.BaseTest
import com.codely.course.domain.*
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime

class CourseCreatorTest: BaseTest() {
    private lateinit var courseRepository: CourseRepository
    private lateinit var courseCreator: CourseCreator

    @BeforeEach
    fun setUp() {
        courseRepository = mockk(relaxUnitFun = true)
        clock = mockk()
        courseCreator = CourseCreator(courseRepository, clock)
    }

    @Test
    fun `should create a course successfully`() {
        givenFixedDate(fixedDate)
        courseCreator.create(id, name)
        thenTheCourseShouldBeSaved()
    }

    private fun thenTheCourseShouldBeSaved() {
        verify { courseRepository.save(
            Course.from(
                id = id,
                name = name,
                createdAt = fixedDate
            )
        ) }
    }

    @Test
    fun `should fail with invalid id`() {
        givenFixedDate(fixedDate)

        assertThrows<InvalidCourseIdException> { courseCreator.create("Invalid", name) }
    }

    @Test
    fun `should fail with invalid name`() {
        givenFixedDate(fixedDate)

        assertThrows<InvalidCourseNameException> { courseCreator.create(id, "    ") }
        assertThrows<InvalidCourseNameException> { courseCreator.create(id, "") }
    }

    companion object {
        private const val id = "caebae03-3ee9-4aef-b041-21a400fa1bb7"
        private const val name = "Kotlin Hexagonal Architecture Api"
        private val fixedDate = LocalDateTime.parse("2023-10-06T00:00:00")
    }
}