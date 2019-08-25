package no.utgdev.diy.ex6;

//REMOVE import no.utgdev.diy.annotations.Component;
//REMOVE import no.utgdev.diy.annotations.Inject;

//REMOVE @Component
public class MinComponent {
    //REMOVE @Inject
    private MinService service;

    public String hei() {
        return "Hei fra MinComponent og " + service.hei();
    }
}
