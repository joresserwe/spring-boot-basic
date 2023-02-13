package me.joresserwe.datasourceconfig

import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(DatasourceConfigurationImportSelector::class)
annotation class EnableMyDataSourceAutoConfiguration
