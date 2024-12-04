package com.petclinic.persistence.mapper;

import com.petclinic.domain.dto.MascotaDTO;
import com.petclinic.persistence.entity.Mascota;
import com.petclinic.persistence.entity.Propietario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MascotaMapper {

    // Mapeo de Mascota a MascotaDTO
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "especie", target = "especie")
    @Mapping(source = "edad", target = "edad")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "propietario", target = "propietarioId")
    MascotaDTO toDto(Mascota mascota);

    // Mapeo inverso de MascotaDTO a Mascota
    @InheritInverseConfiguration
    //@Mapping(target = "propietarioId", source = "propietario")
    @Mapping(target = "propietario", source = "propietarioId")
    Mascota toEntity(MascotaDTO mascotaDTO);

    // Método de mapeo explícito para convertir Propietario a Long (su id)
    @Mapping(target = "id", source = "propietario")
    default Long map(Propietario propietario) {
        if (propietario != null) {
            return propietario.getId();  // Retorna el id del propietario
        }
        return null;
    }

    // Método de mapeo explícito para convertir Long (id) a Propietario
    @Mapping(target = "id", source = "propietarioId")
    default Propietario map(Long propietarioId) {
        if (propietarioId != null) {
            Propietario propietario = new Propietario();
            propietario.setId(propietarioId);  // Crear Propietario con el id proporcionado
            return propietario;
        }
        return null;
    }
}
