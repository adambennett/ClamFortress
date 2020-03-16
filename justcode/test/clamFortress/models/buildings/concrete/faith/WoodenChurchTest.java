package clamFortress.models.buildings.concrete.faith;

import org.junit.*;

import static org.junit.Assert.*;

public class WoodenChurchTest {

    private static WoodenChurch church;

    @Before
    public void setUp()  {
        church = new WoodenChurch(10);
    }

    @Test
    public void initTest() {
        Integer expected = 10;
        Integer actual = church.getPrayBonus();
        Assert.assertEquals(expected, actual);
    }
}