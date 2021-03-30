package no.utgdev.diy.ex5

//REMOVE import no.utgdev.diy.annotations.Inject;
//REMOVE import no.utgdev.diy.annotations.Named;

class Controller1 : Controller {
    //REMOVE @Inject
    //REMOVE @Named("hello-dao")
    private val service: HelloDao? = null
    override fun helloWorld(): String {
        return java.lang.String.join(", ", service!!.hello())
    }
}