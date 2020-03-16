package clamFortress.models.gridSpaces;

import clamFortress.models.animals.sea.SeaAnimal;

import java.util.Map;

public class SeaSpace extends AbstractGridSpace {

    Map<SeaAnimal,Integer> fish;

    public SeaSpace(int xPos, int yPos, Map<SeaAnimal,Integer> fish){
        this.xPos = xPos;
        this.yPos = yPos;
        this.fish=fish;
    }
}
