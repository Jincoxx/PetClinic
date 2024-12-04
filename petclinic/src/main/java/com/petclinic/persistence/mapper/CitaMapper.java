package com.petclinic.persistence.mapper;

import com.petclinic.domain.dto.CitaDTO;
import com.petclinic.persistence.entity.Cita;
import com.petclinic.persistence.entity.Mascota;
import com.petclinic.persistence.entity.Veterinario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    // Mapeo de Cita a CitaDTO
    @Mapping(source = "id", target = "id")
    //@Mapping(source = "fecha.hour", target = "fechaHora")
    @Mapping(target = "fechaHora", expression = "java(mapToLocalDateTime(cita.getFecha()))")
    @Mapping(source = "motivo", target = "motivo")
    @Mapping(source = "mascota.id", target = "mascotaId")
    @Mapping(source = "veterinario.id", target = "veterinarioId")
    CitaDTO toDto(Cita cita);

    // Mapeo inverso de CitaDTO a Cita
    @InheritInverseConfiguration
    @Mapping(target = "mascota", source = "mascotaId")
    @Mapping(target = "veterinario", source = "veterinarioId")
    Cita toEntity(CitaDTO citaDTO);




    // Métodos auxiliares para mapear `mascotaId` y `veterinarioId`
    default Mascota mapMascota(Long mascotaId) {
        if (mascotaId != null) {
            Mascota mascota = new Mascota();
            mascota.setId(mascotaId);
            return mascota;
        }
        return null;
    }


    default Veterinario mapVeterinario(Integer veterinarioId) {
        if (veterinarioId != null) {
            Veterinario veterinario = new Veterinario();
            veterinario.setId(veterinarioId);
            return veterinario;
        }
        return null;
    }

    default Long mapMascotaToId(Mascota mascota) {
        return (mascota != null) ? mascota.getId() : null;
    }

    default Integer mapVeterinarioToId(Veterinario veterinario) {
        return (veterinario != null) ? veterinario.getId() : null;
    }

    // Método de conversión para mapear String a LocalDateTime
    default LocalDateTime mapToLocalDateTime(String fecha) {
        if (fecha != null) {
            // Si el formato es "yyyy-MM-dd HH:mm:ss", puedes usar DateTimeFormatter para convertirlo
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(fecha, formatter);
        }
        return null;
    }
}
