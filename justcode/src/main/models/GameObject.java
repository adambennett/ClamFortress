package main.models;

import main.actions.*;
import main.encounters.*;
import main.encounters.disasters.*;
import main.encounters.miracles.*;
import main.encounters.plagues.*;
import main.models.animals.*;
import main.models.buildings.abstracts.*;
import main.models.nodes.*;
import main.models.people.*;

import java.util.*;

public abstract class GameObject implements Cloneable {

    private String name;

    public GameObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Trigger when the corresponding phase starts
    public void standbyPhase() {}
    public void priorityPhase() {}
    public void endPhase() {}

    // Multiply fish/hunt food gain
    public Integer multiplyFoodOnFishing() { return 1; }
    public Integer multiplyFoodOnHunting() { return 1; }

    // Add to various modifiers
    public Integer modifyFaithInc() { return 0; }
    public Integer modifyAtk() { return 0; }
    public Integer modifyDef() { return 0; }
    public Integer modifyPriorityPoints() { return 0; }
    public Integer modifyDateIncrease() { return 0; }
    public Integer modifyPopCapIncreases() { return 0; }
    public Integer modifyResourceStorageIncreases() { return 0; }

    // Print special messages at the end of turn report
    public String addToEndTurnReportTop() { return ""; }
    public String addToEndTurnReportBot() { return ""; }

    // On specific triggers, run behavior
    public void onSpendPriorityPoints(int diff) {}
    public void onDiscoverNewRegion(AbstractNode newNode) {}
    public void onAddAnimalToBoard(AbstractAnimal animal) {}
    public void onGatherFood(AbstractGameAction gatheringType) {}
    public void afterRunAction(AbstractGameAction gatheringType) {}
    public void onNewCitizen(Survivor newCitizen) {}
    public void onLoseCitizen(Survivor newCitizen) {}
    public void onNewBuilding(AbstractBuilding b) {}
    public void onNewMiracle(AbstractMiracle m) {}
    public void onNewDisaster(AbstractDisaster d) {}
    public void onNewPlague(AbstractPlague p) {}
    public void onRunSpecialEncounter(AbstractEncounter enc) {}
    public void onDateAdvance(int daysAdvanced) {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameObject)) return false;
        GameObject that = (GameObject) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public abstract GameObject clone();
}
