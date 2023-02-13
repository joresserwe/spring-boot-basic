package me.joresserwe.helloboot

import me.joresserwe.config.MySpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate

@MySpringBootApplication
class HellobootApplication(
    jdbcTemplate: JdbcTemplate
) {
    init {
        println("#######################################")
        jdbcTemplate.execute(
            "create table if not exists hello( name varchar(50) primary key, count int )"
        )
    }
}

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
