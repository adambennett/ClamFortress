package main.models.artifacts;

import org.junit.Assert;
import org.junit.Test;

public class MoonShieldTest {

    @Test
    public void moonShieldModTest(){
        MoonShield ms = new MoonShield();

       Integer actual =  ms.modifyDef();
       Integer expected = 15;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void moonShieldNameTest(){
        MoonShield ms = new MoonShield();

        String actual = ms.getName();
        String expected = "Moon Shield";

        Assert.assertEquals(actual,expected);

    }
}
