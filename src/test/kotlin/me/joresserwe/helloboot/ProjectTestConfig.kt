package me.joresserwe.helloboot

import io.kotest.core.config.AbstractProjectConfig

object ProjectTestConfig : AbstractProjectConfig() {
    /* override val parallelism = 3
     override val assertionMode = AssertionMode.Error
     override val globalAssertSoftly = true
     override val failOnIgnoredTests = false*/
    //override val isolationMode = IsolationMode.InstancePerLeaf

//    override fun extensions() = listOf(SpringExtension)
}
