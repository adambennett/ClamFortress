package clamFortress.tech.eras;

import clamFortress.tech.*;

public abstract class Era {

    private Era prev;
    private Era next;

    public Era() {}

    public Era(Era prev) {
        this(null, prev);
    }

    public Era(Era next, Era prev) {
        this.next = next;
        this.prev = prev;
    }

    public boolean isAheadOf(Era era) {
        if (this.hasPrev() && this.prev.getClass().equals(era.getClass())) {
            return true;
        }
        if (this.hasNext() && this.next.getClass().equals(era.getClass())) {
            return false;
        } else {
            Era curr = this;
            while (curr.hasNext()) {
                if (curr.getNext().getClass().equals(era.getClass())) {
                    return false;
                }
                curr = curr.getNext();
            }
        }
        return true;
    }

    public boolean isBehind(Era era) {
        return !isAheadOf(era);
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
}
