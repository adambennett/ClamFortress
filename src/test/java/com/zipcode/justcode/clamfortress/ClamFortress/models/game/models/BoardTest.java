package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import org.junit.jupiter.api.*;

public class BoardTest {

    private static Board board;
    private static AbstractBiome biome;

    @BeforeEach
    public void setUp() {
        biome = new Grasslands();
        board = new Board(biome, 50, 50, 5);
    }

    @Test
    public void getRandomRegion() {
        AbstractNode rand = board.getRandomRegion(999);
        Assertions.assertTrue(rand.getxPos() <= board.getGridXMax());
        Assertions.assertTrue(rand.getyPos() <= board.getGridYMax());
    }

    @Test
    public void testGetRandomRegion() {
        AbstractNode rand = board.getRandomRegion(12, 12, 999);
        AbstractNode bad = board.getRandomRegion(60, 60, 999);
        Assertions.assertEquals(12, (int) rand.getxPos());
        Assertions.assertEquals(12, (int) rand.getyPos());
        Assertions.assertEquals(60, (int) bad.getxPos());
        Assertions.assertEquals(60, (int) bad.getyPos());
    }

}