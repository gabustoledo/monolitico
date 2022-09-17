package com.arquitectura.monolitico.controllers;

import com.arquitectura.monolitico.entities.JustificationEntity;
import com.arquitectura.monolitico.services.JustificationService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/justification")
public class JustificationController {

  @Autowired
  JustificationService justificationService;

  @GetMapping("/get")
  @ResponseBody
  public ArrayList<JustificationEntity> getJustification() {
    return justificationService.getJustification();
  }

  @PostMapping(path = "/create")
  public String createJustification(
    @RequestParam("user_rut") String user_rut,
    @RequestParam("fecha") String fecha
  ) {
    JustificationEntity justification = new JustificationEntity();

    justification.setUser_rut(user_rut);
    justification.setFecha(fecha);

    justificationService.saveJustification(justification);
    return "redirect:http://localhost:8080/justificativos";
  }
}
