package zipcoder.models.builders;

import zipcoder.enums.*;
import zipcoder.models.beings.*;

import java.util.*;

public class SurvivorBuilder {
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
    private Map<Survivor, ArrayList<Relation>> relations;

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

    public SurvivorBuilder setMagic(Integer magic) {
        this.magic = magic;
        return this;
    }

    public SurvivorBuilder setEngineering(Integer engineering) {
        this.engineering = engineering;
        return this;
    }

    public SurvivorBuilder setInjury(Integer injury) {
        this.injury = injury;
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

    public SurvivorBuilder setRelations(Map<Survivor, ArrayList<Relation>> relations) {
        this.relations = relations;
        return this;
    }

    public Survivor createSettler() {
        return new Survivor(agility, strength, dexterity, magic, engineering, injury, age, name, gender, race, relations);
    }
}