package main.models.animals.land;

import main.models.animals.*;

public class Buffalo extends AbstractLandAnimal {

    public Buffalo() {
        super("Buffalo", "The American bison or simply bison, also commonly known as the American buffalo or simply buffalo, is a North American species of bison that once roamed North America in vast herds.", 250);
    }

    @Override
    public Buffalo clone() {
        return new Buffalo();
    }
}
