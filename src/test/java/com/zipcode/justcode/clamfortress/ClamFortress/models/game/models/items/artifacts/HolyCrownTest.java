package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import org.junit.jupiter.api.*;

public class HolyCrownTest {

    @Test
    public void holyCrownModTest(){
        HolyCrown crown = new HolyCrown();

        Integer actual = crown.modifyFaithInc();
        Integer expected = 15;

        Assertions.assertEquals(actual,expected);
    }

    @Test
    public void holyCrownNameTest(){
        HolyCrown crown = new HolyCrown();
        String actual = crown.getName();
        String expected = "Holy Crown";

        Assertions.assertEquals(expected,actual);
    }
}
