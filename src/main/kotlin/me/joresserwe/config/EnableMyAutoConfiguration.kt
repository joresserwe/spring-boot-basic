package me.joresserwe.config

import me.joresserwe.config.autoconfg.DispatcherServletConfig
import me.joresserwe.config.autoconfg.TomcatWebServerConfig
import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(TomcatWebServerConfig::class, DispatcherServletConfig::class)
annotation class EnableMyAutoConfiguration
