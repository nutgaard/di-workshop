package no.utgdev.diy.ex3;

import no.utgdev.diy.annotations.Inject;

import java.util.List;

import static java.util.Arrays.asList;

public class Service {
    @Inject
    private HelloDao helloDao;

    @Inject
    private WorldDao worldDao;

    public List<String> fragments() {
        return asList(
                helloDao.hello(),
                worldDao.world()
        );
    }
}
