package main.models.items.artifacts;

import main.interfaces.*;

public class RabbitFoot extends AbstractArtifact implements Unique {
    public RabbitFoot() {
        super("Rabbit's Foot", "Decreases bad random encounter occurrence rate.");
    }
}
