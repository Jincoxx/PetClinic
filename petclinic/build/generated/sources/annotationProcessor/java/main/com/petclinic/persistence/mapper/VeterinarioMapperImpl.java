package com.petclinic.persistence.mapper;

import com.petclinic.domain.dto.VeterinarioDTO;
import com.petclinic.persistence.entity.Veterinario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T15:15:14-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class VeterinarioMapperImpl implements VeterinarioMapper {

    @Override
    public VeterinarioDTO toDto(Veterinario veterinario) {
        if ( veterinario == null ) {
            return null;
        }

        VeterinarioDTO veterinarioDTO = new VeterinarioDTO();

        veterinarioDTO.setId( veterinario.getId() );
        veterinarioDTO.setNombre( veterinario.getNombre() );
        veterinarioDTO.setEspecialidad( veterinario.getEspecialidad() );
        veterinarioDTO.setTelefono( veterinario.getTelefono() );

        return veterinarioDTO;
    }

    @Override
    public Veterinario toEntity(VeterinarioDTO veterinarioDTO) {
        if ( veterinarioDTO == null ) {
            return null;
        }

        Veterinario veterinario = new Veterinario();

        veterinario.setId( veterinarioDTO.getId() );
        veterinario.setNombre( veterinarioDTO.getNombre() );
        veterinario.setEspecialidad( veterinarioDTO.getEspecialidad() );
        veterinario.setTelefono( veterinarioDTO.getTelefono() );

        return veterinario;
    }
}
