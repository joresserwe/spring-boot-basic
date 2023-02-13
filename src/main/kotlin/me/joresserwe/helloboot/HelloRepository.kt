package me.joresserwe.helloboot

interface HelloRepository {

    fun findHello(name: String): Hello?

    fun increaseCount(name: String)

    fun countOf(name: String) = findHello(name)?.count ?: 0

}
