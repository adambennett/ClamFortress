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
        biome = new Grasslands();
        board = new Board(biome, 50, 50);
    }

    @Test
    public void getRandomRegion() {
        AbstractNode rand = board.getRandomRegion();
        Assert.assertNotEquals(0, (int) rand.getxPos());
        Assert.assertNotEquals(0, (int) rand.getyPos());
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

    @Test
    public void discover() {
        AbstractNode bad = board.getRandomRegion(60, 60);
        Assert.assertFalse(board.discover(bad));
    }

    @Test
    public void addGridSpace() {
        AbstractNode bad = board.getRandomRegion(60, 60);
        AbstractNode rand = board.getRandomRegion(12, 12);
        AbstractNode randB = board.getRandomRegion(12, 12);
        Assert.assertFalse(board.addGridSpace(bad));
        Assert.assertTrue(board.addGridSpace(rand));
        Assert.assertFalse(board.addGridSpace(randB));
    }

    @Test
    public void artifactsTest() {
        AbstractNode rand = board.getRandomRegion(12, 12);
        AbstractNode randB = board.getRandomRegion(14, 14);
        rand.setArtifact(new HolyCrown());
        rand.setArtifact(new AwesomeArtifact());
        Assert.assertTrue(board.addGridSpace(rand));
        Assert.assertTrue(board.addGridSpace(randB));
    }

    @Test
    public void gettersTest() {
        board.setRocks(10);
        board.setTrees(20);
        Integer actualRock = board.getRocks();
        Integer actualTrees = board.getTrees();
        Assert.assertEquals(new Integer(10), actualRock);
        Assert.assertEquals(new Integer(20), actualTrees);
    }

    @Test
    public void reduceTreesTest() {
        board.setTrees(500);
        board.reduceTreesOnBoard(50);
        Assert.assertEquals(new Integer(450), board.getTrees());
        board.reduceTreesOnBoard(60000);
        Assert.assertEquals(new Integer(0), board.getTrees());
    }
}