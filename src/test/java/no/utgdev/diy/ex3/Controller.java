package no.utgdev.diy.ex3;

//REMOVE import no.utgdev.diy.annotations.Inject;

public class Controller {
    //REMOVE @Inject
    private Service service;

    public String helloWorld() {
        return String.join(", ", service.fragments());
    }
}
