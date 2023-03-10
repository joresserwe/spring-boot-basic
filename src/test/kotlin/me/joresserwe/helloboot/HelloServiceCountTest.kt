package me.joresserwe.helloboot

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HelloServiceCountTest(
    private val helloService: HelloService,
    private val helloRepository: HelloRepository
) : FunSpec({

    this.test("say hello increase count") {

        (1..10).forEach {
            helloService.sayHello("Cyan")
            helloRepository.countOf("Cyan") shouldBe it
        }
    }
})
