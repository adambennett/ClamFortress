package main.models;

import main.models.items.artifacts.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class ArchiveTest {

    

    @Before
    public void setup() {
        //Game.startGame();      
    }

    @Test
    public void get() {
        GameObject obj = Archive.getInstance().get("wood");
        String expected = "Wood";
        String actual = obj.getName();
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(obj instanceof Wood);
    }

    @Test
    public void generateNewResources() {
        ArrayList<AbstractResource> res = Archive.getInstance().generateNewResources("stone", 15);
        Integer expected = 15;
        Integer actual = res.size();
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(res.get(0) instanceof Stone);
    }

    @Test
    public void artifacts() {
        ArrayList<AbstractArtifact> art = Archive.getInstance().artifacts();
        Assert.assertTrue(art.contains(new HolyCrown()));
    }

}