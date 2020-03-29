package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes;


public abstract class AbstractBiome {
    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof AbstractBiome) ? this.toString().equals(obj.toString()) : super.equals(obj);
    }
}
