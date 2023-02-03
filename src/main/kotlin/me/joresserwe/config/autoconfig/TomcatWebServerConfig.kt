package me.joresserwe.config.autoconfig

import me.joresserwe.config.ConditionalMyOnClass
import me.joresserwe.config.MyAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean

//@Conditional(TomcatWebServerConfig.TomcatCondition::clas"s)
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
class TomcatWebServerConfig {
    // Deffered를 사용하는 이유
    // 사용자가 만든 구성정보를 모두 띄운 후, 자동 구성 정보를 사용한다.
    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean // 같은 Type의 Bean이 있을 때만.
    fun servletWebServerFactory() = TomcatServletWebServerFactory()
}
