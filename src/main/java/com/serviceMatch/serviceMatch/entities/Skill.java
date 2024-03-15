package com.serviceMatch.serviceMatch.entities;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    private String name;
    private boolean active;

    @ManyToMany(mappedBy = "skills")
    private List<Provider> providers;

    @Override
    public String toString() {
        return "Skill{id=" + id + ", skillName='" + name + ", active='" + active + "'}";
    }
}
