package com.petclinic.persistence.repositoryImpl;

import com.petclinic.domain.dto.MascotaDTO;
import com.petclinic.domain.repository.MascotaRepository;
import com.petclinic.persistence.crud.MascotaCrudRepository;
import com.petclinic.persistence.entity.Mascota;
import com.petclinic.persistence.mapper.MascotaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MascotaRepositoryImpl implements MascotaRepository {

    @Autowired
    private MascotaCrudRepository mascotaCrudRepository;

    @Autowired
    private MascotaMapper mascotaMapper;  // Mapper que convierte entre entidad y DTO

    // Consultar todos los registros
    @Override
    public Iterable<MascotaDTO> findAll() {
        Iterable<Mascota> mascotas = mascotaCrudRepository.findAll();
        // Mapeo explícito de cada entidad a DTO
        return ((List<Mascota>) mascotas).stream()
                .map(mascotaMapper::toDto)  // Mapea cada Mascota a MascotaDTO
                .collect(Collectors.toList());
    }

    // Consultar por ID
    @Override
    public Optional<MascotaDTO> findById(Long id) {
        Optional<Mascota> mascota = mascotaCrudRepository.findById(id);
        return mascota.map(mascotaMapper::toDto);
    }

    // Guardar
    @Override
    public MascotaDTO save(MascotaDTO mascotaDTO) {
        Mascota mascota = mascotaMapper.toEntity(mascotaDTO);
        if (!existsById(mascota.getId())) {
            Mascota savedMascota = mascotaCrudRepository.save(mascota);
            return mascotaMapper.toDto(savedMascota);
        }
        throw new IllegalArgumentException("El registro ya existe");
    }

    // Actualizar
    @Override
    public MascotaDTO update(MascotaDTO mascotaDTO) {
        Mascota mascota = mascotaMapper.toEntity(mascotaDTO);
        if (existsById(mascota.getId())) {
            Mascota updatedMascota = mascotaCrudRepository.save(mascota);
            return mascotaMapper.toDto(updatedMascota);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    // Eliminar
    @Override
    public void delete(Long id) {
        if (existsById(id)) {
            mascotaCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    // Validar si existe por ID
    @Override
    public boolean existsById(Long id) {
        return mascotaCrudRepository.existsById(id);
    }

    // Contar todos los registros
    @Override
    public long count() {
        return mascotaCrudRepository.count();
    }
}
