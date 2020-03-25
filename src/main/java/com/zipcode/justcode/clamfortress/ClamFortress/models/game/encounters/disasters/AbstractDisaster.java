package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;

@Entity
public abstract class AbstractDisaster extends AbstractEncounter {

    @Id
    @ManyToOne(optional = false)
    @JoinTable(name = "disasters")
    private Village village;

    public AbstractDisaster() {
        super("Disaster", "Desc", 99);
    }

    public AbstractDisaster(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public abstract void runEncounter();

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }
}
