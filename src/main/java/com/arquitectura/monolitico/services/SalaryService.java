package com.arquitectura.monolitico.services;

import com.arquitectura.monolitico.entities.SalaryEntity;
import com.arquitectura.monolitico.repositories.SalaryRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

  @Autowired
  SalaryRepository salaryRepository;

  public ArrayList<SalaryEntity> getSalary() {
    return (ArrayList<SalaryEntity>) salaryRepository.findAll();
  }

  public SalaryEntity saveSalary(SalaryEntity salary) {
    return salaryRepository.save(salary);
  }

  public Optional<SalaryEntity> getById(Long id) {
    return salaryRepository.findById(id);
  }

  public boolean deleteSalary(Long id) {
    try {
      salaryRepository.deleteById(id);
      return true;
    } catch (Exception err) {
      return false;
    }
  }

  public void deleteAll() {
    ArrayList<SalaryEntity> salarys = (ArrayList<SalaryEntity>) salaryRepository.findAll();

    for (SalaryEntity salary : salarys) {
      salaryRepository.deleteById(salary.getId());
    }
  }
}
