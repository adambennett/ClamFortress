package main.models;

import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.items.tools.*;
import main.models.items.tools.gathering.Pickaxe;
import org.junit.*;

import java.util.*;


public class InventoryTest {

    private static Inventory inv;

    @Before
    public void setUp() {
        Game.startGame();
        inv = Game.getVillage().getInventory();
    }

    @Test
    public void addArtifact() {
        PodsRod rod = new PodsRod();
        inv.addItem(rod);
        Boolean actual = inv.containsItem(rod.getName());
        Assert.assertTrue(actual);
    }

    @Test
    public void addTool() {
        Pickaxe pickaxe = new Pickaxe();
        inv.addItem(pickaxe);
        Boolean actual = inv.containsItem(pickaxe.getName());
        Assert.assertTrue(actual);
    }


    @Test
    public void invetorySize() {
        PodsRod rod = new PodsRod();
        Pickaxe pickaxe = new Pickaxe();
        inv.addItem(rod);
        inv.addItem(pickaxe);
        Integer expected = 2;
        Integer actual = inv.inventorySize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        PodsRod rod = new PodsRod();
        Pickaxe pickaxe = new Pickaxe();
        inv.addItem(rod);
        inv.addItem(rod.clone());
        inv.addItem(rod.clone());
        inv.addItem(pickaxe);
        inv.addItem(pickaxe.clone());
        inv.addItem(pickaxe.clone());
        inv.remove("pickaxe", 2);
        inv.remove(rod, 1);
        Integer expected = 3;
        Integer actual = inv.inventorySize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsItem() {
        PodsRod rod = new PodsRod();
        inv.addItem(rod);
        Assert.assertTrue(inv.containsItem(rod.getName()));
        Assert.assertTrue(inv.containsItem("pOd's rOD"));
    }

    @Test
    public void getItems() {
        PodsRod rod = new PodsRod();
        inv.addItem(rod);
        ArrayList<AbstractItem> expected = new ArrayList<>();
        ArrayList<AbstractItem> actual = inv.getItems();
        expected.add(rod);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getArtifacts() {
        PodsRod rod = new PodsRod();
        Pickaxe pickaxe = new Pickaxe();
        inv.addItem(rod);
        inv.addItem(pickaxe);
        ArrayList<AbstractArtifact> list = inv.getArtifacts();
        Integer expected = 1;
        Integer actual = list.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTools() {
        PodsRod rod = new PodsRod();
        Pickaxe pickaxe = new Pickaxe();
        inv.addItem(rod);
        inv.addItem(pickaxe);
        ArrayList<AbstractTool> list = inv.getTools();
        Integer expected = 1;
        Integer actual = list.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCapacity() {
        inv.setCapacity(1);
        PodsRod rod = new PodsRod();
        Pickaxe pickaxe = new Pickaxe();
        inv.addItem(rod);
        inv.addItem(pickaxe);
        inv.addItem(pickaxe.clone());
        inv.addItem(pickaxe.clone());
        inv.addItem(pickaxe.clone());
        inv.addItem(pickaxe.clone());
        inv.addItem(pickaxe.clone());
        inv.addItem(pickaxe.clone());
        Integer expected = 1;
        Integer actual = inv.getItems().size();
        Assert.assertEquals(expected, actual);
    }
}