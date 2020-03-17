package main.models.resources;

import main.models.resources.natural.Rock;
import main.models.resources.natural.Wood;
import main.models.resources.refined.Lumber;
import main.models.resources.refined.Stone;
import org.junit.Assert;
import org.junit.Test;

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