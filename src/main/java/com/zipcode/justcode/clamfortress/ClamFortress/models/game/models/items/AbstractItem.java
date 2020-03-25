package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;
import java.util.*;

@Entity
public abstract class AbstractItem extends GameObject {

    @Id
    @OneToOne(optional = false)
    private AbstractNode node;

    public AbstractItem() {
        super("Item", "Description");
    }

    public AbstractItem(String name, String desc) {
        super(name, desc);
    }

    public AbstractNode getNode() {
        return node;
    }

    public void setNode(AbstractNode node) {
        this.node = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractItem)) return false;
        if (!super.equals(o)) return false;
        AbstractItem that = (AbstractItem) o;
        return Objects.equals(getDesc(), that.getDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDesc());
    }

    @Override
    public abstract AbstractItem clone();
}
