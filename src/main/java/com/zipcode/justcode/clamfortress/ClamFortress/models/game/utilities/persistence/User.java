package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders.*;

import javax.persistence.*;

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

    public User() {}

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
        this.stats = new StatBuilder().createUserStats();
        this.stats.setUser(this);
    }

    // Getters
    public String getName() { return name; }
    public String getPass() { return pass; }
    public UserStats getStats() { return stats; }
    public Long getId() { return id; }

    // Setters
    public void setPass(String pass) { this.pass = pass; }
    public void setName(String name) { this.name = name; }
    public void setStats(UserStats stats) { this.stats = stats; }
    public void setId(Long id) { this.id = id; }

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
