package main.models;

import main.interfaces.*;
import main.models.items.*;
import main.models.items.artifacts.AbstractArtifact;
import main.models.items.tools.*;

import java.util.*;

public class Inventory {

    private ArrayList<Tool> villageTools;
    private ArrayList<AbstractItem> items;
    private ArrayList<AbstractArtifact> artifacts;

    public Inventory() {

        villageTools = new ArrayList<>();
        items = new ArrayList<>();
        artifacts = new ArrayList<>();
    }

    public void addItem(AbstractItem item){
        if (!(item instanceof Unique && items.contains(item))) {
            items.add(item);
        }
    }

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

    public Boolean hasArtifact(AbstractArtifact art) {
        for (AbstractArtifact a : this.artifacts) {
            if (a.getClass().equals(art.getClass())) {
                return true;
            }
        }
        return false;
    }

    public Boolean containsArtifact(AbstractArtifact artifact ){
        for (AbstractArtifact a : artifacts) {
            if (a.getClass().equals(artifact.getClass())) {
                return true;
            }
        }
        return false;
    }

    public void addArtifact(AbstractArtifact art) { if (!hasArtifact(art)) { this.artifacts.add(art); }}

    public ArrayList<Tool> getVillageTools() {
        return villageTools;
    }

    public void setVillageTools(ArrayList<Tool> villageTools) {
        this.villageTools = villageTools;
    }

    public ArrayList<AbstractItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<AbstractItem> items) {
        this.items = items;
    }

    public ArrayList<AbstractArtifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(ArrayList<AbstractArtifact> artifacts) {
        this.artifacts = artifacts;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "villageTools=" + villageTools +
                '}';
    }
}
