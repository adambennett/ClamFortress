package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence;


import javax.persistence.*;
import java.io.*;

@Entity
public class UserStats implements Serializable {

    @Id
    @OneToOne(optional = false)
    private User user;

    private Integer enemiesKilled;
    private Integer villagersLost;
    private Integer daysSurvived;
    private Integer overallScore;
    private Integer highestCoins;
    private Integer highestResources;
    private Integer highestBuildings;
    private Integer highestPopulation;

    public UserStats() {}

    public UserStats(User user, Integer enemiesKilled, Integer villagersLost, Integer daysSurvived, Integer overallScore, Integer highestCoins, Integer highestResources, Integer highestBuildings, Integer highestPopulation) {
        this.user = user;
        this.enemiesKilled = enemiesKilled;
        this.villagersLost = villagersLost;
        this.daysSurvived = daysSurvived;
        this.overallScore = overallScore;
        this.highestCoins = highestCoins;
        this.highestResources = highestResources;
        this.highestBuildings = highestBuildings;
        this.highestPopulation = highestPopulation;
    }

    // Getters
    public Integer getEnemiesKilled() { return enemiesKilled; }
    public Integer getVillagersLost() { return villagersLost; }
    public Integer getDaysSurvived() { return daysSurvived; }
    public Integer getOverallScore() { return overallScore; }
    public Integer getHighestCoins() { return highestCoins; }
    public Integer getHighestBuildings() { return highestBuildings; }
    public Integer getHighestPopulation() { return highestPopulation; }
    public Integer getHighestResources() { return highestResources; }
    public User getUser() { return user; }

    // Setters
    public void setEnemiesKilled(Integer enemiesKilled) { this.enemiesKilled = enemiesKilled; }
    public void setVillagersLost(Integer villagersLost) { this.villagersLost = villagersLost; }
    public void setDaysSurvived(Integer daysSurvived) { this.daysSurvived = daysSurvived; }
    public void setOverallScore(Integer overallScore) { this.overallScore = overallScore; }
    public void setHighestCoins(Integer highestCoins) { this.highestCoins = highestCoins; }
    public void setHighestResources(Integer highestResources) { this.highestResources = highestResources; }
    public void setHighestBuildings(Integer highestBuildings) { this.highestBuildings = highestBuildings; }
    public void setHighestPopulation(Integer highestPopulation) { this.highestPopulation = highestPopulation; }
    public void setUser(User user) { this.user = user; }
}
