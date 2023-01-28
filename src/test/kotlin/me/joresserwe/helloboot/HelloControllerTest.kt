package me.joresserwe.helloboot

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class HelloControllerTest:FunSpec({
    test("helloControllerTest") {
        val controller = HelloController { it }
        val ret = controller.hello("Test")
        ret shouldBe "Test"
    }

    test("failsHelloController") {
        val controller = HelloController { it }
        shouldThrow<IllegalArgumentException> { controller.hello(null) }
    }
})
