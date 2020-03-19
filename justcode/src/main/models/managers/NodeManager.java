package main.models.managers;

import main.models.*;
import main.models.items.artifacts.*;
import main.models.nodes.*;

import java.util.*;
import java.util.concurrent.*;

public class NodeManager {

    public static AbstractNode getRandomNode(int x, int y, int nethermod) {
        boolean hardMode = nethermod < 0;
        ArrayList<AbstractNode> nodes = new ArrayList<>();
        Netherworld nether = new Netherworld(x, y);
        nodes.add(new Grass(x, y));
        nodes.add(new City(x, y));
        nodes.add(new Desert(x, y));
        nodes.add(new Jungle(x, y));
        nodes.add(new Mountain(x, y));
        nodes.add(nether);
        nodes.add(new Sea(x, y));
        nodes.add(new Tundra(x, y));
        AbstractNode firstPass = nodes.get(ThreadLocalRandom.current().nextInt(nodes.size()));
        if (hardMode) {
            while (!firstPass.equals(nether) && nethermod < 0) {
                firstPass = nodes.get(ThreadLocalRandom.current().nextInt(nodes.size()));
                nethermod++;
            }
        } else {
            while (firstPass.equals(nether) && nethermod > 0) {
                firstPass = nodes.get(ThreadLocalRandom.current().nextInt(nodes.size()));
                nethermod--;
            }
        }
        return firstPass;
    }
}
