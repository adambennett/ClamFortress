package main.models;

import main.models.items.artifacts.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class ArchiveTest {

    private static Archive archive;

    @Before
    public void setup() {
        Game.startGame();
        archive = Archive.getInstance();
    }

    @Test
    public void getInstance() {
        Assert.assertNotNull(archive);
    }

    @Test
    public void get() {
        GameObject obj = archive.get("wood");
        String expected = "Wood";
        String actual = obj.getName();
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(obj instanceof Wood);
    }

    @Test
    public void generateNewResources() {
        ArrayList<AbstractResource> res = archive.generateNewResources("stone", 15);
        Integer expected = 15;
        Integer actual = res.size();
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(res.get(0) instanceof Stone);
    }

    @Test
    public void artifacts() {
        ArrayList<AbstractArtifact> art = archive.artifacts();
        Assert.assertTrue(art.contains(new HolyCrown()));
    }

}