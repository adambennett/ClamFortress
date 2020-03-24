package main.utilities.builders;

import main.enums.*;
import main.models.beings.*;

public class MonsterBuilder {
    private Integer agility = 0;
    private Integer strength = 0;
    private Integer dexterity = 0;
    private Integer intelligence = 0;
    private Integer magic = 0;
    private Integer engineering = 0;
    private Integer healthPoints = 10;
    private Integer age = 5;
    private String name = "Monster";
    private Gender gender = Gender.MALE;
    private Race race = Race.ORC;

    public MonsterBuilder setAgility(Integer agility) {
        this.agility = agility;
        return this;
    }

    public MonsterBuilder setStrength(Integer strength) {
        this.strength = strength;
        return this;
    }

    public MonsterBuilder setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public MonsterBuilder setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    public MonsterBuilder setMagic(Integer magic) {
        this.magic = magic;
        return this;
    }

    public MonsterBuilder setEngineering(Integer engineering) {
        this.engineering = engineering;
        return this;
    }

    public MonsterBuilder setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
        return this;
    }

    public MonsterBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public MonsterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MonsterBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public MonsterBuilder setRace(Race race) {
        this.race = race;
        return this;
    }

    public Monster createMonster() {
        return new Monster(agility, strength, dexterity, intelligence, magic, engineering, healthPoints, age, name, gender, race);
    }
}