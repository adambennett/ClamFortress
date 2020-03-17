package main.consoleIO;

import main.utilities.builders.*;
import org.junit.*;

import static org.junit.Assert.*;

public class BiomeMenuTest {

    @Test
    public void setupGame() {
        BiomeMenu bm = new BiomeMenu();
        AbstractConsole.setBuilder(new GameBuilder());
        Boolean actual = bm.setupGame();
        Assert.assertTrue(actual);
    }
}