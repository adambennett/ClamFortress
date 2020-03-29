package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.miracles.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.ammo.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.plating.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.backpacks.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras.*;

import java.util.*;

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
    /*
    public Boolean canAddVillagers() { return true; }
    public Boolean canGainExp() { return true; }
    public Boolean canBuildAnything() { return true; }
    public Boolean canAddResourcesToBoard() { return true; }
    public Boolean canEncounterEvents() { return true; }
    public Boolean canGatherFood() { return true; }
    public Boolean canHeal() { return true; }
    public Boolean canFight() { return true; }
    */

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
    public Integer modifyItemSellPrice() { return 0; }
    public Integer modifyGoldGain(int originalAmt) { return 0; }

    // Print special messages at the end of turn report
    public String addToEndTurnReportTop() { return ""; }
    public String addToEndTurnReportBot() { return ""; }

    // On specific triggers, run behavior
    public void onObtain() {}
    public void onEnemyDeath() {}
    public void onVillagerDeath() {}
    public void onPurchaseItem(GameObject purchased, int pricePaid) {}
    public void onSpendPriorityPoints(int diff) {}
    public void onAddAnimalToBoard(AbstractAnimal animal) {}
    public void onGatherFood(AbstractGameAction gatheringType) {}
    public void onLoseCitizen(Survivor newCitizen) {}
    public void onNewBuilding(AbstractBuilding b) {}
    public void onNewMiracle(AbstractMiracle m) {}
    public void onNewDisaster(AbstractDisaster d) {}
    public void onNewPlague(AbstractPlague p) {}
    public void onRunSpecialEncounter(AbstractEncounter enc) {}
    public void onDateAdvance(int daysAdvanced) {}
    public void onDemolish() {}
    public void onHeal() {}
    public void onAdvanceEra(Era newEra) {}
    public Survivor onNewCitizen(Survivor newCitizen) { return newCitizen; }

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
        return this.getType().compareTo(o.getType()) != 0 ? this.getType().compareTo(o.getType()) : this.getName().compareTo(o.getName());
    }

    public String getType() {
        if (this instanceof AbstractAnimal) {
            return "Animal";
        } else if (this instanceof AbstractMiracle) {
            return "Miracle";
        } else if (this instanceof AbstractPlague) {
            return "Plague";
        }else if (this instanceof AbstractDisaster) {
            return "Disaster";
        }else if (this instanceof AbstractBuilding) {
            return "Building";
        } else if (this instanceof AbstractBackpack) {
            return "Bag";
        } else if (this instanceof AbstractTool) {
            return "Tool";
        } else if (this instanceof AbstractAmmo) {
            return "Ammo";
        } else if (this instanceof AbstractMedievalWeapon) {
            return "Medieval Weapon";
        } else if (this instanceof AbstractGun) {
            return "Gun";
        } else if (this instanceof AbstractWeapon) {
            return "Weapon";
        } else if (this instanceof AbstractArmor || this instanceof AbstractPlating) {
            return "Armor";
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
