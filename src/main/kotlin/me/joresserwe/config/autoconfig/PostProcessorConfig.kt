package me.joresserwe.config.autoconfig

import me.joresserwe.config.MyAutoConfiguration
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.core.annotation.AnnotationUtils.findAnnotation
import org.springframework.core.annotation.AnnotationUtils.getAnnotationAttributes
import org.springframework.core.env.Environment

@MyAutoConfiguration
class PostProcessorConfig(
    private val environment: Environment
) : BeanPostProcessor {

    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any {

        val annotation =
            findAnnotation(bean::class.java, MyConfigurationProperties::class.java) ?: return bean

        val attrs = getAnnotationAttributes(annotation)
        val prefix = attrs["prefix"].toString()
        return Binder.get(environment).bindOrCreate(prefix, bean.javaClass)
    }
}
