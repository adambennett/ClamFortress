package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class RabbitFoot extends AbstractArtifact implements Unique {
    public RabbitFoot() {
        super("Rabbit's Foot", "Decreases bad random encounter occurrence rate.");
    }

    @Override
    public RabbitFoot clone() {
        return new RabbitFoot();
    }
}
