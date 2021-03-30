package no.utgdev.diy.ex6

//REMOVE import no.utgdev.diy.annotations.Component;
//REMOVE import no.utgdev.diy.annotations.Inject;

//REMOVE @Component
class MinComponent {
    //REMOVE @Inject
    private val service: MinService? = null
    fun hei(): String {
        return "Hei fra MinComponent og " + service!!.hei()
    }
}