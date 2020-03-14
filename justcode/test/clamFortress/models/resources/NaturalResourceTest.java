package clamFortress.models.resources;

import clamFortress.models.resources.natural.Rock;
import clamFortress.models.resources.natural.Wood;
import clamFortress.models.resources.refined.Lumber;
import clamFortress.models.resources.refined.Stone;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NaturalResourceTest {

    @Test
    public void getRefinedWood() {
        Wood wood = new Wood();
        Lumber expected = new Lumber();
        Lumber actual = (Lumber) wood.getRefined();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getRefinedStone() {
        Rock rock = new Rock();
        Stone expected = new Stone();
        Stone actual = rock.getRefined();

        Assert.assertEquals(expected,actual);

    }
}