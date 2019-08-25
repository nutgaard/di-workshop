package no.utgdev.diy.ex5;

import no.utgdev.diy.annotations.Inject;
import no.utgdev.diy.annotations.Named;

public class Controller2 implements Controller {
    @Inject
    @Named("hello-dao2")
    private HelloDao service;

    public String helloWorld() {
        return String.join(", ", service.hello());
    }
}
