package me.joresserwe.config.autoconfig

import me.joresserwe.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.context.annotation.Bean

@MyAutoConfiguration
class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory() = JettyServletWebServerFactory()
}
