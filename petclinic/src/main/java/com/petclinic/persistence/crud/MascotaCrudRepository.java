package com.petclinic.persistence.crud;

import com.petclinic.persistence.entity.Mascota;
import org.springframework.data.repository.CrudRepository;

public interface MascotaCrudRepository  extends
        CrudRepository<Mascota, Long> {
}

