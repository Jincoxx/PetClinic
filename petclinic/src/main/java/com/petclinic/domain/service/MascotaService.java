package com.petclinic.domain.service;

import com.petclinic.domain.dto.MascotaDTO;
import com.petclinic.domain.repository.MascotaRepository;
import com.petclinic.persistence.mapper.MascotaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private MascotaMapper mascotaMapper;

    // Consultar todos los registros
    public Iterable<MascotaDTO> findAll() {
        return mascotaRepository.findAll();
    }

    // Consultar por ID
    public Optional<MascotaDTO> findById(Long id) {
        return mascotaRepository.findById(id);
    }

    // Guardar un registro
    public MascotaDTO save(MascotaDTO mascotaDTO) {
        return mascotaRepository.save(mascotaDTO);
    }

    // Actualizar un registro
    public MascotaDTO update(MascotaDTO mascotaDTO) {
        return mascotaRepository.update(mascotaDTO);
    }

    // Eliminar un registro
    public void delete(Long id) {
        mascotaRepository.delete(id);
    }

    // Validar si existe por ID
    public boolean existsById(Long id) {
        return mascotaRepository.existsById(id);
    }

    // Contar todos los registros
    public long count() {
        return mascotaRepository.count();
    }
}
