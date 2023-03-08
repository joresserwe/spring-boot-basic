package me.joresserwe.helloboot

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootTest
class HelloRepositoryJdbcTest(
    private val helloRepository: HelloRepository,
    private val jdbcTemplate: JdbcTemplate
) : FunSpec({
    this.beforeTest {
        jdbcTemplate.execute(
            "create table if not exists hello( name varchar(50) primary key, count int )"
        )
    }

    this.test("find hello failed") {
        helloRepository.findHello("Bin") shouldBe null
    }

    this.test("increse counter") {
        helloRepository.countOf("Bin") shouldBe 0

        helloRepository.increaseCount("Bin")
        helloRepository.countOf("Bin") shouldBe 1

        helloRepository.increaseCount("Bin")
        helloRepository.countOf("Bin") shouldBe 2
    }
})

