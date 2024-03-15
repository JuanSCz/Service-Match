package com.serviceMatch.serviceMatch.entities;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Provider extends AppUser {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "provider_skill", joinColumns = @JoinColumn(name = "provider_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    @OneToOne
    private Image imagen;

    @Override
    public String toString() {
        // Llamar al toString de la superclase y agregar los detalles específicos de
        // Provider
        return "Provider{Skills=" + skills + "', superclassDetails='" + super.toString() + "'}";
    }
}
