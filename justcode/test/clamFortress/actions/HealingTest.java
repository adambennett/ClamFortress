package clamFortress.actions;

import clamFortress.enums.Gender;
import clamFortress.enums.Race;
import clamFortress.models.Board;
import clamFortress.models.beings.player.Survivor;
import clamFortress.utilities.builders.SurvivorBuilder;
import org.junit.Assert;
import org.junit.Test;

public class HealingTest {

    Survivor healer = new SurvivorBuilder()
            .setAgility(4)
            .setStrength(4)
            .setDexterity(4)
            .setMagic(4)
            .setIntelligence(4)
            .setEngineering(4)
            .setHealthPoints(100)
            .setAge(4)
            .setName("tim")
            .setGender(Gender.MALE)
            .setRace(Race.CLAMAN)
            .createSurvivor();

    Survivor goodHealer = new SurvivorBuilder()
            .setAgility(4)
            .setStrength(4)
            .setDexterity(4)
            .setMagic(4)
            .setIntelligence(7)
            .setEngineering(4)
            .setHealthPoints(100)
            .setAge(4)
            .setName("tim")
            .setGender(Gender.MALE)
            .setRace(Race.CLAMAN)
            .createSurvivor();

    Survivor toBeHealed = new SurvivorBuilder()
            .setAgility(4)
            .setStrength(4)
            .setDexterity(4)
            .setIntelligence(4)
            .setMagic(4)
            .setEngineering(4)
            .setHealthPoints(40)
            .setAge(4)
            .setName("tim")
            .setGender(Gender.MALE)
            .setRace(Race.CLAMAN)
            .createSurvivor();

    /*Healing healing = new Healing(healer,toBeHealed,4);
    @Test
    public void healSurvivorHealerLowInt() {
        Board.setHealingItemsOnBoard(0);
        healing.update();

        Integer expected = 50;
        Integer actual = toBeHealed.getHealthPoints();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void healSurvivorHealerHighInt() {
        Board.setHealingItemsOnBoard(0);
        healing.update();

        Integer expected = 60;
        Integer actual = toBeHealed.getHealthPoints();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void healSurvivorHealerHighIntWithHealingItems() {
        Board.setHealingItemsOnBoard(1);
        healing.update();

        Integer expected = 70;
        Integer actual = toBeHealed.getHealthPoints();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void healSurvivorHealerHighIntWithHealingItemsRemoveItems() {
        Board.setHealingItemsOnBoard(1);
        healing.update();

        Integer expected = 0;
        Integer actual = Board.getHealingItemsOnBoard();

        Assert.assertEquals(expected,actual);
    }
    */


}