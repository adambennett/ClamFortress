package main.models.animals.jungle;

import main.interfaces.Mythical;

public class Forestdweller extends JungleAnimal implements Mythical {
    @Override
    public Forestdweller clone() {
        return new Forestdweller();
    }
}
