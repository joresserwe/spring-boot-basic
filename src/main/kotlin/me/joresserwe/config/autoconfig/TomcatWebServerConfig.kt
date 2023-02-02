package me.joresserwe.config.autoconfig

import me.joresserwe.config.ConditionalMyOnClass
import me.joresserwe.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean

//@Conditional(TomcatWebServerConfig.TomcatCondition::clas"s)
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    fun servletWebServerFactory() = TomcatServletWebServerFactory()
}
