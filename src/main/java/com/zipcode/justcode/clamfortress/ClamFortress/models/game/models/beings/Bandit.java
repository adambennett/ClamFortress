package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;

@Entity
public class Bandit extends Monster {

    @Id
    @ManyToOne(optional = false)
    @JoinTable(name = "bandits")
    private Village village;

    public Bandit() {}

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }
}
