package no.utgdev.diy.ex2;

import no.utgdev.diy.annotations.Bean;
import no.utgdev.diy.annotations.Import;

import java.util.Collections;
import java.util.List;

@Import(Ex2Config2.class)
public class Ex2Config {
    @Bean
    public List<String> list() {
        return Collections.emptyList();
    }

    @Bean
    public String string() {
        return "";
    }
}
