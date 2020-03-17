package main.models.beings.player;

import main.enums.*;
import main.models.resources.refined.food.*;

import java.util.*;
import java.util.concurrent.*;

public  class Survivor {
    private Integer agility;
    private Integer strength;
    private Integer dexterity;
    private Integer intelligence;
    private Integer magic;
    private Integer engineering;
    private Integer healthPoints;
    private Integer age;
    private String name;
    private Gender gender;
    private Race race;
    private Map<Survivor, ArrayList<Relation>> relations;

    public Survivor(Integer agility, Integer strength, Integer dexterity, Integer intelligence, Integer magic, Integer engineering, Integer healthPoints, Integer age, String name, Gender gender, Race race, Map<Survivor, ArrayList<Relation>> relations) {
        this.agility = agility;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.magic = magic;
        this.engineering = engineering;
        this.healthPoints = healthPoints;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.race = race;
        this.relations = relations;
    }

    //This is a nullary constructor because im not sure if we are going to have each one use the constructor from Survivor
    public Survivor(){
        this.agility = 0;
        this.strength = 0;
        this.dexterity = 0;
        this.intelligence = 0;
        this.magic = 0;
        this.engineering = 0;
        this.healthPoints = 10;
        this.age = 5;
        this.name = "Villager";
        this.race = Race.HUMAN;
        this.gender = Gender.MALE;
        this.relations = new HashMap<>();
    }

    public void feed(AbstractFood food) {
        this.setHealthPoints(this.healthPoints + food.getHealing());
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(Integer intelligence){ this.intelligence = intelligence; }

    public Integer getIntelligence(){ return this.intelligence;}

    public Integer getMagic() { return magic; }

    public void setMagic(Integer magic) { this.magic = magic; }

    public Integer getEngineering() { return engineering; }

    public void setEngineering(Integer engineering) { this.engineering = engineering; }

    public Integer getHealthPoints() { return healthPoints; }

    public void setHealthPoints(Integer healthPoints) { this.healthPoints = healthPoints; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

    public Race getRace() { return race; }

    public void setRace(Race race) { this.race = race; }
}
