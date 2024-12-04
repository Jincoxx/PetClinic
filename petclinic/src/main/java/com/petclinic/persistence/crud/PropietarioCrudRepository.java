package com.petclinic.persistence.crud;

import com.petclinic.persistence.entity.Propietario;
import org.springframework.data.repository.CrudRepository;

public interface PropietarioCrudRepository extends
        CrudRepository<Propietario, Long> {
}
