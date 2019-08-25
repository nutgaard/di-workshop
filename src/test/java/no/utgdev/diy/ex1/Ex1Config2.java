package no.utgdev.diy.ex1;

import no.utgdev.diy.annotations.Bean;

import java.util.Collections;
import java.util.Map;

public class Ex1Config2 {
    @Bean
    public double number() {
        return 2.0;
    }

    @Bean
    public Map<String, String> map() {
        return Collections.emptyMap();
    }
}
