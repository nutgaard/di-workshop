package no.utgdev.diy.ex6

import no.utgdev.diy.annotations.Component;
import no.utgdev.diy.annotations.Inject;

@Component
class MinComponent {
    @Inject
    private val service: MinService? = null
    fun hei(): String {
        return "Hei fra MinComponent og " + service!!.hei()
    }
}