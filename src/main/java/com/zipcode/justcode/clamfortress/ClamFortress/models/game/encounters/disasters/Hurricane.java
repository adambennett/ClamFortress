package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;

public class Hurricane extends AbstractDisaster {

    public Hurricane(int turns) {
        super("Hurricane " + GameStrings.getRandomName(false), "A huge hurricane that impacts your village with devastation.", turns);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "Hurricane " + this.getName() + " has created havoc in your village!";
    }

    @Override
    public Hurricane clone() {
        return new Hurricane(this.turnsActive);
    }
}
