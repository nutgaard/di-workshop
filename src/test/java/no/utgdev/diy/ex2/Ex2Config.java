package no.utgdev.diy.ex2;

//REMOVE import no.utgdev.diy.annotations.Bean;
//REMOVE import no.utgdev.diy.annotations.Import;

import java.util.Collections;
import java.util.List;

//REMOVE @Import(Ex2Config2.class)
public class Ex2Config {
    //REMOVE @Bean
    public List<String> list() {
        return Collections.emptyList();
    }

    //REMOVE @Bean
    public String string() {
        return "";
    }
}
