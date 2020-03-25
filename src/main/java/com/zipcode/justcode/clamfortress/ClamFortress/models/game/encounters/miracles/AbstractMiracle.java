package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.miracles;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;

@Entity
public abstract class AbstractMiracle extends AbstractEncounter {

    @Id
    @ManyToOne(optional = false)
    @JoinTable(name = "miracles")
    private Village village;

    public AbstractMiracle() {
        super("Miracle", "Desc", 99);
    }



    public AbstractMiracle(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addMiracle(this);
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

}
