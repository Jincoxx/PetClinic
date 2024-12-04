package com.petclinic.domain.service;

import com.petclinic.domain.dto.PropietarioDTO;
import com.petclinic.domain.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    // Consultar todos los registros
    public Iterable<PropietarioDTO> findAll() {
        return propietarioRepository.findAll();
    }

    // Consultar por ID
    public PropietarioDTO findById(Long id) {
        return propietarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Propietario no encontrado"));
    }

    // Guardar
    public PropietarioDTO save(PropietarioDTO propietarioDTO) {
        return propietarioRepository.save(propietarioDTO);
    }

    // Actualizar
    public PropietarioDTO update(PropietarioDTO propietarioDTO) {
        return propietarioRepository.update(propietarioDTO);
    }

    // Eliminar
    public void delete(Long id) {
        propietarioRepository.delete(id);
    }

    // Validar si existe por ID
    public boolean existsById(Long id) {
        return propietarioRepository.existsById(id);
    }

    // Contar todos los registros
    public long count() {
        return propietarioRepository.count();
    }
}
