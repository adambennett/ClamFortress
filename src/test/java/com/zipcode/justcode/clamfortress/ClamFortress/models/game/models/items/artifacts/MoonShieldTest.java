package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import org.junit.jupiter.api.*;

public class MoonShieldTest {

    @Test
    public void moonShieldModTest(){
        MoonShield ms = new MoonShield();

       Integer actual =  ms.modifyDef();
       Integer expected = 15;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void moonShieldNameTest(){
        MoonShield ms = new MoonShield();

        String actual = ms.getName();
        String expected = "Moon Shield";

        Assertions.assertEquals(actual,expected);

    }
}
