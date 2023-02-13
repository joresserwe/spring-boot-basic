package me.joresserwe.datasourceconfig

import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Component
annotation class MyDataSourceConfigurationProperties(
    val prefix: String
)
