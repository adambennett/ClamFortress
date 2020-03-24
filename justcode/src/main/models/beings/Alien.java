package main.models.beings;

import main.enums.*;

public class Alien extends Survivor {
    public Alien(Integer agility, Integer strength, Integer dexterity, Integer intelligence, Integer magic, Integer engineering, Integer healthPoints, Integer maxHP, Integer age, String name, Gender gender, Race race) {
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

    public Alien(){
        this.agility = 50;
        this.strength = 200;
        this.dexterity = 50;
        this.intelligence = 50;
        this.magic = 0;
        this.engineering = 600;
        this.healthPoints = 200;
        this.age = 555;
        this.name = "Alien";
        this.race = Race.ALIEN;
        this.gender = Gender.MALE;
    }
}
