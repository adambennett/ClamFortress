package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.merchants;


import com.fasterxml.jackson.annotation.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;

import javax.persistence.*;
import java.util.*;
import java.util.concurrent.*;

@Entity
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Village village;

    @ElementCollection
    @CollectionTable(name = "merchant_items",
            joinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "price")
    private final Map<String, Integer> wares;

    private Integer turnsAvailable;
    private Integer items;
    private String name;
    private Integer turnsVisited;

    public Merchant() {
        this.turnsVisited = 0;
        this.wares = new HashMap<>();
        this.name = GameStrings.getRandomName(false);
        this.items = rollItemCount();
        this.turnsAvailable = rollTurnsAvailable();
        setupWares();
    }

    public Integer rollTurnsAvailable() {
        return ThreadLocalRandom.current().nextInt(1, 4);
    }

    private Integer rollItemCount() {
        if (Database.getCurrentGame() != null) {
            return ThreadLocalRandom.current().nextInt(3, Database.getCurrentGame().gameManager.getMerchantItems());
        } else {
            return ThreadLocalRandom.current().nextInt(3, 9);
        }
    }

    public void setupWares() {
        if (Database.getCurrentGame() != null) {
            ArrayList<GameObject> allObjs = Archive.getInstance().getArchive();
            while (wares.size() < items) {
                GameObject ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
                while (wares.containsKey(ref.getName().toLowerCase()) || (ref instanceof AbstractAnimal)) {
                    ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
                }
                wares.put(ref.getName().toLowerCase(), ThreadLocalRandom.current().nextInt(100 * Database.getCurrentGame().getDifficulty().getCostMod(), 1000 * Database.getCurrentGame().getDifficulty().getCostMod()));
            }
        }
    }

    public void purchase(String key, int amtPaid) {
        this.wares.remove(key.toLowerCase());
        for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
            obj.onPurchaseItem(Archive.getInstance().get(key), amtPaid);
        }
    }

    public void visit() {
        this.turnsVisited++;
        if (this.turnsVisited >= this.turnsAvailable || this.wares.size() < 1) {
            Database.getCurrentGame().getVillage().getVistingMerchants().remove(this);
            OutputManager.addToBot("Merchant " + name + " has left the region.");
        } else {
            OutputManager.addToBot("Merchant " + name + " will stick around for " + (this.turnsAvailable - this.turnsVisited) + " more turns.");
        }
    }

    public Map<String, Integer> getWares() {
        return wares;
    }

    public Boolean contains(String item) {
        return wares.containsKey(item) || wares.containsKey(item.toLowerCase()) || wares.containsKey(item.toUpperCase()) || wares.containsKey(StringHelpers.capFirstLetter(item.toLowerCase()));
    }

    public String getMerchantType() {
        return "Traveling Merchant";
    }

    public Integer getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public void setTurnsAvailable(Integer turnsAvailable) {
        this.turnsAvailable = turnsAvailable;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTurnsAvailable() {
        return turnsAvailable;
    }

    public Integer getTurnsVisited() {
        return turnsVisited;
    }

    public void setTurnsVisited(Integer turnsVisited) {
        this.turnsVisited = turnsVisited;
    }
}
