package zipcoder.models;

import zipcoder.enums.*;

import java.util.*;

public class SettlerBuilder {
    private Integer agility;
    private Integer strength;
    private Integer dexterity;
    private Integer magic;
    private Integer engineering;
    private Integer injury;
    private Integer age;
    private String name;
    private Gender gender;
    private Race race;
    private Map<Settler, ArrayList<Relation>> relations;

    public SettlerBuilder setAgility(Integer agility) {
        this.agility = agility;
        return this;
    }

    public SettlerBuilder setStrength(Integer strength) {
        this.strength = strength;
        return this;
    }

    public SettlerBuilder setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public SettlerBuilder setMagic(Integer magic) {
        this.magic = magic;
        return this;
    }

    public SettlerBuilder setEngineering(Integer engineering) {
        this.engineering = engineering;
        return this;
    }

    public SettlerBuilder setInjury(Integer injury) {
        this.injury = injury;
        return this;
    }

    public SettlerBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public SettlerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SettlerBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public SettlerBuilder setRace(Race race) {
        this.race = race;
        return this;
    }

    public SettlerBuilder setRelations(Map<Settler, ArrayList<Relation>> relations) {
        this.relations = relations;
        return this;
    }

    public Settler createSettler() {
        return new Settler(agility, strength, dexterity, magic, engineering, injury, age, name, gender, race, relations);
    }
}