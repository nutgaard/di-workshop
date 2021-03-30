package no.utgdev.diy.ex3

import java.util.*
//REMOVE import no.utgdev.diy.annotations.Inject;

class Service {
    //REMOVE @Inject
    private val helloDao: HelloDao? = null

    //REMOVE @Inject
    private val worldDao: WorldDao? = null
    fun fragments(): List<String?> {
        return Arrays.asList(
            helloDao!!.hello(),
            worldDao!!.world()
        )
    }
}