package main.models.animals.desert;

public class Camel extends AbstractDesertAnimal {

    public Camel() {
        super("Camel", "A camel is an even-toed ungulate in the genus Camelus that bears distinctive fatty deposits known as \"humps\" on its back. Camels have long been domesticated and, as livestock, they provide food and textiles.", 175);
    }

    @Override
    public Camel clone() {
        return new Camel();
    }
}
