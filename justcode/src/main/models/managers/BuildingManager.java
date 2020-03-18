package main.models.managers;

import main.models.buildings.abstracts.*;
import main.models.buildings.concrete.faith.*;
import main.models.buildings.concrete.housing.*;

public class BuildingManager {

    public static AbstractBuilding getRandomBuilding() {
        return new SmallWoodHome();
    }
}
