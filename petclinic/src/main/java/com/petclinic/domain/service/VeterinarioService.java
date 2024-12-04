package com.petclinic.domain.service;

import com.petclinic.domain.dto.VeterinarioDTO;
import com.petclinic.domain.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    // Consultar todos los registros
    public Iterable<VeterinarioDTO> findAll() {
        return veterinarioRepository.findAll();
    }

    // Consultar por ID, devolviendo un Optional
    public Optional<VeterinarioDTO> findById(Integer id) {
        return veterinarioRepository.findById(id); // Devuelve Optional
    }

    // Guardar un registro
    public VeterinarioDTO save(VeterinarioDTO veterinarioDTO) {
        return veterinarioRepository.save(veterinarioDTO);
    }

    // Actualizar un registro
    public VeterinarioDTO update(VeterinarioDTO veterinarioDTO) {
        return veterinarioRepository.update(veterinarioDTO);
    }

    // Eliminar un registro
    public void delete(Integer id) {
        veterinarioRepository.delete(id);
    }

    // Validar si existe por ID
    public boolean existsById(Integer id) {
        return veterinarioRepository.existsById(id);
    }

    // Contar todos los registros
    public long count() {
        return veterinarioRepository.count();
    }

    // Buscar veterinarios por especialidad
    public Iterable<VeterinarioDTO> findByEspecialidad(String especialidad) {
        return veterinarioRepository.findByEspecialidad(especialidad);
    }
}
