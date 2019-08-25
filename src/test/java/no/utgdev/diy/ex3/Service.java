package no.utgdev.diy.ex3;

//REMOVE import no.utgdev.diy.annotations.Inject;

import java.util.List;

import static java.util.Arrays.asList;

public class Service {
    //REMOVE @Inject
    private HelloDao helloDao;

    //REMOVE @Inject
    private WorldDao worldDao;

    public List<String> fragments() {
        return asList(
                helloDao.hello(),
                worldDao.world()
        );
    }
}
