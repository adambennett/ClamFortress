package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;

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
        return (buildable.size() > 0) ? buildable.get(ThreadLocalRandom.current().nextInt(buildable.size())) : (allBuilds.size() > 0) ? allBuilds.get(ThreadLocalRandom.current().nextInt(allBuilds.size())) : null;
    }
}
