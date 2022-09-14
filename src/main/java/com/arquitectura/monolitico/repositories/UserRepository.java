package com.arquitectura.monolitico.repositories;

import com.arquitectura.monolitico.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {}
