package me.joresserwe.config.autoconfg

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.DispatcherServlet

@Configuration
class DispatcherServletConfig {
    @Bean
    fun dispatcherServlet() = DispatcherServlet()
}
