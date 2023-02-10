package me.joresserwe.config.autoconfig

import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Component
annotation class MyConfigurationProperties(
    val prefix: String
)
