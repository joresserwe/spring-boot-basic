package me.joresserwe.helloboot

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class HelloServiceTest:FunSpec({
    test("helloServiceTest") {
        val helloService = SimpleHelloService()
        val ret = helloService.sayHello("Test")
        ret shouldBe "Hello Test"
    }
})
