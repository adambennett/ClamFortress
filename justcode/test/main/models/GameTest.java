package main.models;

import main.actions.*;
import main.enums.*;
import main.models.nodes.biomes.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getFoodActions() {
        for (Race r : Race.values()) {
            Game.startGame(Difficulty.EASY, r, new Grasslands());
            assertEquals(3, Game.getFoodActions().size());
        }
    }

    @Test
    public void fillActionManagerWithSimpleActions() {
        Game.startGame();
        Integer expected = 2;
        Integer actual = Game.fillActionManagerWithSimpleActions(1);
        Assert.assertEquals(expected, actual);
    }
}