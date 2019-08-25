package no.utgdev.diy.ex6;

import no.utgdev.diy.annotations.Component;
import no.utgdev.diy.annotations.Inject;

@Component
public class MinComponent {
    @Inject
    private MinService service;

    public String hei() {
        return "Hei fra MinComponent og " + service.hei();
    }
}
