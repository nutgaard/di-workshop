package no.utgdev.diy.ex7;

import no.utgdev.diy.annotations.Component;
import no.utgdev.diy.annotations.Inject;
import no.utgdev.diy.annotations.PostConstruct;

@Component
public class MinComponent {
    @Inject
    private MinService service;

    private String serviceHei;

    public String hei() {
        return "Hei fra MinComponent og " + serviceHei;
    }

    @PostConstruct
    private void setup() {
        this.serviceHei = service.hei().toUpperCase();
    }
}
