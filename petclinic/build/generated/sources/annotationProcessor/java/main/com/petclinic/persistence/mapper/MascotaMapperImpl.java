package com.petclinic.persistence.mapper;

import com.petclinic.domain.dto.MascotaDTO;
import com.petclinic.persistence.entity.Mascota;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T15:15:14-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class MascotaMapperImpl implements MascotaMapper {

    @Override
    public MascotaDTO toDto(Mascota mascota) {
        if ( mascota == null ) {
            return null;
        }

        MascotaDTO mascotaDTO = new MascotaDTO();

        mascotaDTO.setNombre( mascota.getNombre() );
        mascotaDTO.setEspecie( mascota.getEspecie() );
        mascotaDTO.setEdad( mascota.getEdad() );
        mascotaDTO.setGenero( mascota.getGenero() );
        mascotaDTO.setPropietarioId( map( mascota.getPropietario() ) );
        mascotaDTO.setId( mascota.getId() );

        return mascotaDTO;
    }

    @Override
    public Mascota toEntity(MascotaDTO mascotaDTO) {
        if ( mascotaDTO == null ) {
            return null;
        }

        Mascota mascota = new Mascota();

        mascota.setPropietario( map( mascotaDTO.getPropietarioId() ) );
        mascota.setNombre( mascotaDTO.getNombre() );
        mascota.setEspecie( mascotaDTO.getEspecie() );
        mascota.setEdad( mascotaDTO.getEdad() );
        mascota.setGenero( mascotaDTO.getGenero() );
        mascota.setId( mascotaDTO.getId() );

        return mascota;
    }
}
