package me.joresserwe.helloboot

import org.springframework.beans.factory.*
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.context.*
import org.springframework.core.env.Environment
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component
import org.springframework.util.StringValueResolver
import org.springframework.web.context.ServletContextAware
import javax.annotation.PostConstruct
import javax.servlet.ServletContext

@Component
class BeanLifeCycleTest : BeanNameAware,
    BeanClassLoaderAware,
    BeanFactoryAware,
    EnvironmentAware,
    EmbeddedValueResolverAware,
    ResourceLoaderAware,
    ApplicationEventPublisherAware,
    MessageSourceAware,
    ApplicationContextAware,
    ServletContextAware,
    InitializingBean {

    override fun setBeanName(name: String) {
        println("#1:BeanNameAware::setBeanName : $name")
    }

    override fun setBeanClassLoader(classLoader: ClassLoader) {
        println("#2:BeanClassLoaderAware::setBeanClassLoader : $classLoader")
    }

    override fun setBeanFactory(beanFactory: BeanFactory) {
        println("#3:BeanFactoryAware::setBeanFactory : $beanFactory")
    }

    override fun setEnvironment(environment: Environment) {
        println("#4:EnvironmentAware::setEnvironment")
    }

    override fun setEmbeddedValueResolver(resolver: StringValueResolver) {
        println("#5:EmbeddedValueResolverAware::setEmbeddedValueResolver : $resolver")
    }

    override fun setResourceLoader(resourceLoader: ResourceLoader) {
        println("#6:ResourceLoaderAware::setResourceLoader : $resourceLoader")
    }

    override fun setApplicationEventPublisher(applicationEventPublisher: ApplicationEventPublisher) {
        println("#7:ApplicationEventPublisherAware::setApplicationEventPublisher : $applicationEventPublisher")
    }

    override fun setMessageSource(messageSource: MessageSource) {
        println("#8:MessageSourceAware::setMessageSource : $messageSource")
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        println("#9:ApplicationContextAware::setApplicationContext : $applicationContext")
    }

    override fun setServletContext(servletContext: ServletContext) {
        println("#10:ServletContextAware::setServletContext : $servletContext")
    }

    @Component
    class BeanPostProcessorImpl : BeanPostProcessor {
        override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any {
            if (bean !is BeanLifeCycleTest) return bean
            println("#11: postProcessBeforeInitialization")
            return bean
        }

        override fun postProcessAfterInitialization(bean: Any, beanName: String): Any {
            if (bean !is BeanLifeCycleTest) return bean
            println("#14: postProcessAfterInitialization")
            return bean
        }
    }

    @PostConstruct
    fun postConstruct() {
        println("#12: @postConstruct")
    }

    override fun afterPropertiesSet() {
        println("#13: InitializingBean::afterPropertiesSet")
    }

}

