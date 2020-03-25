package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;
import java.util.concurrent.*;


@Entity
public abstract class AbstractPlague extends AbstractEncounter {

    @Id
    @ManyToOne(optional = false)
    @JoinTable(name = "plagues")
    private Village village;

    public AbstractPlague() { super("Plague", "Desc", 99); }

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

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }
}
