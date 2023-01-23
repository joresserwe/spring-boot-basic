package me.joresserwe.helloboot

import org.springframework.beans.factory.*
import org.springframework.context.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
class HelloController(
    private val helloService: HelloService
) {

    @GetMapping("/hello")
    fun hello(name: String?): String {
        return helloService.sayHello(requireNotNull(name))
    }

    @PostConstruct
    fun postcon() = println("sdfsadfsadfsadfsdaffsadfsdfsdafsdfsdf")
}

