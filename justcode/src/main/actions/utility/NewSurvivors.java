package main.actions.utility;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.managers.*;
import main.models.people.*;
import main.utilities.*;
import main.utilities.builders.*;

import java.util.concurrent.*;

public class NewSurvivors extends AbstractGameAction {

    @Override
    public void update() {
        int pop = Game.getVillage().getPopulation();
        int popCap = Game.getVillage().getPopCap();
        int diff = popCap - pop;
        if (pop < popCap && diff > 0) {
            int amtOfNewSurvivors = ThreadLocalRandom.current().nextInt(0, diff);
            int high = Game.getVillage().getHunger();
            if (high < 1) { high = 1; }
            int hungerRoll = ThreadLocalRandom.current().nextInt(0, high);
            amtOfNewSurvivors -= hungerRoll;
            if (amtOfNewSurvivors > 0) {
                addToVillage(amtOfNewSurvivors);
            }
        }
        this.isDone = true;
    }

    public void addToVillage(int amt) {
        for (int i = 0; i < amt; i++) {
            Survivor newCitizen = getRandomSurvivor();
            Game.getVillage().addToPopulation(newCitizen);
            OutputManager.addToBot(newCitizen.getName() + " has moved into your village!");
        }
    }

    public Survivor getRandomSurvivor() {
        int randHP = ThreadLocalRandom.current().nextInt(10, 100);
        int randAge = randHP;
        randHP += ThreadLocalRandom.current().nextInt(-5, 5);
        int randAgility = ThreadLocalRandom.current().nextInt(1, 10);
        int randEngineer = ThreadLocalRandom.current().nextInt(1, 10);
        int randMagic = ThreadLocalRandom.current().nextInt(1, 10);
        int randDex = ThreadLocalRandom.current().nextInt(1, 10);
        int randStrength = ThreadLocalRandom.current().nextInt(1, 10);
        int randIntel = ThreadLocalRandom.current().nextInt(1, 10);
        boolean male = ThreadLocalRandom.current().nextBoolean();
        Gender gender;
        if (male) {
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }
       return new SurvivorBuilder()
                .setName(GameStrings.getRandomName(true))
                .setHealthPoints(randHP)
                .setStrength(randStrength)
                .setIntelligence(randIntel)
                .setAge(randAge)
                .setAgility(randAgility)
                .setEngineering(randEngineer)
                .setGender(gender)
                .setRace(Game.getPlayerRace())
                .setMagic(randMagic)
                .setDexterity(randDex)
                .createSurvivor();
    }
}
