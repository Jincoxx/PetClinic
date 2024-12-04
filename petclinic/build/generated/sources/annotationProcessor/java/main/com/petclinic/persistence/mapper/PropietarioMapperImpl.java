package com.petclinic.persistence.mapper;

import com.petclinic.domain.dto.PropietarioDTO;
import com.petclinic.persistence.entity.Propietario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T15:15:14-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class PropietarioMapperImpl implements PropietarioMapper {

    @Override
    public PropietarioDTO toDto(Propietario propietario) {
        if ( propietario == null ) {
            return null;
        }

        PropietarioDTO propietarioDTO = new PropietarioDTO();

        propietarioDTO.setId( propietario.getId() );
        propietarioDTO.setNombre( propietario.getNombre() );
        propietarioDTO.setTelefono( propietario.getTelefono() );
        propietarioDTO.setDireccion( propietario.getDireccion() );

        return propietarioDTO;
    }

    @Override
    public Propietario toEntity(PropietarioDTO propietarioDTO) {
        if ( propietarioDTO == null ) {
            return null;
        }

        Propietario propietario = new Propietario();

        propietario.setId( propietarioDTO.getId() );
        propietario.setNombre( propietarioDTO.getNombre() );
        propietario.setTelefono( propietarioDTO.getTelefono() );
        propietario.setDireccion( propietarioDTO.getDireccion() );

        return propietario;
    }
}
