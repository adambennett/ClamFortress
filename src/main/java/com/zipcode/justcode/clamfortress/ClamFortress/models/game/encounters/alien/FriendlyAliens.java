package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.alien;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

import java.util.*;

public class FriendlyAliens extends AlienEncounter {
    public FriendlyAliens(int turns) {
        super("Friendly Aliens", "Temp desc", turns);
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
        return "Friendly Aliens have visited your game...";
    }

    @Override
    public FriendlyAliens clone() {
        return new FriendlyAliens(this.turnsActive);
    }
}
