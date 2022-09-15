package com.arquitectura.monolitico.controllers;

// import com.arquitectura.monolitico.entities.UserEntity;
import com.arquitectura.monolitico.services.UserService;
// import java.util.ArrayList;
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
    return "justificativos";
  }

  @GetMapping("/horasExtras")
  public String horasExtras(Model model) {
    return "horasExtras";
  }

  @GetMapping("/sueldos")
  public String sueldos(Model model) {
    return "sueldos";
  }
}
