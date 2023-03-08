package me.joresserwe.helloboot

import io.kotest.core.spec.style.FunSpec
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import javax.sql.DataSource

@JdbcTest
class DataSourceTest(
    private val dataSource: DataSource
) : FunSpec() {

    init {
        this.test("connet test") {
            val connection = dataSource.connection
            connection.close()
        }
    }
}
