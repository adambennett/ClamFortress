package main.models;

import main.models.artifacts.AbstractArtifact;
import main.models.tools.*;

import java.util.*;

public class Inventory {

    private ArrayList<Tool> villageTools;
    private ArrayList<AbstractArtifact> villageArtifacts;

    public Inventory() {
        villageArtifacts = new ArrayList<>();
        villageTools = new ArrayList<>();
    }

    public void addArtifact(AbstractArtifact a){ villageArtifacts.add(a);}
    public void addTool(Tool t) {
        villageTools.add(t);
    }

    public Boolean containsTool(Tool t) {
        for (Tool tool : villageTools) {
            if (t.getClass().equals(tool.getClass())) {
                return true;
            }
        }
        return false;
    }

    public Boolean containsArtifact(AbstractArtifact a) {
        for (AbstractArtifact artifact : villageArtifacts) {
            if (a.getClass().equals(artifact.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "villageTools=" + villageTools +
                ", villageArtifacts=" + villageArtifacts +
                '}';
    }
}
