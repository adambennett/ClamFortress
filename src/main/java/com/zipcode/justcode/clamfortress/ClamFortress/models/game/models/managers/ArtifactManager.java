package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;

import java.util.*;
import java.util.concurrent.*;

public class ArtifactManager {

    public static AbstractArtifact getRandomArtifact() {
        ArrayList<AbstractArtifact> artifacts = new ArrayList<>(Archive.getInstance().artifacts());
        return artifacts.get(ThreadLocalRandom.current().nextInt(artifacts.size()));
    }
}
