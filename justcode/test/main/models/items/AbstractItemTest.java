package main.models.items;

import main.models.items.artifacts.*;
import org.junit.*;

import static org.junit.Assert.*;

public class AbstractItemTest {

    private static AbstractItem testItem;
    private static AbstractItem testItemB;

    @Before
    public void setup() {
        testItem = new HolyCrown();
        testItemB = new HolyCrown();
    }

    @Test
    public void testEquals() {
        assertEquals(testItem, testItemB);
    }
}