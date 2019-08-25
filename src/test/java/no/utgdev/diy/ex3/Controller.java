package no.utgdev.diy.ex3;

import no.utgdev.diy.annotations.Inject;

public class Controller {
    @Inject
    private Service service;

    public String helloWorld() {
        return String.join(", ", service.fragments());
    }
}
