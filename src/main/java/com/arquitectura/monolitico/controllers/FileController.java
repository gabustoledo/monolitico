package com.arquitectura.monolitico.controllers;

import com.arquitectura.monolitico.entities.*;
import com.arquitectura.monolitico.services.ExtraHourService;
import com.arquitectura.monolitico.services.JustificationService;
import com.arquitectura.monolitico.services.SalaryService;
import com.arquitectura.monolitico.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/file")
public class FileController {

  @Autowired
  FileContext context = new FileContext();

  @Autowired
  UserService userService;

  @Autowired
  ExtraHourService extraHourService;

  @Autowired
  JustificationService justificationService;

  @Autowired
  SalaryService salaryService;

  @PostMapping(path = "/read")
  public String showFile(
    @RequestParam("fileJSON") MultipartFile fileJSON,
    @RequestParam("fileTXT") MultipartFile fileTXT
  )
    throws IOException, ParseException {
    salaryService.deleteAll();

    context.setFileType(new FileJSON());
    List<Horario> horariosJSON = context.readFile(fileJSON);

    context.setFileType(new FileTXT());
    List<Horario> horariosTXT = context.readFile(fileTXT);

    ArrayList<UserEntity> usuarios = userService.getUsers();
    ArrayList<JustificationEntity> justificativos = justificationService.getJustification();
    ArrayList<ExtraHourEntity> horasExtras = extraHourService.getExtraHour();

    CalculoSueldo calculo = new CalculoSueldo();

    List<SalaryEntity> sueldosTXT = calculo.salario(
            horariosTXT,
      usuarios,
      justificativos,
      horasExtras
    );
    List<SalaryEntity> sueldosJSON = calculo.salario(
            horariosJSON,
      usuarios,
      justificativos,
      horasExtras
    );

    for (SalaryEntity sueldo : sueldosTXT) {
      salaryService.saveSalary(sueldo);
    }
    for (SalaryEntity sueldo : sueldosJSON) {
      salaryService.saveSalary(sueldo);
    }

    return "redirect:http://localhost:8080/sueldos";
  }
}
