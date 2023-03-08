package me.joresserwe.helloboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootApplication
class HellobootApplication(
    jdbcTemplate: JdbcTemplate
) {
    init {
        jdbcTemplate.execute(
            "create table if not exists hello( name varchar(50) primary key, count int )"
        )
    }
}

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
