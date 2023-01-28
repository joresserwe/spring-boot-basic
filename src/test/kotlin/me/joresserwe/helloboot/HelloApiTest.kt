package me.joresserwe.helloboot

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class HelloApiTest : FunSpec({
    test("helloApi") {
        // http://127.0.0.1:8080/hello?name=Spring
        // HTTPie
        val rest = TestRestTemplate()
        val response =
            rest.getForEntity("http://127.0.0.1:8080/hello?name={name}", String::class.java, "Spring")
        response.statusCode shouldBe HttpStatus.OK
        response.headers.contentType.toString() shouldBe startWith(MediaType.TEXT_PLAIN_VALUE)
        response.body shouldBe "Hello Spring"
    }
})
