package no.utgdev.diy.ex5

//REMOVE import no.utgdev.diy.annotations.Inject;
//REMOVE import no.utgdev.diy.annotations.Named;

class Controller2 : Controller {
    //REMOVE @Inject
    //REMOVE @Named("hello-dao2")
    private val service: HelloDao? = null
    override fun helloWorld(): String {
        return java.lang.String.join(", ", service!!.hello())
    }
}