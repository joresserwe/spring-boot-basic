package me.joresserwe.config.autoconfig

import me.joresserwe.config.MyAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.DispatcherServlet

@MyAutoConfiguration
class DispatcherServletConfig {
    @Bean
    fun dispatcherServlet() = DispatcherServlet()
}
