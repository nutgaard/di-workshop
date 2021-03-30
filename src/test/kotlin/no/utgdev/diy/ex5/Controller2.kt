package no.utgdev.diy.ex5

import no.utgdev.diy.annotations.Inject;
import no.utgdev.diy.annotations.Named;

class Controller2 : Controller {
    @Inject
    @Named("hello-dao2")
    private val service: HelloDao? = null
    override fun helloWorld(): String {
        return java.lang.String.join(", ", service!!.hello())
    }
}