package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras;

public class FutureAge extends Era {

    private static final String localName = "Future";
    private static final String localDesc = "Age #7";

    public FutureAge() {
        super(localName, localDesc);
    }

    public FutureAge(boolean techTreeInit) { super(localName, localDesc, true); }

    @Override
    public FutureAge clone() {
        return new FutureAge();
    }
}
