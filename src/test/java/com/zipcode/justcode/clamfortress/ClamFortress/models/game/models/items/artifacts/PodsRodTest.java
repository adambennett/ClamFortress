package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class PodsRodTest {

    @Test
    public void podsRodMod(){
        PodsRod rod = new PodsRod();

        Integer actual = rod.multiplyFoodOnFishing();
        Integer expected = 2;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void podsRodNameTest(){
        PodsRod rod = new PodsRod();
        String actual = rod.getName();
        String expected = "Pod's Rod";

        Assertions.assertEquals(expected,actual);
    }
}
