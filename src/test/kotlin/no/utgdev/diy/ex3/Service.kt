package no.utgdev.diy.ex3

import java.util.*
import no.utgdev.diy.annotations.Inject;

class Service {
    @Inject
    private val helloDao: HelloDao? = null

    @Inject
    private val worldDao: WorldDao? = null
    fun fragments(): List<String?> {
        return Arrays.asList(
            helloDao!!.hello(),
            worldDao!!.world()
        )
    }
}