package main.models.managers;

import main.models.artifacts.*;

import java.util.*;
import java.util.concurrent.*;

public class ArtifactManager {

    public static AbstractArtifact getRandomArtifact() {
        ArrayList<AbstractArtifact> artifacts = new ArrayList<>();
        artifacts.add(new HolyCrown());
        artifacts.add(new MoonShield());
        artifacts.add(new SunSword());
        artifacts.add(new PodsRod());
        return artifacts.get(ThreadLocalRandom.current().nextInt(artifacts.size()));
    }
}
