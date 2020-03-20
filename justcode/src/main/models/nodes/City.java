package main.models.nodes;

import main.models.*;
import main.models.items.*;
import main.models.items.military.weapons.*;
import main.models.managers.*;
import main.models.nodes.biomes.*;
import main.models.people.Survivor;
import main.models.resources.*;
import main.utilities.*;

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
        Integer dmg = this.cityDefense;
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
        villager.setHealthPoints(villager.getHP() - amt);
        if (villager.getHP() < 1) {
            removeSurvivor(villager);
            OutputManager.addToBot("Enemy " + villager.getName() + " has been killed in a raid!" + "\nEnemy City HP: " + GameManager.getInstance().getRaidingCity().getHp() + " / " + GameManager.getInstance().getRaidingCity().getMaxHP());
        }
        if (this.cityResidence.size() < 1 || this.hp < 1) {
            defeat();
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
        this.hp -= s.getHP();
    }

    protected void defeat() {
        OutputManager.addToBot("Defeated " + this.cityName() + " in a raid!");
        this.defeated = true;
        if (this.hasArtifact()) {
            GameUtils.obtainArtifact(this.artifact);
        }

        if (this.hasItem()) {
            GameUtils.obtainItem(this.item);
        }

        if (this.resources.size() > 0) {
            Game.getVillage().addResources(this.resources);
        }

        if (this.animals.size() > 0) {
            Game.getGameBoard().addAnimals(this.animals);
        }

        if (this.equals(GameManager.getInstance().getRaidingCity())) {
            ArrayList<City> cities = Game.getGameBoard().getAllCities();
            ArrayList<City> otherCities = new ArrayList<>();
            if (cities.size() > 1) {
                for (City c : cities) {
                    if (!c.equals(this)) {
                        otherCities.add(c);
                    }
                }
            }
            if (otherCities.size() > 0) {
                GameManager.getInstance().setRaidingCity(otherCities.get(ThreadLocalRandom.current().nextInt(otherCities.size())));
            } else {
                GameManager.getInstance().setRaidingCity(null);
            }
        }
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
