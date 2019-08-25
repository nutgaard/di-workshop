package no.utgdev.diy.ex5;

public class HelloDao {
    private String value = "Hello";

    public HelloDao() {}

    public HelloDao(String value) {
        this.value = value;
    }

    public String hello() {
        return value;
    }
}
