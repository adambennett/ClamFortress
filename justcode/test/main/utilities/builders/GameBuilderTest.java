package main.utilities.builders;

import main.enums.*;
import main.models.*;
import main.models.nodes.biomes.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class GameBuilderTest {

    private static GameBuilder builder;

    @Before
    public void setUp() {
        builder = new GameBuilder();
    }

    @Test
    public void buildGame() {
        builder.setDifficulty(Difficulty.RANDOM);
        builder.buildGame();
        assertNotEquals(Game.getDifficulty(), Difficulty.CUSTOM);
        assertNotEquals(Game.getDifficulty(), Difficulty.RANDOM);
    }

    @Test
    public void buildGameB() {
        AbstractBiome grass = new Grasslands();
        builder.setRace(Race.HUMAN);
        builder.setDifficulty(Difficulty.CUSTOM);
        builder.setCustomMods(new ArrayList<>());
        builder.setStartBiome(grass);
        builder.buildGame();
        assertEquals(Game.getDifficulty(), Difficulty.CUSTOM);
        assertEquals(Game.getPlayerRace(), Race.HUMAN);
        assertEquals(Game.getVillage().getBiome(), grass);
    }
}