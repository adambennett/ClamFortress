package main.models.managers;

import main.models.buildings.abstracts.*;
import main.models.buildings.concrete.faith.*;

import java.util.concurrent.*;

public class BuildingManager {

    public static AbstractBuilding getRandomBuilding() {
        return new WoodenChurch(ThreadLocalRandom.current().nextInt(1, 10), 5);
    }
}
