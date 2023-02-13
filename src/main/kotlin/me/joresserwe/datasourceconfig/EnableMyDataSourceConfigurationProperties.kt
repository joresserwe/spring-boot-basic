package me.joresserwe.datasourceconfig

import org.springframework.context.annotation.Import
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(DatasourcePropertiesImportSelector::class)
annotation class EnableMyDataSourceConfigurationProperties(
    val value: KClass<*>
)
