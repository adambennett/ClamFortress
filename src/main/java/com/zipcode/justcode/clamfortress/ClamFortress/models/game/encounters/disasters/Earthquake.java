package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Earthquake extends AbstractDisaster {


    public Earthquake() {
        super("Earthquake", "A massive earthquake that shakes up your village, dealing damage and causing destruction of buildings.", 1);
    }

    @Override
    public void runEncounter() {
        Database.getCurrentGame().getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "There was an Earthquake!";
    }

    @Override
    public Earthquake clone() {
        return new Earthquake();
    }
}
