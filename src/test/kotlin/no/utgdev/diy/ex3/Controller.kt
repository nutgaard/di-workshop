package no.utgdev.diy.ex3

//REMOVE import no.utgdev.diy.annotations.Inject;

class Controller {
    //REMOVE @Inject
    private val service: Service? = null
    fun helloWorld(): String {
        return java.lang.String.join(", ", service!!.fragments())
    }
}