package main.models.resources;

import main.models.*;

import java.util.*;

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
