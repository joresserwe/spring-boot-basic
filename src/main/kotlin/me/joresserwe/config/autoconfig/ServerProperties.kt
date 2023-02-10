package me.joresserwe.config.autoconfig

@MyConfigurationProperties(prefix = "server")
class ServerProperties {
    lateinit var contextPath: String
    var port: Int = 0
}

