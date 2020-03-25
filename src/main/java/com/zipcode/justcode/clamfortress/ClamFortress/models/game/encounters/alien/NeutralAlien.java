package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.alien;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

import java.util.*;

public class NeutralAlien extends AlienEncounter {
    public NeutralAlien(int turns) {
        super("Neutral Alien", "Neutral Alien encounter", turns);
    }

    @Override
    public Map<AbstractResource, Integer> dropResources() {
        return null;
    }

    @Override
    public ArrayList<Alien> invade() {
        return null;
    }

    @Override
    public Integer dealDamage(AbstractNode underAtk) {
        return null;
    }

    @Override
    public void runEncounter() {

    }

    @Override
    public String toString() {
        return "Aliens walk among us...";
    }

    @Override
    public NeutralAlien clone() {
        return new NeutralAlien(this.turnsActive);
    }
}
