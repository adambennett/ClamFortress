package main.utilities.consoleIO;

import main.utilities.builders.*;
import org.junit.*;

public class BiomeMenuTest {

    @Test
    public void setupGame() {
        PopulationSetupMenu bm = new PopulationSetupMenu();
        AbstractConsole.setBuilder(new GameBuilder());
        Boolean actual = bm.setupGame();
        Assert.assertTrue(actual);
    }
}