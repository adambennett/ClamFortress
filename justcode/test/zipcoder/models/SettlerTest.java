package zipcoder.models;

import org.junit.Assert;
import org.junit.Test;
import zipcoder.enums.Gender;
import zipcoder.enums.Race;
import zipcoder.enums.Relation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SettlerTest {
    Settler relationTest = new Settler(4,4,4,4,4,4,4,"tom",Gender.MALE,Race.CLAMAN, null );
    @Test
    public void setAgility() {
        Settler test = new SettlerBuilder()
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
                .createSettler();

        Integer actual = test.getAgility();
        Integer expected = 4;

        Assert.assertEquals(actual,expected);
    }

}