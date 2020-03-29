package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
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
        Database.setCurrentUser(new User("Quickplayer", "pass"));
        builder.buildGame();
        assertNotEquals(Database.getCurrentGame().getDifficulty(), Difficulty.CUSTOM);
        assertNotEquals(Database.getCurrentGame().getDifficulty(), Difficulty.RANDOM);
    }

    @Test
    public void buildGameB() {
        AbstractBiome grass = new BlankBiome();
        builder.setRace(Race.HUMAN);
        builder.setDifficulty(Difficulty.CUSTOM);
        builder.setCustomMods(new ArrayList<>());
        builder.setStartBiome(grass);
        Database.setCurrentUser(new User("Quickplayer", "pass"));
        builder.buildGame();
        assertEquals(Database.getCurrentGame().getDifficulty(), Difficulty.DEFAULT);
        assertEquals(Database.getCurrentGame().getPlayerRace(), Race.HUMAN);
        assertEquals(Database.getCurrentGame().getVillage().getBiome(), grass);
    }
}