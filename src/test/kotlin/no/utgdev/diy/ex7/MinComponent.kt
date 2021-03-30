package no.utgdev.diy.ex7

//REMOVE import no.utgdev.diy.annotations.Component;
//REMOVE import no.utgdev.diy.annotations.Inject;
//REMOVE import no.utgdev.diy.annotations.PostConstruct;

//REMOVE @Component
class MinComponent {
    //REMOVE @Inject
    private val service: MinService? = null
    private var serviceHei: String? = null
    fun hei(): String {
        return "Hei fra MinComponent og $serviceHei"
    }

    //REMOVE @PostConstruct
    private fun setup() {
        serviceHei = service!!.hei().toUpperCase()
    }
}