package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.junit.jupiter.api.*;

public class RockPickingTest {

    private static Game game;

    @BeforeEach
    public void setup() {
        game = new Game();
        game.setId(1L);
        Database.setGameForTests(game);
    }

    @Test
    public void rockPickingWithoutPickTest(){
        game.getGameBoard().addResource(new Rock(), 150);
        RockPicking picking = new RockPicking(1);
        picking.update();

        Integer rocksOnBoardActual = game.getGameBoard().getResource("Rock");
        Integer rocksOnBoardExpected = 135;

        Integer rocksInVilActual = game.getVillage().getResource("Rock");
        Integer rocksInVilExpected = 15;

        Assertions.assertEquals(rocksInVilExpected,rocksInVilActual);
        Assertions.assertEquals(rocksOnBoardExpected,rocksOnBoardActual);
    }

    @Test
    public void rockPickingWithPickTest(){
        Pickaxe pick = new Pickaxe();
        game.getGameBoard().addResource(new Rock(), 150);
        RockPicking picking = new RockPicking(1);
        game.getVillage().getInventory().addItem(pick);
        picking.update();

        Integer rocksOnBoardActual = game.getGameBoard().getResource("Rock");
        Integer rocksOnBoardExpected = 120;

        Integer rocksInVilActual = game.getVillage().getResource("Rock");
        Integer rocksInVilExpected = 30;

        Assertions.assertEquals(rocksInVilExpected,rocksInVilActual);
        Assertions.assertEquals(rocksOnBoardExpected,rocksOnBoardActual);
    }
}