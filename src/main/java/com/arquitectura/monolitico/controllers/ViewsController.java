package com.arquitectura.monolitico.controllers;

import com.arquitectura.monolitico.entities.ExtraHourEntity;
import com.arquitectura.monolitico.entities.SalaryEntity;
import com.arquitectura.monolitico.entities.UserEntity;
import com.arquitectura.monolitico.services.SalaryService;
import com.arquitectura.monolitico.services.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ViewsController {

  @Autowired
  UserService userService;

  @Autowired
  SalaryService salaryService;

  @GetMapping("/")
  public String home(Model model) {
    return "home";
  }

  @GetMapping("/test")
  public String test(Model model) {
    return "test";
  }

  @GetMapping("/horarios")
  public String horarios(Model model) {
    return "horarios";
  }

  @GetMapping("/justificativos")
  public String justificativos(Model model) {
    ArrayList<UserEntity> usuarios = userService.getUsers();
    model.addAttribute("usuarios", usuarios);
    return "justificativos";
  }

  @GetMapping("/horasExtras")
  public String horasExtras(Model model) {
    ArrayList<UserEntity> usuarios = userService.getUsers();
    model.addAttribute("usuarios", usuarios);
    model.addAttribute("extraHourEntity", new ExtraHourEntity());
    return "horasExtras";
  }

  @GetMapping("/sueldos")
  public String sueldos(Model model) {
    ArrayList<SalaryEntity> salarios = salaryService.getSalary();
    model.addAttribute("salarios", salarios);
    return "sueldos";
  }
}
