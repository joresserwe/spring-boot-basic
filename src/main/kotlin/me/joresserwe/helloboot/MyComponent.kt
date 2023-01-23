package me.joresserwe.helloboot

import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE)
@Component
annotation class MyComponent()
