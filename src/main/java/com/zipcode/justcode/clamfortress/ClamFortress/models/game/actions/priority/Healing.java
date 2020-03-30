package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class Healing extends AbstractGameAction {


    public Healing(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
            obj.onHeal();
        }

        if (Database.getCurrentGame().getVillage().getPopulation().size() > 0) {
            ArrayList<Survivor> dmged = new ArrayList<>();
            for (Survivor s : Database.getCurrentGame().getVillage().getPopulation()) {
                if (s.getHP() < s.getMaxHp()) {
                    dmged.add(s);
                }
            }
            if (dmged.size() > 0) {
                Survivor hurtGuy = dmged.get(ThreadLocalRandom.current().nextInt(dmged.size()));
                boolean hasAntibiotic = Database.getCurrentGame().getVillage().getInventory().containsItem("antibiotic");
                boolean hasBandage = Database.getCurrentGame().getVillage().getInventory().containsItem("bandage");
                if (hasAntibiotic) {
                    hurtGuy.setHealthPoints(hurtGuy.getMaxHp());
                    OutputManager.addToBot("Healed " + hurtGuy.getName() + " to full health! [ANTIBIOTIC]");
                } else if (hasBandage) {
                    int diff = hurtGuy.getMaxHp() - hurtGuy.getHP();
                    if (diff > 10) {
                        diff = ThreadLocalRandom.current().nextInt(10, diff);
                    }
                    hurtGuy.setHealthPoints(hurtGuy.getHP() + diff);
                    OutputManager.addToBot("Healed " + hurtGuy.getName() + " by " + diff + "! [BANDAGE]");
                } else {
                    int diff = hurtGuy.getMaxHp() - hurtGuy.getHP();
                    if (diff > 1) {
                        diff = ThreadLocalRandom.current().nextInt(1, diff);
                    }
                    hurtGuy.setHealthPoints(hurtGuy.getHP() + diff);
                    OutputManager.addToBot("Healed " + hurtGuy.getName() + " by " + diff + "!");
                }
            } else {
                OutputManager.addToBot(OutputFlag.NO_DAMAGE, "Nobody in your village is hurt!");
            }
        }
        this.isDone = true;
    }

    @Override
    public Healing clone() {
        return new Healing(this.amountToRun);
    }
}
