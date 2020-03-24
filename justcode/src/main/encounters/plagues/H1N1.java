package main.encounters.plagues;

import main.models.*;

public class H1N1 extends AbstractPlague {

    public H1N1(int turns) {
        super("H1N1", "Swine flu", turns);
    }

    @Override
    public String toString() {
        return "H1N1 has stricken your village for " + this.turnsActive + " turns!";
    }

    @Override
    public H1N1 clone() {
        return new H1N1(this.turnsActive);
    }
}
