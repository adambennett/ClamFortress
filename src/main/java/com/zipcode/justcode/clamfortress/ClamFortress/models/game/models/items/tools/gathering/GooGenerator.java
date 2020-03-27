package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.concurrent.*;

public class GooGenerator extends AbstractGatheringTool {
    public GooGenerator() {
        super("Goo Generator", "Generates Spacegoo passively at the start of each standby phase.");
    }

    @Override
    public Boolean canObtain() {
        return TechTree.getCurrentEra().equals(TechTree.getTail());
    }

    @Override
    public void standbyPhase() {
        Database.getCurrentGame().getVillage().addResource(new Spacegoo(), ThreadLocalRandom.current().nextInt(100, 200));
    }

    @Override
    public GooGenerator clone() {
        return new GooGenerator();
    }
}
