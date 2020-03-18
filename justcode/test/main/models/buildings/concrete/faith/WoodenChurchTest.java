package main.models.buildings.concrete.faith;

import org.junit.*;

public class WoodenChurchTest {

    private static WoodenChurch church;

    @Before
    public void setUp()  {
        church = new WoodenChurch();
    }

    @Test
    public void initTest() {
        Integer expected = 15;
        Integer actual = church.getPrayBonus();
        Assert.assertEquals(expected, actual);
    }
}