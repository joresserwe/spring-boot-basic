package me.joresserwe.helloboot

import io.kotest.core.spec.style.FunSpec
import javax.sql.DataSource

@HellobootTest
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
