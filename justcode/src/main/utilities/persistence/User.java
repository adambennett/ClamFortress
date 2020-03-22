package main.utilities.persistence;

import main.utilities.builders.*;

public class User {

    private String name;
    private String pass;
    private UserStats stats;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
        this.stats = new StatBuilder().createUserStats();
    }

    // Getters
    public String getName() { return name; }
    public String getPass() { return pass; }
    public UserStats getStats() { return stats; }

    // Setters
    public void setPass(String pass) { this.pass = pass; }
    public void setName(String name) { this.name = name; }
    public void setStats(UserStats stats) { this.stats = stats; }
}
