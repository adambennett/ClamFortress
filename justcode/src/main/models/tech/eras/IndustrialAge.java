package main.models.tech.eras;

public class IndustrialAge extends Era {

    private static final String localName = "Industrial Age";

    public IndustrialAge() {
        super(localName);
    }

    public IndustrialAge(boolean techTreeInit) { super(localName, true); }

    @Override
    public IndustrialAge clone() {
        return new IndustrialAge();
    }
}
