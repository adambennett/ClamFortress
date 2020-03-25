package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras;

public class StoneAge extends Era {

    private static final String localName = "Stone Age";
    private static final String localDesc = "Age #1";

    public StoneAge() {
        super(localName, localDesc);
    }

    public StoneAge(boolean techTreeInit) { super(localName, localDesc, true); }

    @Override
    public StoneAge clone() {
        return new StoneAge();
    }
}
