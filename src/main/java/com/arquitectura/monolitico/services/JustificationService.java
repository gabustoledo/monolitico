package com.arquitectura.monolitico.services;

import com.arquitectura.monolitico.entities.JustificationEntity;
import com.arquitectura.monolitico.repositories.JustificationRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JustificationService {

  @Autowired
  JustificationRepository justificationRepository;

  public ArrayList<JustificationEntity> getJustification() {
    return (ArrayList<JustificationEntity>) justificationRepository.findAll();
  }

  public JustificationEntity saveJustification(
    JustificationEntity justification
  ) {
    return justificationRepository.save(justification);
  }

  public Optional<JustificationEntity> getById(Long id) {
    return justificationRepository.findById(id);
  }

  public boolean deleteExtraHour(Long id) {
    try {
      justificationRepository.deleteById(id);
      return true;
    } catch (Exception err) {
      return false;
    }
  }
}
