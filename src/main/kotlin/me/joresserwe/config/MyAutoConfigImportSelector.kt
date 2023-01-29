package me.joresserwe.config

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata

class MyAutoConfigImportSelector : DeferredImportSelector{
    override fun selectImports(importingClassMetadata: AnnotationMetadata) =
        arrayOf(
            "me.joresserwe.config.autoconfig.DispatcherServletConfig",
            "me.joresserwe.config.autoconfig.TomcatWebServerConfig"
        )
}
