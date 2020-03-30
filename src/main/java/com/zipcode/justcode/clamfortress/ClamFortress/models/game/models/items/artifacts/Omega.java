package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class Omega extends AbstractArtifact implements Unique {

    public Omega() {
        super("Omega", "The Omega object.");
    }

    public Integer multiplyFoodOnFishing() { return 10; }
    public Integer multiplyFoodOnHunting() { return 10; }
    public Integer modifyFaithInc() { return 100; }
    public Integer modifyAtk() { return 100; }
    public Integer modifyWeaponDmg(AbstractWeapon weapon) { return 100; }
    public Integer modifyDef() { return 100; }
    public Integer modifyArmorDef(AbstractArmor armor) { return 100; }
    public Integer modifyPopCapIncreases() { return 100; }
    public Integer modifyResourceStorageIncreases() { return 1000; }
    public Integer modifyMaxHPOnPickup() { return 10; }
    public String addToEndTurnReportTop() { return "OMEGA"; }
    public String addToEndTurnReportBot() { return "OMEGA"; }
    public Integer modifyPriorityPoints() {
        int pts = PriorityManager.getPointsRemaining();
        if (pts > 10) {
            int amt = ThreadLocalRandom.current().nextInt(10, PriorityManager.getPointsRemaining() * 2);
            OutputManager.addToBot("OMEGA -- Priority Points awarded: " + amt);
            return amt;
        }
        return 0;
    }
    public void onNewBuilding(AbstractBuilding b) {
        int amt = b.getDesc().length();
        if (amt > 0) {
            ArrayList<AbstractResource> res = Archive.getInstance().generateNewResources("coins", amt);
            Database.getCurrentGame().getVillage().addResources(res);
            OutputManager.addToBot("OMEGA: GENERATED " + amt + " COINS FROM NEW BUILDING DESCRIPTION LENGTH!");
        }
    }

    @Override
    public Omega clone() {
        return new Omega();
    }

}
