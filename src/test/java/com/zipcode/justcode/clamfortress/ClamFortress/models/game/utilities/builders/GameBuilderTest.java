package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameBuilderTest {

    private static GameBuilder builder;

    @BeforeEach
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