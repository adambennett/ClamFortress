package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class User implements Comparable<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "id")
    private Long id;

    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @Column(nullable = false, name = "pass")
    private String pass;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user", targetEntity = UserStats.class)
    private UserStats stats;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user", targetEntity = Game.class)
    private List<Game> savedGames;

    public User() {}

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
        this.stats = new StatBuilder().createUserStats();
        this.stats.setUser(this);
        this.savedGames = new ArrayList<>();
    }

    public void addGame(Game game) {
        this.savedGames.add(game);
    }

    public List<Game> updateSavedGames(Game game) {
        ArrayList<Game> newSaved = new ArrayList<>();
        boolean found = false;
        for (Game g : this.savedGames) {
            if (g.getId().equals(game.getId())) {
                newSaved.add(game);
                found = true;
            } else {
                newSaved.add(g);
            }
        }
        if (!found) { newSaved.add(game); }
        return newSaved;
    }

    // Getters
    public String getName() { return name; }
    public String getPass() { return pass; }
    public UserStats getStats() { return stats; }
    public Long getId() { return id; }
    public List<Game> getSavedGames() { return savedGames; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setPass(String pass) { this.pass = pass; }
    public void setName(String name) { this.name = name; }
    public void setStats(UserStats stats) { this.stats = stats; }
    public void setSavedGames(List<Game> savedGames) { this.savedGames = savedGames; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

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
