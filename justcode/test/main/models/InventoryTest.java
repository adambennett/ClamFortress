package main.models;

import main.models.items.artifacts.PodsRod;
import main.models.items.tools.gathering.Pickaxe;
import org.junit.*;


public class InventoryTest {

    @Test
    public void addArtifact() {
        Game.startGame();

        PodsRod rod = new PodsRod();
        Inventory inv = Game.getVillage().getInventory();

        inv.addItem(rod);

        Boolean actual = inv.containsItem(rod.getName());
        Boolean expected = true;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addTool() {
        Game.startGame();
        Pickaxe pickaxe = new Pickaxe();
        Inventory inventory = Game.getVillage().getInventory();

        inventory.addItem(pickaxe);

        Boolean actual = inventory.containsItem(pickaxe.getName());
        Boolean expected = true;


        Assert.assertEquals(actual,expected);

    }

}