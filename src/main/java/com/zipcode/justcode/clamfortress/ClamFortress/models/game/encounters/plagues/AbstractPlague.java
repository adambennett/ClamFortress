package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import javax.persistence.*;
import java.util.concurrent.*;



public abstract class AbstractPlague extends AbstractEncounter {

    public AbstractPlague(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public void runEncounter() {
        /*if (Database.getCurrentGame().getVillage().getInventory().containsItem("vaccine")) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                Database.getCurrentGame().getVillage().addPlague(this);
            }
        } else {
            Database.getCurrentGame().getVillage().addPlague(this);
        }*/
    }
}
