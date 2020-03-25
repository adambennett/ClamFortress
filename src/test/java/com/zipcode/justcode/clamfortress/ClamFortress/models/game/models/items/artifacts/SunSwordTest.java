package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import org.junit.jupiter.api.*;

public class SunSwordTest {

    @Test
    public void sunSwordModTest(){
        SunSword ss = new SunSword();

        Integer actual = ss.modifyAtk();
        Integer expected = 15;

        Assertions.assertEquals(actual,expected);

    }

    @Test
    public void sunSwordNameTest(){
        SunSword ss = new SunSword();
        String actual = ss.getName();
        String expected = "Sword Of The Morning";

        Assertions.assertEquals(expected,actual);
    }
}
