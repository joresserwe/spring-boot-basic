package me.joresserwe.helloboot

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.DispatcherServlet

@Configuration
@ComponentScan
class HellobootApplication {

    @Bean
    fun dispatcherServlet() = DispatcherServlet()

    @Bean
    fun servletWebServerFactory() = TomcatServletWebServerFactory()
}

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}



