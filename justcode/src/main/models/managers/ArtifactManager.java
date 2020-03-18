package main.models.managers;

import main.models.items.artifacts.*;

import java.util.*;
import java.util.concurrent.*;

public class ArtifactManager {

    public static AbstractArtifact getRandomArtifact() {
        ArrayList<AbstractArtifact> artifacts = new ArrayList<>();
        artifacts.add(new HolyCrown());
        artifacts.add(new MoonShield());
        artifacts.add(new SunSword());
        artifacts.add(new PodsRod());
        artifacts.add(new RabbitFoot());
        artifacts.add(new GoldenSword());
        artifacts.add(new KingsCoat());
        return artifacts.get(ThreadLocalRandom.current().nextInt(artifacts.size()));
    }
}
