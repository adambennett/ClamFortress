package main.models;

import main.models.items.artifacts.PodsRod;
import main.models.nodes.*;
import org.junit.*;

class InventoryTest {

    @Test
    void addArtifact() {
        PodsRod rod = new PodsRod();
        Village inv = Game.getVillage();

        inv.addArtifact(rod);

        Boolean actual = inv.getArtifacts().contains(rod);
        Boolean expected = true;

        Assert.assertEquals(expected,actual);
        System.out.println(inv.toString());
    }

    @Test
    void addTool() {
    }

    @Test
    void containsTool() {
    }

    @Test
    void containsArtifact() {
    }
}