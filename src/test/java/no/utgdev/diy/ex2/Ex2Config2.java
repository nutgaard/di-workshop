package no.utgdev.diy.ex2;

import no.utgdev.diy.annotations.Bean;

import java.util.Collections;
import java.util.Map;

public class Ex2Config2 {
    @Bean
    public double number() {
        return 2.0;
    }

    @Bean
    public Map<String, String> map() {
        return Collections.emptyMap();
    }
}
