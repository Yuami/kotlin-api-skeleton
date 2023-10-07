package com.codely.config

import com.codely.course.infrastructure.DatabaseConnectionData
import com.codely.course.infrastructure.InMemoryCourseRepository
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "database.connection")
    fun databaseConnectionData() = DatabaseConnectionData()

    @Bean
    fun courseRepository(databaseConnectionData: DatabaseConnectionData) = InMemoryCourseRepository(databaseConnectionData)
}