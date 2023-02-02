package me.joresserwe.study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.types.instanceOf
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata

class ConditionalTest : FunSpec() {

    init {
        test("conditional") {
            val runner = ApplicationContextRunner()
            runner.withUserConfiguration(Config1::class.java)
                .run { context ->
                    context.getBean(Config1::class.java) should instanceOf<Config1>()
                    context.getBean(MyBean::class.java) should instanceOf<MyBean>()
                }

            ApplicationContextRunner().withUserConfiguration(Config2::class.java)
                .run { context ->
                    shouldThrow<NoSuchBeanDefinitionException> { context.getBean(Config2::class.java) }
                    shouldThrow<NoSuchBeanDefinitionException> { context.getBean(MyBean::class.java) }
                }
        }
    }

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.CLASS)
    @Conditional(BooleanCondition::class)
    annotation class BooleanConditional(
        val value: Boolean
    )

    @Configuration
    @BooleanConditional(true)
    class Config1 {
        @Bean
        fun myBean() = MyBean()
    }

    @Configuration
    @BooleanConditional(false)
    class Config2 {
        @Bean
        fun myBean() = MyBean()
    }

    class MyBean

    class BooleanCondition : Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            val annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional::class.java.name)!!
            return annotationAttributes["value"] as Boolean
        }
    }
}
