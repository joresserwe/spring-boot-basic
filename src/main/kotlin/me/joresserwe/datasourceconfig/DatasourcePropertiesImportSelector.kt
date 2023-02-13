package me.joresserwe.datasourceconfig

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata

class DatasourcePropertiesImportSelector : DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {

        val attributes =
            importingClassMetadata.getAllAnnotationAttributes(EnableMyDataSourceConfigurationProperties::class.java.name)!!

        val propertyClass = attributes.getFirst("value") as Class<*>
        return arrayOf(propertyClass.name)
    }
}
