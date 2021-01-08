package cc.popkorn.example

import cc.popkorn.*
import cc.popkorn.core.model.Environment
import cc.popkorn.example.model.*

fun main() {
    val d10 = D10()
    popKorn().addInjectable(d10)

    val string1 by popkorn<R2i>()
    val string2 by injecting<R2i>()
    val string3 by creating<R2i>("", 33)

    inject<String>()
    inject<Int>()

    inject<R1i>()
    inject<R2i>()
    inject<R3i>()
    inject<R4i>("envX")
    inject<R5i>()

    System.gc()
    popKorn().purge()

    inject<R6i>()
    inject<R7i>()
    inject<R8i>()
    inject<R8i>("env1")
    inject<R8i>("env2")
    inject<R8i>("env3")
    inject<R8i>("env4")
    inject<R9i>()

    create<R10i> {
        add(10L)
        add(R9())
    }
    val c1 by creating<R10i>(10L, R9())

    create<R10i>("env2") {
        add(10L)
        add(R10())
    }
    val c2 by creating<R10i>(Environment("env2"), 10L, R10())

    create<R8i>()
    val c3 by creating<R8i>()

    create<R8i>("env1")
    val c4 by creating<R8i>("env1")

    popKorn().removeInjectable(d10::class)
    popKorn().reset()

    println("ok")
    ExampleCompat().execute()
}
