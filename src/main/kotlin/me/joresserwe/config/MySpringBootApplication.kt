package me.joresserwe.config

import me.joresserwe.datasourceconfig.EnableMyDataSourceAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
@EnableMyDataSourceAutoConfiguration
annotation class MySpringBootApplication
