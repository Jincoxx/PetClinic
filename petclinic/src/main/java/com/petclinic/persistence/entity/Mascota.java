package com.petclinic.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String especie;

    private Integer edad;

    private String genero;

    @ManyToOne
    @JoinColumn(name = "propietario_id", nullable = false)
    private Propietario propietario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*@OneToMany(mappedBy = "mascota")
    private List<ControlPeso> controlPeso;

    @OneToMany(mappedBy = "mascota")
    private List<Desparasitacion> desparasitaciones;

    @OneToMany(mappedBy = "mascota")
    private List<Vacunacion> vacunaciones;*/
}
