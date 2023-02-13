package me.joresserwe.datasourceconfig

import org.springframework.boot.context.annotation.ImportCandidates
import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata

class DatasourceConfigurationImportSelector(
    private val classLoader: ClassLoader
) : DeferredImportSelector {

    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val load = ImportCandidates.load(MyDataSourceAutoConfiguration::class.java, classLoader)
        return load.map { it }.toTypedArray()
    }
}
