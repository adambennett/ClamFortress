package main.utilities.builders;

import main.enums.*;
import main.models.people.*;

public class SurvivorBuilder {
    private Integer agility = 0;
    private Integer strength = 0;
    private Integer dexterity = 0;
    private Integer intelligence = 0;
    private Integer magic = 0;
    private Integer engineering = 0;
    private Integer healthPoints = 10;
    private Integer maxHp = 0;
    private Integer age = 5;
    private String name = "Villager";
    private Gender gender = Gender.MALE;
    private Race race = Race.HUMAN;

    public SurvivorBuilder setAgility(Integer agility) {
        this.agility = agility;
        return this;
    }

    public SurvivorBuilder setStrength(Integer strength) {
        this.strength = strength;
        return this;
    }

    public SurvivorBuilder setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public SurvivorBuilder setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    public SurvivorBuilder setMagic(Integer magic) {
        this.magic = magic;
        return this;
    }

    public SurvivorBuilder setEngineering(Integer engineering) {
        this.engineering = engineering;
        return this;
    }

    public SurvivorBuilder setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
        return this;
    }

    public SurvivorBuilder setMaxHP(Integer maxHp){
        this.maxHp = maxHp;
        return this;
    }

    public SurvivorBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public SurvivorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SurvivorBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public SurvivorBuilder setRace(Race race) {
        this.race = race;
        return this;
    }

    public Survivor createSurvivor() {
        return new Survivor(agility, strength, dexterity, intelligence, magic, engineering, healthPoints, maxHp, age, name, gender, race);
    }
}