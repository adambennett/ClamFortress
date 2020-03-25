package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;
import org.junit.jupiter.api.*;

public class AbstractItemTest {

    @Test
    public void testEquals() {
        AbstractItem testItem = new HolyCrown();
        AbstractItem testItemB = new HolyCrown();
        Assertions.assertEquals(testItem, testItemB);
    }
}