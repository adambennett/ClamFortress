package main.models;

import main.actions.*;
import main.encounters.*;
import main.encounters.disasters.*;
import main.encounters.miracles.*;
import main.encounters.plagues.*;
import main.models.animals.*;
import main.models.buildings.abstracts.*;
import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.items.military.*;
import main.models.items.military.armor.*;
import main.models.items.military.weapons.*;
import main.models.nodes.*;
import main.models.people.*;
import main.models.resources.*;
import main.models.tech.eras.*;

import java.util.*;
import java.util.concurrent.*;

public abstract class GameObject implements Cloneable, Comparable<GameObject> {

    private String name;
    private String desc;

    public GameObject(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getDesc() { return desc; }

    // Trigger when the corresponding phase starts
    public void standbyPhase() {}
    public void priorityPhase() {}
    public void endPhase() {}

    // Prevention hooks
    public Boolean canObtain() { return true; }
    public Boolean canAddVillagers() { return true; }
    public Boolean canGainExp() { return true; }
    public Boolean canBuildAnything() { return true; }
    public Boolean canAddResourcesToBoard() { return true; }
    public Boolean canEncounterEvents() { return true; }
    public Boolean canGatherFood() { return true; }
    public Boolean canHeal() { return true; }
    public Boolean canFight() { return true; }
    public Boolean canOutputMessages() { return true; }

    // Multiply fish/hunt food gain
    public Integer multiplyFoodOnFishing() { return 1; }
    public Integer multiplyFoodOnHunting() { return 1; }

    // Add to various modifiers
    public Integer modifyFaithInc() { return 0; }
    public Integer modifyAtk() { return 0; }
    public Integer modifyWeaponDmg(AbstractWeapon weapon) { return 0; }
    public Integer modifyDef() { return 0; }
    public Integer modifyArmorDef(AbstractArmor armor) { return 0; }
    public Integer modifyPriorityPoints() { return 0; }
    public Integer modifyDateIncrease() { return 0; }
    public Integer modifyPopCapIncreases() { return 0; }
    public Integer modifyResourceStorageIncreases() { return 0; }
    public Integer modifyMaxHPOnPickup() { return 0; }

    // Print special messages at the end of turn report
    public String addToEndTurnReportTop() { return ""; }
    public String addToEndTurnReportBot() { return ""; }

    // On specific triggers, run behavior
    public void onObtain() {}
    public void onSpendPriorityPoints(int diff) {}
    public void onAddAnimalToBoard(AbstractAnimal animal) {}
    public void onGatherFood(AbstractGameAction gatheringType) {}
    public Survivor onNewCitizen(Survivor newCitizen) { return newCitizen; }
    public void onLoseCitizen(Survivor newCitizen) {}
    public void onNewBuilding(AbstractBuilding b) {}
    public void onNewMiracle(AbstractMiracle m) {}
    public void onNewDisaster(AbstractDisaster d) {}
    public void onNewPlague(AbstractPlague p) {}
    public void onRunSpecialEncounter(AbstractEncounter enc) {}
    public void onDateAdvance(int daysAdvanced) {}
    public void onDemolish() {}
    public void onHeal() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameObject)) return false;
        GameObject that = (GameObject) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDesc(), that.getDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDesc());
    }

    @Override
    public abstract GameObject clone();

    @Override
    public int compareTo(GameObject o) {
        return this.getClassName().compareTo(o.getClassName()) != 0 ? this.getClassName().compareTo(o.getClassName()) : this.getName().compareTo(o.getName());
    }

    public String getClassName() {
        if (this instanceof AbstractAnimal) {
            return "Animal";
        } else if (this instanceof AbstractBuilding) {
            return "Building";
        } else if (this instanceof AbstractArtifact) {
            return "Artifact";
        } else if (this instanceof AbstractItem) {
            return "Item";
        } else if (this instanceof Era) {
            return "Era";
        } else if (this instanceof AbstractResource) {
            return "Resource";
        }
        return "Game Object";
    }
}
