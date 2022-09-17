package com.arquitectura.monolitico.repositories;

import com.arquitectura.monolitico.entities.JustificationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustificationRepository extends CrudRepository<JustificationEntity, Long> {}