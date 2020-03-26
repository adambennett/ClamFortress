package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence;

import javax.persistence.*;

@Entity
public class Name {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "id")
    private Long id;

    @Column(nullable = false, unique = true, name = "name")
    private String name;

    public Name() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
