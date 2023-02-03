package me.joresserwe.helloboot

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
class WebServerConfiguration {

    @Bean
    fun customerWebServerFactory() = TomcatServletWebServerFactory().apply { port = 9090 }
}
