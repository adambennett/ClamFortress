package main.models.resources.refined;

import main.interfaces.*;
import main.models.resources.*;

public class Lumber extends RefinedResource implements ResourceCost {
    public Lumber() {
        super("Lumber", "Created by milling wood. Used to build basic structures.");
    }

    @Override
    public Lumber clone() {
        return new Lumber();
    }
}
