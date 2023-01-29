package me.joresserwe.study

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

class ConfigurationTest : FunSpec() {

    init {
        test("configuration") {

            val context = AnnotationConfigApplicationContext(MyConfig::class.java)

            val bean1 = context.getBean(Bean1::class.java)
            val bean2 = context.getBean(Bean2::class.java)

            bean1.common shouldNotBeSameInstanceAs bean2.common
        }
    }

    class MyConfig {
        @Bean
        fun common() = Common()

        @Bean
        fun bean1() = Bean1(common())

        @Bean
        fun bean2() = Bean2(common())
    }

    class Bean1(val common: Common)
    class Bean2(val common: Common)
    class Common
}
