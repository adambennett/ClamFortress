package main.models;


import main.models.items.artifacts.*;
import main.models.nodes.*;
import main.models.nodes.biomes.*;
import org.junit.*;

public class BoardTest {

    private static Board board;
    private static AbstractBiome biome;

    @Before
    public void setUp() {
        Game.startGame();
        biome = new Grasslands();
        board = new Board(biome, 50, 50, 5);
    }

    @Test
    public void getRandomRegion() {
        AbstractNode rand = board.getRandomRegion();
        Assert.assertTrue(rand.getxPos() <= board.getGridXMax());
        Assert.assertTrue(rand.getyPos() <= board.getGridYMax());
    }

    @Test
    public void testGetRandomRegion() {
        AbstractNode rand = board.getRandomRegion(12, 12);
        AbstractNode bad = board.getRandomRegion(60, 60);
        Assert.assertEquals(12, (int) rand.getxPos());
        Assert.assertEquals(12, (int) rand.getyPos());
        Assert.assertEquals(60, (int) bad.getxPos());
        Assert.assertEquals(60, (int) bad.getyPos());
    }

}