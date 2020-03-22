package main.utilities.persistence;

import main.utilities.builders.*;

public class User implements Comparable<User> {

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

    @Override
    public int compareTo(User o) {
        Double thisKD = (double)this.stats.getEnemiesKilled() / (double)this.stats.getVillagersLost();
        Double thatKD = (double)o.getStats().getEnemiesKilled() / (double)o.getStats().getVillagersLost();
        return o.getStats().getOverallScore().compareTo(this.stats.getOverallScore()) != 0 ? o.getStats().getOverallScore().compareTo(this.stats.getOverallScore())
                : o.getStats().getDaysSurvived().compareTo(this.stats.getDaysSurvived()) != 0 ? o.getStats().getDaysSurvived().compareTo(this.stats.getDaysSurvived())
                : thatKD.compareTo(thisKD) != 0 ? thatKD.compareTo(thisKD)
                : o.getStats().getHighestCoins().compareTo(this.stats.getHighestCoins()) != 0 ? o.getStats().getHighestCoins().compareTo(this.stats.getHighestCoins())
                : o.getStats().getHighestPopulation().compareTo(this.stats.getHighestPopulation()) != 0 ? o.getStats().getHighestPopulation().compareTo(this.stats.getHighestPopulation())
                : o.getStats().getHighestResources().compareTo(this.stats.getHighestResources()) != 0 ? o.getStats().getHighestResources().compareTo(this.stats.getHighestResources())
                : o.getStats().getHighestBuildings().compareTo(this.stats.getHighestBuildings());
    }
}
