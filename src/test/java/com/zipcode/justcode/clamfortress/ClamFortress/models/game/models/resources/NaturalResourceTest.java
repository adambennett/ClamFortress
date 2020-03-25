package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;
import org.junit.jupiter.api.*;

public class NaturalResourceTest {

    @Test
    public void getRefinedWood() {
        Wood wood = new Wood();
        Lumber actual = wood.getRefined();
        Assertions.assertNotNull(actual);
    }

    @Test
    public void getRefinedStone() {
        Rock rock = new Rock();
        Stone actual = rock.getRefined();
        Assertions.assertNotNull(actual);
    }

    @Test
    public void getRefinedCopper(){
        Copper copper = new Copper();
        CopperIngot actual = copper.getRefined();

        Assertions.assertNotNull(actual);
    }

    @Test
    public  void getRefinedClay(){
        Clay clay = new Clay();
        Brick actual = clay.getRefined();


        Assertions.assertNotNull(actual);
    }

    @Test
    public void getRefinedGem(){
        Gems gems = new Gems();
        Jewelery actual = gems.getRefined();

        Assertions.assertNotNull(actual);
    }

    @Test
    public void getRefinedGold(){
        Gold gold = new Gold();
        Coin actual = gold.getRefined();

        Assertions.assertNotNull(actual);
    }

    @Test
    public void getRefinedIron(){
        Iron iron = new Iron();
        IronIngot actual = iron.getRefined();

        Assertions.assertNotNull(actual);
    }

    @Test
    public void getRifinedSand(){
        Sand sand = new Sand();
        Glass actual = sand.getRefined();

        Assertions.assertNotNull(actual);
    }
}