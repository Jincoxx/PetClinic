package com.petclinic.domain.repository;

import com.petclinic.domain.dto.CitaDTO;

import java.util.Optional;

public interface CitaRepository {

    // Consultar todos los registros
    Iterable<CitaDTO> findAll();

    // Consultar por ID
    Optional<CitaDTO> findById(Integer id);

    // Guardar un registro
    CitaDTO save(CitaDTO citaDTO);

    // Actualizar un registro
    CitaDTO update(CitaDTO citaDTO);

    // Eliminar un registro
    void delete(Integer id);

    // Validar si existe por ID
    boolean existsById(Integer id);

    // Contar todos los registros
    long count();

    // Método para buscar citas por ID de mascota
    Iterable<CitaDTO> findByMascotaId(Integer mascotaId);

    // Buscar citas de un veterinario en un rango de fechas
    Iterable<CitaDTO> findByVeterinarioIdAndFechaHoraBetween(Integer veterinarioId, String startDate, String endDate);


}
