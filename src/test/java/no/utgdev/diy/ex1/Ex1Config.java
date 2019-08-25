package no.utgdev.diy.ex1;

//REMOVE import no.utgdev.diy.annotations.Bean;
//REMOVE import no.utgdev.diy.annotations.Import;

import java.util.Collections;
import java.util.List;

//REMOVE @Import(Ex1Config2.class)
public class Ex1Config {
    //REMOVE @Bean
    public List<String> list() {
        return Collections.emptyList();
    }

    //REMOVE @Bean
    public String string() {
        return "";
    }
}
