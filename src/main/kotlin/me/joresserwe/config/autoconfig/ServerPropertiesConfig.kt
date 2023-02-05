package me.joresserwe.config.autoconfig

import me.joresserwe.config.MyAutoConfiguration
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MyAutoConfiguration
class ServerPropertiesConfig {

    @Bean
    fun serverProperties(environment: Environment): ServerProperties =
        Binder.get(environment).bind("", ServerProperties::class.java).get()
}
