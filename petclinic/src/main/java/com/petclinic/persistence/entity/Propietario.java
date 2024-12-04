package com.petclinic.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "propietario")
public class Propietario {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    private String telefono;

    @OneToMany(mappedBy = "propietario")
    private List<Mascota> mascotas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
