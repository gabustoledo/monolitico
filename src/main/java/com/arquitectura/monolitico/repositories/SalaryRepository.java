package com.arquitectura.monolitico.repositories;

import com.arquitectura.monolitico.entities.SalaryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends CrudRepository<SalaryEntity, Long> {}
