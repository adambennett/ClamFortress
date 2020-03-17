package main.models.items.artifacts;

import org.junit.Assert;
import org.junit.Test;

public class SunSwordTest {

    @Test
    public void sunSwordModTest(){
        SunSword ss = new SunSword();

        Integer actual = ss.modifyAtk();
        Integer expected = 15;

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void sunSwordNameTest(){
        SunSword ss = new SunSword();
        String actual = ss.getName();
        String expected = "Sword Of The Morning";

        Assert.assertEquals(expected,actual);
    }
}
