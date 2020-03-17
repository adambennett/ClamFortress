package main.models.gridSpaces;

import main.game.*;
import main.game.regions.*;
import main.models.animals.sea.SeaAnimal;

import java.util.*;

public class SeaSpace extends AbstractGridSpace {

    private ArrayList<SeaAnimal> seaLife;

    public SeaSpace(int x, int y, AbstractRegion biome) {
        super(x, y, biome);
        this.seaLife = Game.generateRandomAquatic();
    }

    public ArrayList<SeaAnimal> getSeaLife() {
        return seaLife;
    }
}
