package no.utgdev.diy.ex5;

//REMOVE import no.utgdev.diy.annotations.Inject;
//REMOVE import no.utgdev.diy.annotations.Named;

public class Controller1 implements Controller {
    //REMOVE @Inject
    //REMOVE @Named("hello-dao")
    private HelloDao service;

    public String helloWorld() {
        return String.join(", ", service.hello());
    }
}
