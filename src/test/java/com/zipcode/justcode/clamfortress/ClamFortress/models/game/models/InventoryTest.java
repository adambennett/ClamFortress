package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class InventoryTest {

    private static Inventory inv;

    @BeforeEach
    public void setUp() {
        Game game = new Game();
        game = new Game();
        game.setId(1L);
        Database.setGameForTests(game);
        inv = game.getVillage().getInventory();
        inv.getItems().clear();
    }

    @Test
    public void addArtifact() {
        PodsRod rod = new PodsRod();
        inv.addItem(rod);
        Boolean actual = inv.containsItem(rod.getName());
        Assertions.assertTrue(actual);
    }

    @Test
    public void addTool() {
        Pickaxe pickaxe = new Pickaxe();
        inv.addItem(pickaxe);
        Boolean actual = inv.containsItem(pickaxe.getName());
        Assertions.assertTrue(actual);
    }


    @Test
    public void invetorySize() {
        PodsRod rod = new PodsRod();
        Pickaxe pickaxe = new Pickaxe();
        inv.addItem(rod);
        inv.addItem(pickaxe);
        Integer expected = 2;
        Integer actual = inv.inventorySize();
        Assertions.assertEquals(expected, actual);
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
        Integer expected = 1;
        Integer actual = inv.inventorySize();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void containsItem() {
        PodsRod rod = new PodsRod();
        inv.addItem(rod);
        Assertions.assertTrue(inv.containsItem(rod.getName()));
        Assertions.assertTrue(inv.containsItem("pOd's rOD"));
    }

    @Test
    public void getItems() {
        PodsRod rod = new PodsRod();
        inv.addItem(rod);
        ArrayList<AbstractItem> expected = new ArrayList<>();
        ArrayList<AbstractItem> actual = inv.getItems();
        expected.add(rod);
        Assertions.assertEquals(expected, actual);
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
        Assertions.assertEquals(expected, actual);
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
        Assertions.assertEquals(expected, actual);
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
        Assertions.assertEquals(expected, actual);
    }
}