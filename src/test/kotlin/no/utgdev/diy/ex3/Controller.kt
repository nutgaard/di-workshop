package no.utgdev.diy.ex3

import no.utgdev.diy.annotations.Inject;

class Controller {
    @Inject
    private val service: Service? = null
    fun helloWorld(): String {
        return java.lang.String.join(", ", service!!.fragments())
    }
}