package main.models.items.artifacts;

import org.junit.Assert;
import org.junit.Test;

public class PodsRodTest {

    @Test
    public void podsRodMod(){
        PodsRod rod = new PodsRod();

        Integer actual = rod.multiplyFoodOnFishing();
        Integer expected = 2;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void podsRodNameTest(){
        PodsRod rod = new PodsRod();
        String actual = rod.getName();
        String expected = "Pod's Rod";

        Assert.assertEquals(expected,actual);
    }
}
