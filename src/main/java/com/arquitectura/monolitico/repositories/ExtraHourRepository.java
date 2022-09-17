package com.arquitectura.monolitico.repositories;

import com.arquitectura.monolitico.entities.ExtraHourEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraHourRepository extends CrudRepository<ExtraHourEntity, Long> {}