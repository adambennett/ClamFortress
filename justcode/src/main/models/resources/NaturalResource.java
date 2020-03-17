package main.models.resources;

public abstract class NaturalResource extends Resource {

    public RefinedResource refined;

    public RefinedResource getRefined(){
        return this.refined;
    }
}
