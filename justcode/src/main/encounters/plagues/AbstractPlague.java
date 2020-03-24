package main.encounters.plagues;

import main.encounters.*;
import main.models.*;

import java.util.concurrent.*;

public abstract class AbstractPlague extends AbstractEncounter {
    public AbstractPlague(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public void runEncounter() {
        if (Game.getVillage().getInventory().containsItem("vaccine")) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                Game.getVillage().addPlague(this);
            }
        } else {
            Game.getVillage().addPlague(this);
        }
    }
}
