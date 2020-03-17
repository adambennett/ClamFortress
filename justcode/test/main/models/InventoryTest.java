package main.models;

import main.models.items.artifacts.PodsRod;
import main.models.items.tools.gathering.Pickaxe;
import org.junit.*;


public class InventoryTest {

    @Before
    public void before(){
        Game.startGame();
    }

    @Test
    public void addArtifact() {
        PodsRod rod = new PodsRod();
        Inventory inv = Game.getVillage().getInventory();

        inv.addArtifact(rod);

        Boolean actual = inv.containsArtifact(rod);
        Boolean expected = true;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addTool() {
        Pickaxe pickaxe = new Pickaxe();
        Inventory inventory = Game.getVillage().getInventory();

        inventory.addTool(pickaxe);

        Boolean actual = inventory.containsTool(pickaxe);
        Boolean expected = true;


        Assert.assertEquals(actual,expected);
    }

}