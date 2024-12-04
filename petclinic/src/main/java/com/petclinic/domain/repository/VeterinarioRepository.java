package com.petclinic.domain.repository;

import com.petclinic.domain.dto.VeterinarioDTO;

import java.util.Optional;

public interface VeterinarioRepository {

    // Consultar todos los registros
    Iterable<VeterinarioDTO> findAll();

    // Consultar por ID
    Optional<VeterinarioDTO> findById(Integer id);

    // Guardar un registro
    VeterinarioDTO save(VeterinarioDTO veterinarioDTO);

    // Actualizar un registro
    VeterinarioDTO update(VeterinarioDTO veterinarioDTO);

    // Eliminar un registro
    void delete(Integer id);

    // Validar si existe por ID
    boolean existsById(Integer id);

    // Contar todos los registros
    long count();

    // Buscar veterinarios por especialidad
    Iterable<VeterinarioDTO> findByEspecialidad(String especialidad);
}
