package com.petclinic.persistence.mapper;

import com.petclinic.domain.dto.CitaDTO;
import com.petclinic.persistence.entity.Cita;
import com.petclinic.persistence.entity.Mascota;
import com.petclinic.persistence.entity.Veterinario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T15:15:14-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class CitaMapperImpl implements CitaMapper {

    @Override
    public CitaDTO toDto(Cita cita) {
        if ( cita == null ) {
            return null;
        }

        CitaDTO citaDTO = new CitaDTO();

        citaDTO.setId( cita.getId() );
        citaDTO.setMotivo( cita.getMotivo() );
        Long id = citaMascotaId( cita );
        if ( id != null ) {
            citaDTO.setMascotaId( id.intValue() );
        }
        citaDTO.setVeterinarioId( citaVeterinarioId( cita ) );

        citaDTO.setFechaHora( mapToLocalDateTime(cita.getFecha()) );

        return citaDTO;
    }

    @Override
    public Cita toEntity(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Cita cita = new Cita();

        if ( citaDTO.getMascotaId() != null ) {
            cita.setMascota( mapMascota( citaDTO.getMascotaId().longValue() ) );
        }
        cita.setVeterinario( mapVeterinario( citaDTO.getVeterinarioId() ) );
        cita.setId( citaDTO.getId() );
        cita.setMotivo( citaDTO.getMotivo() );

        return cita;
    }

    private Long citaMascotaId(Cita cita) {
        if ( cita == null ) {
            return null;
        }
        Mascota mascota = cita.getMascota();
        if ( mascota == null ) {
            return null;
        }
        Long id = mascota.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer citaVeterinarioId(Cita cita) {
        if ( cita == null ) {
            return null;
        }
        Veterinario veterinario = cita.getVeterinario();
        if ( veterinario == null ) {
            return null;
        }
        Integer id = veterinario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
