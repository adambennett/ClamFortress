package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;

public class AlienBuilder {
    private Integer agility = 50;
    private Integer strength = 200;
    private Integer dexterity = 50;
    private Integer intelligence = 50;
    private Integer magic = 0;
    private Integer engineering = 600;
    private Integer healthPoints = 200;
    private Integer maxHP = 200;
    private Integer age = 555;
    private String name = "Alien";
    private Gender gender = Gender.MALE;
    private Race race = Race.ALIEN;

    public AlienBuilder setAgility(Integer agility) {
        this.agility = agility;
        return this;
    }

    public AlienBuilder setStrength(Integer strength) {
        this.strength = strength;
        return this;
    }

    public AlienBuilder setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public AlienBuilder setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    public AlienBuilder setMagic(Integer magic) {
        this.magic = magic;
        return this;
    }

    public AlienBuilder setEngineering(Integer engineering) {
        this.engineering = engineering;
        return this;
    }

    public AlienBuilder setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
        return this;
    }

    public AlienBuilder setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
        return this;
    }

    public AlienBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public AlienBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AlienBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public AlienBuilder setRace(Race race) {
        this.race = race;
        return this;
    }

    public Alien createAlien() {
        return new Alien(agility, strength, dexterity, intelligence, magic, engineering, healthPoints, maxHP, age, name, gender, race);
    }
}