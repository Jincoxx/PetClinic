package com.petclinic.persistence.crud;

import com.petclinic.persistence.entity.Veterinario;
import org.springframework.data.repository.CrudRepository;

public interface VeterinarioCrudRepository extends
        CrudRepository<Veterinario, Integer> {
}
