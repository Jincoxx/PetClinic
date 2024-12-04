package com.petclinic.persistence.repositoryImpl;

import com.petclinic.domain.dto.VeterinarioDTO;
import com.petclinic.domain.repository.VeterinarioRepository;
import com.petclinic.persistence.crud.VeterinarioCrudRepository;
import com.petclinic.persistence.entity.Veterinario;
import com.petclinic.persistence.mapper.VeterinarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public abstract class VeterinarioRepositoryImpl implements VeterinarioRepository {

    @Autowired
    private VeterinarioCrudRepository veterinarioCrudRepository;

    @Autowired
    private VeterinarioMapper veterinarioMapper;

    // Consultar todos los registros
    @Override
    public Iterable<VeterinarioDTO> findAll() {
        Iterable<Veterinario> veterinarios = veterinarioCrudRepository.findAll();
        return ((List<Veterinario>) veterinarios).stream()
                .map(veterinarioMapper::toDto)
                .collect(Collectors.toList());
    }

    // Consultar por ID
    @Override
    public Optional<VeterinarioDTO> findById(Integer id) {
        Optional<Veterinario> veterinario = veterinarioCrudRepository.findById(id);
        return veterinario.map(veterinarioMapper::toDto);
    }

    // Guardar
    @Override
    public VeterinarioDTO save(VeterinarioDTO veterinarioDTO) {
        Veterinario veterinario = veterinarioMapper.toEntity(veterinarioDTO);
        if (!existsById(veterinario.getId())) {
            Veterinario savedVeterinario = veterinarioCrudRepository.save(veterinario);
            return veterinarioMapper.toDto(savedVeterinario);
        }
        throw new IllegalArgumentException("El registro ya existe");
    }

    // Actualizar
    @Override
    public VeterinarioDTO update(VeterinarioDTO veterinarioDTO) {
        Veterinario veterinario = veterinarioMapper.toEntity(veterinarioDTO);
        if (existsById(veterinario.getId())) {
            Veterinario updatedVeterinario = veterinarioCrudRepository.save(veterinario);
            return veterinarioMapper.toDto(updatedVeterinario);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    // Eliminar
    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            veterinarioCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    // Validar si existe por ID
    @Override
    public boolean existsById(Integer id) {
        return veterinarioCrudRepository.existsById(id);
    }


    //Buscar por especialidad
    //@Override
    //public Iterable<VeterinarioDTO> findByEspecialidad(String especialidad) {
    //    return veterinarios.stream()
    //            .filter(v -> v.getEspecialidad().equalsIgnoreCase(especialidad))
    //            .collect(Collectors.toList());
    //}

    // Contar todos los registros
    @Override
    public long count() {
        return veterinarioCrudRepository.count();
    }
}
