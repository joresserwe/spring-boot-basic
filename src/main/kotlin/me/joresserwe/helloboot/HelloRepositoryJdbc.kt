package me.joresserwe.helloboot

import org.springframework.jdbc.core.DataClassRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class HelloRepositoryJdbc(
    private val jdbcTemplate: JdbcTemplate
) : HelloRepository {

    override fun findHello(name: String) =
        runCatching {
            jdbcTemplate.queryForObject("select * from hello where name = '$name'", itemRowMapper())
        }.getOrNull()

    fun itemRowMapper() = DataClassRowMapper.newInstance(Hello::class.java)

    override fun increaseCount(name: String) {

        findHello(name)?.let { jdbcTemplate.update("update hello set count=? where name = ?", it.count + 1, name) }
            ?: jdbcTemplate.update("insert into hello values(?, ?)", name, 1)

    }
}
