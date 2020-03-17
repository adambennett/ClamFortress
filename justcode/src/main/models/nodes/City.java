package main.models.nodes;

import main.models.nodes.biomes.*;
import main.models.people.Survivor;

import java.util.ArrayList;

public class City extends AbstractNode {

    private Integer cityDefense;
    private ArrayList<Survivor> cityResidence;
    public City(int x, int y, AbstractBiome biome, Integer cityDefense, ArrayList<Survivor> cityResidence) {
        super(x, y, biome);
        this.cityDefense = cityDefense;
        this.cityResidence = cityResidence;
    }

    public Integer getCityDefense(){
        return this.cityDefense;
    }

    public ArrayList<Survivor> getCityResidence(){
        return this.cityResidence;
    }
    @Override
    public String toString() {
        return "City";
    }
}
