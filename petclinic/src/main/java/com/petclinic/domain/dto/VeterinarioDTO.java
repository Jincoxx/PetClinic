package com.petclinic.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class VeterinarioDTO {

    private Integer id;
    private String nombre;
    private String especialidad;
    private String telefono;

    // Constructor
    public VeterinarioDTO(Integer id, String nombre, String especialidad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }
}
