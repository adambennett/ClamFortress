package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;

@Entity
public abstract class AbstractArtifact extends AbstractItem {

    @Id
    @OneToOne(optional = false)
    private AbstractNode node;

    public AbstractArtifact() {
        super("Artifact", "Description");
    }

    public AbstractArtifact(String name, String desc) { super(name, desc); }

    public AbstractNode getNode() {
        return node;
    }

    public void setNode(AbstractNode node) {
        this.node = node;
    }

}
