package me.joresserwe.config.autoconfig

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata

class MyConfigurationPropertiesImportSelector : DeferredImportSelector {

    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {

        val attributes =
            importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties::class.java.name)!!

        val propertyClass = attributes.getFirst("value") as Class<*>
        return arrayOf(propertyClass.name)
    }
}
