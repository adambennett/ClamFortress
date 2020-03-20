package main.models.items.artifacts;

import main.interfaces.*;
import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.items.military.armor.*;
import main.models.items.military.weapons.*;
import main.models.managers.*;
import main.models.people.*;
import main.models.resources.*;

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

    public void onLoseCitizen(Survivor newCitizen) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            Survivor cit = Archive.generateRandomSurvivor(true);
            if (Game.getVillage().addToPopulation(cit)) {
                OutputManager.addToBot("OMEGA: " + cit.getName() + " has replaced " + newCitizen.getName() + " in your village!");
            }
        }
    }
    public void onNewBuilding(AbstractBuilding b) {
        int amt = b.getDesc().length();
        if (amt > 0) {
            ArrayList<AbstractResource> res = Archive.getInstance().generateNewResources("coins", amt);
            Game.getVillage().addResources(res);
            OutputManager.addToBot("OMEGA: GENERATED " + amt + " COINS FROM NEW BUILDING DESCRIPTION LENGTH!");
        }
    }

    @Override
    public Omega clone() {
        return new Omega();
    }

}
