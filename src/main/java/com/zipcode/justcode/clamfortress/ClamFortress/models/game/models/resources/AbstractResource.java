package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;

@Entity
public abstract class AbstractResource extends GameObject {

    @Id
    @OneToOne(optional = false)
    private AbstractNode node;

    public AbstractResource() {
        super("Resource", "Description");
    }

    public AbstractResource(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public AbstractNode getNode() {
        return node;
    }

    public void setNode(AbstractNode node) {
        this.node = node;
    }

    @Override
    public abstract AbstractResource clone();
}
