package main.models;

import main.models.items.artifacts.PodsRod;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class InventoryTest {


    @Test
    void addArtifact() {
        Game.startGame();
        PodsRod rod = new PodsRod();
        Inventory inv = Game.getVillage().getInventory();

        inv.addArtifact(rod);

        Boolean actual = inv.containsArtifact(rod);
        Boolean expected = true;

        Assert.assertEquals(expected,actual);
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