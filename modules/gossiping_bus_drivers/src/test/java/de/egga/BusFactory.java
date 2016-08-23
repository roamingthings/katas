package de.egga;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;

public class BusFactory {

    static Bus anyBus() {
        return new Bus(randomUUID().toString(), anyRoute());
    }

    static List<Integer> anyRoute() {
        return asList(1, 2, 3);
    }
}
