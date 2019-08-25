package no.utgdev.diy.ex7;

//REMOVE import no.utgdev.diy.annotations.Component;
//REMOVE import no.utgdev.diy.annotations.Inject;
//REMOVE import no.utgdev.diy.annotations.PostConstruct;

//REMOVE @Component
public class MinComponent {
    //REMOVE @Inject
    private MinService service;

    private String serviceHei;

    public String hei() {
        return "Hei fra MinComponent og " + serviceHei;
    }

    //REMOVE @PostConstruct
    private void setup() {
        this.serviceHei = service.hei().toUpperCase();
    }
}
