package com.petclinic.domain.service;

import com.petclinic.domain.dto.CitaDTO;
import com.petclinic.domain.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    // Consultar todos los registros
    public Iterable<CitaDTO> findAll() {
        return citaRepository.findAll();
    }

    // Consultar por ID, devolviendo un Optional
    public Optional<CitaDTO> findById(Integer id) {
        return citaRepository.findById(id); // Devuelve Optional
    }

    // Guardar un registro
    public CitaDTO save(CitaDTO citaDTO) {
        return citaRepository.save(citaDTO);
    }

    // Actualizar un registro
    public CitaDTO update(CitaDTO citaDTO) {
        return citaRepository.update(citaDTO);
    }

    // Eliminar un registro
    public void delete(Integer id) {
        citaRepository.delete(id);
    }

    // Validar si existe por ID
    public boolean existsById(Integer id) {
        return citaRepository.existsById(id);
    }

    // Contar todos los registros
    public long count() {
        return citaRepository.count();
    }

    // Buscar todas las citas de una mascota
    public Iterable<CitaDTO> findByMascotaId(Integer mascotaId) {
        return citaRepository.findByMascotaId(mascotaId);
    }

    // Buscar citas de un veterinario en un rango de fechas
    public Iterable<CitaDTO> findByVeterinarioIdAndFechaHoraBetween(Integer veterinarioId, String startDate, String endDate) {
        return citaRepository.findByVeterinarioIdAndFechaHoraBetween(veterinarioId, startDate, endDate);
    }
}
