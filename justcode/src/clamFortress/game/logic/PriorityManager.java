package clamFortress.game.logic;

import clamFortress.actions.*;
import clamFortress.game.regions.*;

import java.util.*;
import java.util.concurrent.*;

public class PriorityManager {

    private Integer resourceMining;
    private Integer resourceCollecting;
    private Integer resourceRefining;
    private Integer findCity;
    private Integer findDesert;
    private Integer findGrass;
    private Integer findIce;
    private Integer findJungle;
    private Integer findMountain;
    private Integer findNether;
    private Integer findSea;
    private Integer totalExploration;
    private Integer construction;
    private Integer society;
    private Integer magic;
    private Integer research;


    // Priorities:
    // Resource gathering
        // Mining :
            // Gold
            // Copper
            // Gems
            // Iron
            // Rock
            // Clay
        // Collecting :
            // Wood
            // Flowers
            // Seeds
            // Sand
            // Spacegoo

    // Resource refining
        // Mined :
            // Brick
            // Coin
            // Jewelry
            // Stone
            // Military supplies
        // Collected :
            // Art
            // Glass
            // Lumber
            // Medical supplies

    // Exploration
        // Scouting :
            // Grasslands
            // Desert
            // Sea
            // Mountains
            // Icelands
            // City
            // Jungle
            // Netherworld

    // Construction & Development

    // Arts, Recreation, Religion

    // Magic

    // Research & Tech



    public ArrayList<AbstractGameAction> getActionsByPriorities() {
        ArrayList<AbstractGameAction> actions = new ArrayList<>();
        if (this.totalExploration > 0) {
            TreeMap<Integer, AbstractRegion> rolls =  new TreeMap<>();
            rolls.put(getRoll(this.findCity), new City());
            rolls.put(getRoll(this.findDesert), new Desert());
            rolls.put(getRoll(this.findGrass), new Grasslands());
            rolls.put(getRoll(this.findIce), new Icelands());
            rolls.put(getRoll(this.findJungle), new Jungle());
            rolls.put(getRoll(this.findMountain), new Mountain());
            rolls.put(getRoll(this.findNether), new Netherworld());
            rolls.put(getRoll(this.findSea), new Sea());
            AbstractRegion regionToDiscover = rolls.get(rolls.lastEntry().getKey());
            actions.add(new Discover(regionToDiscover));
        }


        return actions;
    }

    private Integer getRoll(Integer priority) {
        return (priority < 1) ? 0 : ThreadLocalRandom.current().nextInt(0, priority);
    }


}
