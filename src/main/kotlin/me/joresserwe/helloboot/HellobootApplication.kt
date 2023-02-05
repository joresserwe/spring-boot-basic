package me.joresserwe.helloboot

import me.joresserwe.config.MySpringBootApplication
import org.springframework.boot.runApplication

@MySpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
