package main.models.items.tools.engineering;

import main.models.items.tools.*;
import main.models.items.tools.crafting.*;

public class Blueprint extends AbstractEngTool {
    public Blueprint() {
        super("Blueprint", "Used to learn about new structures to Build.");
    }

    @Override
    public Blueprint clone() {
        return new Blueprint();
    }
}
