package com.arquitectura.monolitico.services;

import com.arquitectura.monolitico.entities.ExtraHourEntity;
import com.arquitectura.monolitico.repositories.ExtraHourRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtraHourService {

  @Autowired
  ExtraHourRepository extraHourRepository;

  public ArrayList<ExtraHourEntity> getExtraHour() {
    return (ArrayList<ExtraHourEntity>) extraHourRepository.findAll();
  }

  public ExtraHourEntity saveExtraHour(ExtraHourEntity extraHour) {
    return extraHourRepository.save(extraHour);
  }

  public Optional<ExtraHourEntity> getById(Long id) {
    return extraHourRepository.findById(id);
  }

  public boolean deleteExtraHour(Long id) {
    try {
      extraHourRepository.deleteById(id);
      return true;
    } catch (Exception err) {
      return false;
    }
  }
}