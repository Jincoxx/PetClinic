package com.petclinic.persistence.mapper;

import com.petclinic.domain.dto.PropietarioDTO;
import com.petclinic.persistence.entity.Propietario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PropietarioMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "direccion", source = "direccion")
    PropietarioDTO toDto(Propietario propietario);

    @InheritInverseConfiguration
    @Mapping(target = "mascotas", ignore = true) // Si hay alguna relación que no se debe mapear explícitamente
    Propietario toEntity(PropietarioDTO propietarioDTO);
}
