package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.food.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import javax.persistence.*;
import java.util.*;

@Entity
public  class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Village village;

    protected Integer agility;
    protected Integer strength;
    protected Integer dexterity;
    protected Integer intelligence;
    protected Integer magic;
    protected Integer engineering;
    protected Integer healthPoints;
    protected Integer maxHp;
    protected Integer age;
    protected String name;

    @Enumerated(EnumType.STRING)
    protected Gender gender;

    @Enumerated(EnumType.STRING)
    protected Race race;

    public Survivor(Integer agility, Integer strength, Integer dexterity, Integer intelligence, Integer magic, Integer engineering, Integer healthPoints,Integer maxHP, Integer age, String name, Gender gender, Race race) {
        this.agility = agility;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.magic = magic;
        this.engineering = engineering;
        this.healthPoints = healthPoints;
        this.maxHp = maxHP;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.race = race;
    }

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
    }

    public void die() {}

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

    public Integer getHP() { return healthPoints; }

    public void setHealthPoints(Integer healthPoints) { this.healthPoints = healthPoints; }

    public void setMaxHp(Integer maxHp){this.maxHp = maxHp;}

    public Integer getMaxHp(){return this.maxHp;}

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

    public Race getRace() { return race; }

    public void setRace(Race race) { this.race = race; }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Survivor)) return false;
        Survivor survivor = (Survivor) o;
        return Objects.equals(getAgility(), survivor.getAgility()) &&
                Objects.equals(getStrength(), survivor.getStrength()) &&
                Objects.equals(getDexterity(), survivor.getDexterity()) &&
                Objects.equals(getIntelligence(), survivor.getIntelligence()) &&
                Objects.equals(getMagic(), survivor.getMagic()) &&
                Objects.equals(getEngineering(), survivor.getEngineering()) &&
                Objects.equals(getHP(), survivor.getHP()) &&
                Objects.equals(getAge(), survivor.getAge()) &&
                Objects.equals(getName(), survivor.getName()) &&
                getGender() == survivor.getGender() &&
                getRace() == survivor.getRace();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAgility(), getStrength(), getDexterity(), getIntelligence(), getMagic(), getEngineering(), getHP(), getAge(), getName(), getGender(), getRace());
    }
}
