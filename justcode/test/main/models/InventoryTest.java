package main.models;

import main.models.artifacts.PodsRod;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void addArtifact() {
        PodsRod rod = new PodsRod();
        Inventory inv = new Inventory();

        inv.addArtifact(rod);

        Boolean actual = inv.containsArtifact(rod);
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