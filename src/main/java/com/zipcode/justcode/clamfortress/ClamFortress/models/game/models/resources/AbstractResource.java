package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

public abstract class AbstractResource extends GameObject {

    public AbstractResource(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public abstract AbstractResource clone();
}
