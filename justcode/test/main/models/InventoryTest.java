package main.models;

import main.models.items.artifacts.PodsRod;
import org.junit.*;

public class InventoryTest {

    @Test
    public void addArtifact() {
        Game.startGame();
        PodsRod rod = new PodsRod();
        Inventory inv = Game.getVillage().getInventory();

        inv.addArtifact(rod);

        Boolean actual = inv.containsArtifact(rod);
        Boolean expected = true;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addTool() {
    }

    @Test
    public void containsTool() {
    }

    @Test
    public void containsArtifact() {
    }
}