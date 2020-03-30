package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.*;

public abstract class Era extends GameObject {

    private Era prev;
    private Era next;

    public Era(String name, String desc) {
        super(name, desc);
        Era gen = generate();
        this.next = gen.getNext();
        this.prev = gen.getPrev();
    }

    public Era(String name, String desc, boolean initTechTree) {
        super(name, desc);
    }

    private Era generate() {
        return getNodeFromTree(this);
    }

    private static Era getNodeFromTree(Era newEra) {
        if (TechTree.getHead().getName().equals(newEra.getName())) {
            return TechTree.getHead();
        }

        Era curr = TechTree.getHead();
        while (curr.hasNext()) {
            if (curr.getNext().getName().equals(newEra.getName())) {
                return curr.getNext();
            }
            curr = curr.getNext();
        }
        return null;
    }

    public boolean atLeast(Era era) {
       return this.equals(era) || isAheadOf(era);
    }

    public boolean isAheadOf(Era era) {
        int indexThis = -1;
        int indexThat = -1;
        Era curr = TechTree.getHead();
        int indexOn = 0;
        while (curr != null) {
            if (curr.equals(this)) {
                indexThis = indexOn;
            } else if (curr.equals(era)) {
                indexThat = indexOn;
            }
            indexOn++;
            curr = curr.getNext();
        }
        return indexThis > indexThat;
    }

    public boolean isBehind(Era era) {
        int indexThis = -1;
        int indexThat = -1;
        Era curr = TechTree.getHead();
        int indexOn = 0;
        while (curr != null) {
            if (curr.equals(this)) {
                indexThis = indexOn;
            } else if (curr.equals(era)) {
                indexThat = indexOn;
            }
            indexOn++;
            curr = curr.getNext();
        }
        return indexThis < indexThat;
    }

    public Era advanceToEnd() {
        Era node = this;
        while (node.hasNext()) {
            node = node.getNext();
        }
        return node;
    }

    public Boolean hasNext() {
        return this.next != null;
    }

    public Boolean hasPrev() {
        return this.prev != null;
    }

    public Era getPrev() {
        return prev;
    }

    public void setPrev(Era prev) {
        this.prev = prev;
    }

    public Era getNext() {
        return next;
    }

    public void setNext(Era next) {
        this.next = next;
    }

    @Override
    public abstract Era clone();

    @Override
    public String toString() {
        return this.getName();
    }
}
