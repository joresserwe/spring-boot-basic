package me.joresserwe.config.autoconfig

import org.springframework.context.annotation.Import
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(MyConfigurationPropertiesImportSelector::class)
annotation class EnableMyConfigurationProperties(val value: KClass<*>)
