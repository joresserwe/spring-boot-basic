package me.joresserwe.helloboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.web.servlet.DispatcherServlet

class MySpringApplication {
    companion object {
        fun <T> run(applicationClass: Class<T>, vararg args: String) {
            val applicationContext = object : AnnotationConfigServletWebApplicationContext() {
                override fun onRefresh() {
                    super.onRefresh()
                    val serverFactory = this.getBean(ServletWebServerFactory::class.java)
                    val dispatcherServlet = this.getBean(DispatcherServlet::class.java)
                    val webServer = serverFactory.getWebServer({ servletContext ->
                        servletContext
                            .addServlet("dispatcherServlet", dispatcherServlet) // WebApplcationContext를 주입해야함
                            .addMapping("/*") // 모든 요청을 해당 Servlet이 처리하겠다.
                    })
                    webServer.start() // Tomcat 동작
                }
            }
            applicationContext.register(applicationClass)
            applicationContext.refresh()
        }
    }
}

inline fun <reified T> runApplication(vararg args: String) {
    SpringApplication.run(T::class.java, *args)
}
