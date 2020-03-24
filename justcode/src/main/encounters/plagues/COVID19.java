package main.encounters.plagues;

public class COVID19 extends AbstractPlague {

    public COVID19(int turns) {
        super("COVID19", "A terrible pandemic that everyone secretly hopes Trump catches.", turns);
    }

    @Override
    public String toString() {
        return "COVID-19 has stricken your village for " + this.turnsActive +" turns!";
    }

    @Override
    public COVID19 clone() {
        return new COVID19(this.turnsActive);
    }
}
