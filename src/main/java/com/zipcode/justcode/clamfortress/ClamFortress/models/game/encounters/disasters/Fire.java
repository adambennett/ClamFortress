package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Fire extends AbstractDisaster {
    public Fire(int turns) {
        super("Fire", "A devastating fire", turns);
    }

    @Override
    public void runEncounter() {
        Database.getCurrentGame().getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Fire ravaging your village for " + this.turnsActive + " turns!";
    }

    @Override
    public Fire clone() {
        return new Fire(this.turnsActive);
    }
}
