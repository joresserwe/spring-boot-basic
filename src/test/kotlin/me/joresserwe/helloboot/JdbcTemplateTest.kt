package me.joresserwe.helloboot

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.jdbc.core.JdbcTemplate

@HellobootTest
class JdbcTemplateTest(
    private val jdbcTemplate: JdbcTemplate,

) : FunSpec() {

    init {
        this.beforeTest {
            jdbcTemplate.execute(
                "create table if not exists hello( name varchar(50) primary key, count int )"
            )
        }

        this.test("insertandquery") {
            jdbcTemplate.update("insert into hello values(?, ?)", "Bin", 3)
            jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 5)

            val count = jdbcTemplate.queryForObject("select count(*) from hello", Long::class.java)
            count shouldBe 2
        }
        this.test("insertandquery2") {
            jdbcTemplate.update("insert into hello values(?, ?)", "Bin", 3)
            jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 5)

            val count = jdbcTemplate.queryForObject("select count(*) from hello", Long::class.java)
            count shouldBe 2
        }
    }
}
