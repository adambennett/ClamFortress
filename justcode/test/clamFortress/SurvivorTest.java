package clamFortress;

import clamFortress.enums.Gender;
import clamFortress.enums.Race;
import clamFortress.models.beings.Survivor;
import clamFortress.utilities.builders.SurvivorBuilder;
import org.junit.Assert;
import org.junit.Test;

public class SurvivorTest {

   // This is for relationTesting, unused for now Survivor relationTest = new Survivor(4,4,4,4,4,4,4,"tom", Gender.MALE, Race.CLAMAN, null );
        @Test
        public void survivorBuilderTest() {
            Survivor test = new SurvivorBuilder()
                    .setAgility(4)
                    .setStrength(4)
                    .setDexterity(4)
                    .setMagic(4)
                    .setEngineering(4)
                    .setHealthPoints(4)
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

