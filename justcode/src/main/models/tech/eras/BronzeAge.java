package main.models.tech.eras;

public class BronzeAge extends Era {

    private static final String localName = "Bronze Age";

    public BronzeAge() {
        super(localName);
    }

    public BronzeAge(boolean techTreeInit) { super(localName, true); }

    @Override
    public BronzeAge clone() {
        return new BronzeAge();
    }
}
