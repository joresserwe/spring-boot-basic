package me.joresserwe.config.autoconfig

import me.joresserwe.config.ConditionalMyOnClass
import me.joresserwe.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.context.annotation.Bean

//@Conditional(JettyWebServerConfig.JettyCondition::class)
@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory() = JettyServletWebServerFactory()
}
