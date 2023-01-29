package me.joresserwe.config.autoconfg

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TomcatWebServerConfig {
    @Bean
    fun servletWebServerFactory() = TomcatServletWebServerFactory()
}
