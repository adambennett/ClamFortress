package main.models.gridSpaces;


import main.models.animals.jungle.JungleAnimal;
import main.models.resources.natural.Flowers;

import java.util.HashMap;
import java.util.Map;

public class JungleSpace extends AbstractGridSpace {

    private Integer trees;
    private Integer ironOre;
    private Integer rocks;
    private Map<Flowers,Integer> flowers;
    private Map<JungleAnimal,Integer> animals;

    public JungleSpace(int xPos, int yPos, HashMap<JungleAnimal,Integer> animals, int trees, int rocks, Map<Flowers,Integer> flowers) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.trees = trees;
        this.animals = animals;
        this.rocks = rocks;
        this.flowers = flowers;
    }

    public Integer getRocks() {
        return rocks;
    }

    public Integer getTrees() {
        return trees;
    }

    public Map<Flowers,Integer> getFlowers(){return this.flowers;}

    public Map<JungleAnimal,Integer> getAnimals(){return this.animals;}
}
