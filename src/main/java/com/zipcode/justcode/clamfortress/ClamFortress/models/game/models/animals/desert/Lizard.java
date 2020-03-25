package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.desert;

public class Lizard extends AbstractDesertAnimal {

    public Lizard() {
        super("Lizard", "Lizards are a widespread group of squamate reptiles, with over 6,000 species, ranging across all continents except Antarctica, as well as most oceanic island chains.", 15);
    }

    @Override
    public Lizard clone() {
        return new Lizard();
    }
}
