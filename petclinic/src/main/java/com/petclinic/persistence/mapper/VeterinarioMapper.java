package com.petclinic.persistence.mapper;

import com.petclinic.domain.dto.VeterinarioDTO;
import com.petclinic.persistence.entity.Veterinario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeterinarioMapper {

    // Mapeo de Veterinario a VeterinarioDTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "especialidad", target = "especialidad")
    @Mapping(source = "telefono", target = "telefono")
    VeterinarioDTO toDto(Veterinario veterinario);

    // Mapeo inverso de VeterinarioDTO a Veterinario
    @InheritInverseConfiguration
    @Mapping(target = "citas", ignore = true) // Ignorar la relación con Cita
    Veterinario toEntity(VeterinarioDTO veterinarioDTO);
}
