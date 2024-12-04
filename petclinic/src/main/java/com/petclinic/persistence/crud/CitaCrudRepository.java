package com.petclinic.persistence.crud;

import com.petclinic.persistence.entity.Cita;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitaCrudRepository extends
        CrudRepository<Cita, Integer> {
    List<Cita> findByVeterinarioIdAndFechaHoraBetween(Integer veterinarioId, String startDate, String endDate);

    // Método para encontrar todas las citas por mascotaId
    List<Cita> findByMascotaId(Integer mascotaId);
}
