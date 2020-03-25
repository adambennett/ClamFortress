package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.faith;

import org.junit.jupiter.api.*;

public class WoodenChurchTest {

    private static WoodenChurch church;

    @BeforeEach
    public void setUp()  {
        church = new WoodenChurch();
    }

    @Test
    public void initTest() {
        Integer expected = 15;
        Integer actual = church.getPrayBonus();
        Assertions.assertEquals(expected, actual);
    }
}