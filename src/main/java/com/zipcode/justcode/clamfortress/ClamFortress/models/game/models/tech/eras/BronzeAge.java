package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras;

public class BronzeAge extends Era {

    private static final String localName = "Bronze Age";
    private static final String localDesc = "Age #2";

    public BronzeAge() {
        super(localName, localDesc);
    }

    public BronzeAge(boolean techTreeInit) { super(localName, localDesc, true); }

    @Override
    public BronzeAge clone() {
        return new BronzeAge();
    }
}
