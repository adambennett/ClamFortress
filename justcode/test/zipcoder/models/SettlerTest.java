package zipcoder.models;

import clamFortress.enums.Gender;
import clamFortress.enums.Race;
import clamFortress.models.beings.Survivor;
import clamFortress.models.builders.SurvivorBuilder;
import org.junit.Assert;
import org.junit.Test;
import zipcoder.enums.Gender;
import zipcoder.enums.Race;
import zipcoder.enums.Relation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SurvivorTest {
    Survivor relationTest = new Survivor(4,4,4,4,4,4,4,"tom",Gender.MALE,Race.CLAMAN, null );
    @Test
    public void setAgility() {
        Survivor test = new SurvivorBuilder()
                .setAgility(4)
                .setStrength(4)
                .setDexterity(4)
                .setMagic(4)
                .setEngineering(4)
                .setInjury(4)
                .setAge(4)
                .setName("tim")
                .setGender(Gender.MALE)
                .setRace(Race.CLAMAN)
                .createSurvivor();

        Integer actual = test.getAgility();
        Integer expected = 4;

        Assert.assertEquals(actual,expected);
    }

}