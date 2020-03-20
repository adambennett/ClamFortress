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
        ArrayList<AbstractBuilding> allBuilds = new ArrayList<>(Archive.getInstance().buildings());
        ArrayList<AbstractBuilding> buildable = new ArrayList<>();
        for (AbstractBuilding b : allBuilds) {
            if (b.canBuild()) {
                buildable.add(b);
            }
        }
        return buildable.get(ThreadLocalRandom.current().nextInt(buildable.size()));
    }
}
