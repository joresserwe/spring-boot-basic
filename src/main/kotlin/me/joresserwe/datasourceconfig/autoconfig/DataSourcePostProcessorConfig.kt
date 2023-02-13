package me.joresserwe.datasourceconfig.autoconfig

import me.joresserwe.datasourceconfig.MyDataSourceAutoConfiguration
import me.joresserwe.datasourceconfig.MyDataSourceConfigurationProperties
import mu.KotlinLogging
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.core.env.Environment

@MyDataSourceAutoConfiguration
class DataSourcePostProcessorConfig(
    private val environment: Environment,
) : BeanPostProcessor {
    private val log = KotlinLogging.logger {}
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any {

        val annotation =
            AnnotationUtils.findAnnotation(bean.javaClass, MyDataSourceConfigurationProperties::class.java) ?: return bean

        val annotationAttributes = AnnotationUtils.getAnnotationAttributes(annotation)
        val prefix = annotationAttributes["prefix"].toString()
        val bindOrCreate = Binder.get(environment).bindOrCreate(prefix, bean.javaClass)
        return bindOrCreate
    }
}
