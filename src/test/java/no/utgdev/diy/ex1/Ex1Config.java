package no.utgdev.diy.ex1;

import no.utgdev.diy.annotations.Bean;
import no.utgdev.diy.annotations.Import;

import java.util.Collections;
import java.util.List;

@Import(Ex1Config2.class)
public class Ex1Config {
    @Bean
    public List<String> list() {
        return Collections.emptyList();
    }

    @Bean
    public String string() {
        return "";
    }
}
