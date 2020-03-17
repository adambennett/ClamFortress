package main.models.animals.jungle;

import main.interfaces.Mythical;

public class Jungleape extends JungleAnimal implements Mythical {
    @Override
    public Jungleape clone() {
        return new Jungleape();
    }
}
