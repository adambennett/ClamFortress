package main.models.artifacts;

import org.junit.Assert;
import org.junit.Test;

public class HolyCrownTest {

    @Test
    public void holyCrownModTest(){
        HolyCrown crown = new HolyCrown();

        Integer actual = crown.modifyFaithInc();
        Integer expected = 15;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void holyCrownNameTest(){
        HolyCrown crown = new HolyCrown();
        String actual = crown.getName();
        String expected = "Holy Crown";

        Assert.assertEquals(expected,actual);
    }
}
