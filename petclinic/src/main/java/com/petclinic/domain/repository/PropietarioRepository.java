package com.petclinic.domain.repository;

import com.petclinic.domain.dto.PropietarioDTO;

import java.util.Optional;

public interface PropietarioRepository {

    // Consultar todos los registros
    Iterable<PropietarioDTO> findAll();

    // Consultar por ID
    Optional<PropietarioDTO> findById(Long id);

    // Guardar
    PropietarioDTO save(PropietarioDTO propietarioDTO);

    // Actualizar
    PropietarioDTO update(PropietarioDTO propietarioDTO);

    // Eliminar
    void delete(Long id);

    // Validar si existe por ID
    boolean existsById(Long id);

    // Contar todos los registros
    long count();
}
