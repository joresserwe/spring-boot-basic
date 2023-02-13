package me.joresserwe.datasourceconfig

@MyDataSourceConfigurationProperties("datasource")
class DataSourceProperties {
    lateinit var driverClassName: String
    lateinit var url: String
    lateinit var userName: String
    lateinit var password: String
}
