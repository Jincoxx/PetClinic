package com.petclinic.persistence.repositoryImpl;

import com.petclinic.domain.dto.CitaDTO;
import com.petclinic.domain.repository.CitaRepository;
import com.petclinic.persistence.crud.CitaCrudRepository;
import com.petclinic.persistence.entity.Cita;
import com.petclinic.persistence.mapper.CitaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CitaRepositoryImpl implements CitaRepository {

    @Autowired
    private CitaCrudRepository citaCrudRepository;

    @Autowired
    private CitaMapper citaMapper;

    // Consultar todos los registros
    @Override
    public Iterable<CitaDTO> findAll() {
        Iterable<Cita> citas = citaCrudRepository.findAll();
        return ((List<Cita>) citas).stream()
                .map(citaMapper::toDto)
                .collect(Collectors.toList());
    }

    // Consultar por ID
    @Override
    public Optional<CitaDTO> findById(Integer id) {
        Optional<Cita> cita = citaCrudRepository.findById(id);
        return cita.map(citaMapper::toDto);
    }

    // Guardar
    @Override
    public CitaDTO save(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        if (!existsById(cita.getId())) {
            Cita savedCita = citaCrudRepository.save(cita);
            return citaMapper.toDto(savedCita);
        }
        throw new IllegalArgumentException("El registro ya existe");
    }

    // Actualizar
    @Override
    public CitaDTO update(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        if (existsById(cita.getId())) {
            Cita updatedCita = citaCrudRepository.save(cita);
            return citaMapper.toDto(updatedCita);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    // Eliminar
    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            citaCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    // Validar si existe por ID
    @Override
    public boolean existsById(Integer id) {
        return citaCrudRepository.existsById(id);
    }

    // Contar todos los registros
    @Override
    public long count() {
        return citaCrudRepository.count();
    }

    @Override
    public Iterable<CitaDTO> findByVeterinarioIdAndFechaHoraBetween(Integer veterinarioId, String startDate, String endDate) {
        // Realizamos la consulta con los parámetros necesarios
        List<Cita> citas = citaCrudRepository.findByVeterinarioIdAndFechaHoraBetween(veterinarioId, startDate, endDate);
        // Convertimos las citas obtenidas a DTOs y las retornamos
        return citas.stream()
                .map(citaMapper::toDto)
                .collect(Collectors.toList());
    }

    // Implementación de la consulta para buscar citas por mascotaId
    @Override
    public Iterable<CitaDTO> findByMascotaId(Integer mascotaId) {
        // Realizamos la consulta de citas por mascotaId
        List<Cita> citas = citaCrudRepository.findByMascotaId(mascotaId);
        // Convertimos las citas obtenidas a DTOs y las retornamos
        return citas.stream()
                .map(citaMapper::toDto)
                .collect(Collectors.toList());
    }


}
