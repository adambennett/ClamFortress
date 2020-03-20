package main.models.animals.land;

import main.models.animals.*;

public class Duck extends AbstractLandAnimal {

    public Duck() {
        super("Duck", "Duck is the common name for numerous species in the waterfowl family Anatidae which also includes swans and geese. Ducks are divided among several subfamilies in the family Anatidae; they do not represent a monophyletic group but a form taxon, since swans and geese are not considered ducks.",14);
    }

    @Override
    public Duck clone() {
        return new Duck();
    }
}
