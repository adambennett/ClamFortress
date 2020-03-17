package main.models.animals.jungle;

import main.interfaces.Mythical;

public class Wildabeast extends JungleAnimal implements Mythical {
    @Override
    public Wildabeast clone() {
        return new Wildabeast();
    }
}
