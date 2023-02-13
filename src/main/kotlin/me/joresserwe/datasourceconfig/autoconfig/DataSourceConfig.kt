package me.joresserwe.datasourceconfig.autoconfig

import com.zaxxer.hikari.HikariDataSource
import me.joresserwe.config.ConditionalMyOnClass
import me.joresserwe.datasourceconfig.DataSourceProperties
import me.joresserwe.datasourceconfig.EnableMyDataSourceConfigurationProperties
import me.joresserwe.datasourceconfig.MyDataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SimpleDriverDataSource
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.sql.Driver
import javax.sql.DataSource

@MyDataSourceAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyDataSourceConfigurationProperties(DataSourceProperties::class)
@EnableTransactionManagement
class DataSourceConfig {

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    @ConditionalOnMissingBean
    fun hikariDataSource(properties: DataSourceProperties): DataSource =
        HikariDataSource().apply {
            driverClassName = properties.driverClassName
            jdbcUrl = properties.url
            username = properties.userName
            password = properties.password
        }

    @Bean
    @ConditionalOnMissingBean
    fun dataSource(properties: DataSourceProperties): DataSource =
        SimpleDriverDataSource().apply {
            setDriverClass(Class.forName(properties.driverClassName) as Class<out Driver>)
            url = properties.url
            username = properties.userName
            password = properties.password
        }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnSingleCandidate(DataSource::class)
    fun jdbcTemplate(dataSource: DataSource) = JdbcTemplate(dataSource)


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnSingleCandidate(DataSource::class)
    fun jdbcTransactionManager(dataSource: DataSource) = JdbcTransactionManager(dataSource)

}
