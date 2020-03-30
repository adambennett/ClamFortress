package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;

import java.util.*;
import java.util.concurrent.*;

public class City extends AbstractNode {

    protected Boolean defeated;
    protected Integer cityDefense;
    protected Integer hp;
    protected Integer maxHP;
    protected ArrayList<Survivor> cityResidence;
    protected String uniqueName;

    public City(int xPos, int yPos) {
        super(xPos, yPos, new Cityscape());
        this.cityResidence = new ArrayList<>();
        this.cityDefense = 10;
        this.hp = 10;
        this.maxHP = 10;
        this.uniqueName = GameStrings.getRandomName(false);
        this.defeated = false;
        setupCity();
    }

    protected void setupCity() {
        int pop = ThreadLocalRandom.current().nextInt(1, 100);
        for (int i = 0; i < pop; i++) {
            Survivor newCitizen = Archive.generateRandomSurvivor(false);
            this.cityResidence.add(newCitizen);
            this.cityDefense += newCitizen.getStrength();
            this.hp += newCitizen.getHP();
            this.maxHP += newCitizen.getMaxHp();
        }
        ArrayList<AbstractResource> res = Archive.getInstance().resources();
        Set<Integer> randIndices = new HashSet<>();
        while (randIndices.size() < 5 && res.size() > 5) {
            randIndices.add(ThreadLocalRandom.current().nextInt(res.size()));
        }
        ArrayList<Integer> ints = new ArrayList<>(randIndices);
        while (ints.size() > 0) {
            int index = ints.remove(0);
            AbstractResource rand = res.get(index);
            this.resources.put(rand, ThreadLocalRandom.current().nextInt(10, 100));
        }
    }

    public Integer dealDamage() {
        int dmg = this.cityDefense / this.cityResidence.size();
        if (dmg > 0) {
            return ThreadLocalRandom.current().nextInt(0, dmg);
        }
        return 0;
    }

    public void takeDamage(int amt) {
        if (this.cityResidence.size() > 0) {
            takeDamage(this.cityResidence.get(ThreadLocalRandom.current().nextInt(this.cityResidence.size())), amt);
        }
    }

    private void takeDamage(Survivor villager, int amt) {
        amt -= this.cityDefense;
        if (amt > 0) {
            if (amt > villager.getHP()) {
                amt = villager.getHP();
            }
            OutputManager.dmg(amt);
            villager.setHealthPoints(villager.getHP() - amt);
            this.setHp(this.hp - amt);
            if (villager.getHP() < 1) {
                removeSurvivor(villager);
                StatTracker.incEnemies(1);
                for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
                    obj.onEnemyDeath();
                }
                OutputManager.kill(1);
            }
            if (this.cityResidence.size() < 1 || this.hp < 1) {
                defeat();
            } else {
                OutputManager.addToBot("Enemy City HP: " + this.hp + " / " + this.maxHP);
            }
        }
    }

    public void removeSurvivor(Survivor s) {
        for (int i = 0; i < this.cityResidence.size(); i++) {
            if (this.cityResidence.get(i).equals(s)) {
                updateAfterRemoving(this.cityResidence.remove(i));
            }
        }
    }

    public void updateAfterRemoving(Survivor s) {
        this.maxHP -= s.getMaxHp();
    }

    protected void defeat() {
        OutputManager.addToBot("Defeated " + this.cityName() + " in a raid!");
        this.defeated = true;
        this.hp = 0;
        this.maxHP = 0;
        if (this.hasArtifact()) {
            GameUtils.obtainArtifact(this.artifact);
        }

        if (this.hasItem()) {
            GameUtils.obtainItem(this.item);
        }

        if (this.resources.size() > 0) {
            Database.getCurrentGame().getVillage().addResources(this.resources);
        }

        if (this.animals.size() > 0) {
            Database.getCurrentGame().getGameBoard().addAnimals(this.animals);
        }
        Database.getCurrentGame().gameManager.getRaidable().remove(this);
        Database.getCurrentGame().gameManager.setDefeatedCities(Database.getCurrentGame().gameManager.getDefeatedCities() + 1);
    }

    public Boolean getDefeated() {
        return defeated;
    }

    public Integer getCityDefense(){
        return this.cityDefense;
    }

    public ArrayList<Survivor> getCityResidence(){
        return this.cityResidence;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
        if (this.hp < 0) {
            this.hp = 0;
        }
        if (this.hp > this.maxHP) {
            this.hp = this.maxHP;
        }
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }

    public String cityName() {
        return this.uniqueName + "'s " + this.toString();
    }

    @Override
    public String toString() {
        return "City";
    }


}
