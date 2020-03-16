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
        Lumber actual = wood.getRefined();
        Assert.assertNotNull(actual);
    }

    @Test
    public void getRefinedStone() {
        Rock rock = new Rock();
        Stone actual = rock.getRefined();
        Assert.assertNotNull(actual);
    }
}