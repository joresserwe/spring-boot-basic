package me.joresserwe.helloboot

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

@Retention
@Target(AnnotationTarget.FUNCTION)
@UnitTest
annotation class FastUnitTest

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION)
annotation class UnitTest

class HelloServiceTest : FunSpec({
    test("helloServiceTest") {
        val helloService = SimpleHelloService(getHelloRepository())
        val ret = helloService.sayHello("Test")
        ret shouldBe "Hello Test"
    }

    test("helloDecorator") {
        val decorator = HelloDecorator { it }
        val ret = decorator.sayHello("hello Test")
        ret shouldBe "*hello Test*"
    }
})

private fun getHelloRepository() = object : HelloRepository {
    override fun findHello(name: String): Hello? {

        return null
    }

    override fun increaseCount(name: String) {
    }
}
