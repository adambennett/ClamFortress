package main.models.people;

import main.enums.*;

public class Monster extends Survivor {

    public Monster(Integer agility, Integer strength, Integer dexterity, Integer intelligence, Integer magic, Integer engineering, Integer healthPoints, Integer age, String name, Gender gender, Race race) {
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
    }

    public Monster(){
        this.agility = 0;
        this.strength = 0;
        this.dexterity = 0;
        this.intelligence = 0;
        this.magic = 0;
        this.engineering = 0;
        this.healthPoints = 10;
        this.age = 5;
        this.name = "Monster";
        this.race = Race.ORC;
        this.gender = Gender.MALE;
    }
}
