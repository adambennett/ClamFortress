package main.models.resources.refined;

import main.interfaces.*;
import main.models.resources.*;

public class Stone extends RefinedResource implements ResourceCost {
    public Stone() {
        super("Stone", "Refined, smoothed, rocks.");
    }

    @Override
    public Stone clone() {
        return new Stone();
    }
}
