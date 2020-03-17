package main.models.resources;

import main.models.resources.natural.*;
import main.models.resources.refined.*;
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

    @Test
    public void getRefinedCopper(){
        Copper copper = new Copper();
        CopperIngot actual = copper.getRefined();

        Assert.assertNotNull(actual);
    }

    @Test
    public  void getRefinedClay(){
        Clay clay = new Clay();
        Brick actual = clay.getRefined();


        Assert.assertNotNull(actual);
    }

    @Test
    public void getRefinedGem(){
        Gems gems = new Gems();
        Jewelry actual = gems.getRefined();

        Assert.assertNotNull(actual);
    }

    @Test
    public void getRefinedGold(){
        Gold gold = new Gold();
        Coin actual = gold.getRefined();

        Assert.assertNotNull(actual);
    }

    @Test
    public void getRefinedIron(){
        Iron iron = new Iron();
        IronIngot actual = iron.getRefined();

        Assert.assertNotNull(actual);
    }

    @Test
    public void getRifinedSand(){
        Sand sand = new Sand();
        Glass actual = sand.getRefined();

        Assert.assertNotNull(actual);
    }
}