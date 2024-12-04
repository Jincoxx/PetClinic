package com.petclinic.persistence.repositoryImpl;

import com.petclinic.domain.dto.PropietarioDTO;
import com.petclinic.domain.repository.PropietarioRepository;
import com.petclinic.persistence.crud.PropietarioCrudRepository;
import com.petclinic.persistence.entity.Propietario;
import com.petclinic.persistence.mapper.PropietarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PropietarioRepositoryImpl implements PropietarioRepository {

    @Autowired
    private PropietarioCrudRepository propietarioCrudRepository;

    @Autowired
    private PropietarioMapper propietarioMapper;

    // Consultar todos los registros
    @Override
    public Iterable<PropietarioDTO> findAll() {
        Iterable<Propietario> propietarios = propietarioCrudRepository.findAll();
        //return propietarioMapper.toDto(propietarios);
        return ((List<Propietario>) propietarios).stream()
                .map(propietarioMapper::toDto)  // Mapea cada Mascota a MascotaDTO
                .collect(Collectors.toList());
    }

    // Consultar por ID
    @Override
    public Optional<PropietarioDTO> findById(Long id) {
        Optional<Propietario> propietario = propietarioCrudRepository.findById(id);
        return propietario.map(propietarioMapper::toDto);
    }

    // Guardar
    @Override
    public PropietarioDTO save(PropietarioDTO propietarioDTO) {
        Propietario propietario = propietarioMapper.toEntity(propietarioDTO);
        if (!existsById(propietario.getId())) {
            Propietario savedPropietario = propietarioCrudRepository.save(propietario);
            return propietarioMapper.toDto(savedPropietario);
        }
        throw new IllegalArgumentException("El registro ya existe");
    }

    // Actualizar
    @Override
    public PropietarioDTO update(PropietarioDTO propietarioDTO) {
        Propietario propietario = propietarioMapper.toEntity(propietarioDTO);
        if (existsById(propietario.getId())) {
            Propietario updatedPropietario = propietarioCrudRepository.save(propietario);
            return propietarioMapper.toDto(updatedPropietario);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    // Eliminar
    @Override
    public void delete(Long id) {
        if (existsById(id)) {
            propietarioCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    // Validar si existe por ID
    @Override
    public boolean existsById(Long id) {
        return propietarioCrudRepository.existsById(id);
    }

    // Contar todos los registros
    @Override
    public long count() {
        return propietarioCrudRepository.count();
    }
}
