package main.models.items.tools.engineering;

import main.models.items.tools.*;
import main.models.items.tools.crafting.*;

public class Blueprint extends AbstractEngTool {
    public Blueprint() {
        super("Blueprint", "");
    }

    @Override
    public Blueprint clone() {
        return new Blueprint();
    }
}
