package main.models.managers;

import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.buildings.concrete.faith.*;
import main.models.buildings.concrete.housing.*;
import main.models.items.artifacts.*;

import java.util.*;
import java.util.concurrent.*;

public class BuildingManager {

    public static AbstractBuilding getRandomBuilding() {
        ArrayList<AbstractBuilding> artifacts = new ArrayList<>(Archive.getInstance().buildings());
        return artifacts.get(ThreadLocalRandom.current().nextInt(artifacts.size()));
    }
}
