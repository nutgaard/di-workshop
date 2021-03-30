package no.utgdev.diy.ex7

import no.utgdev.diy.annotations.Component;
import no.utgdev.diy.annotations.Inject;
import no.utgdev.diy.annotations.PostConstruct;

@Component
class MinComponent {
    @Inject
    private val service: MinService? = null
    private var serviceHei: String? = null
    fun hei(): String {
        return "Hei fra MinComponent og $serviceHei"
    }

    @PostConstruct
    private fun setup() {
        serviceHei = service!!.hei().toUpperCase()
    }
}