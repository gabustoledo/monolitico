package com.arquitectura.monolitico.controllers;

import com.arquitectura.monolitico.entities.ExtraHourEntity;
import com.arquitectura.monolitico.services.ExtraHourService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/extraHour")
public class ExtraHourController {

  @Autowired
  ExtraHourService extraHourService;

  @GetMapping("/get")
  @ResponseBody
  public ArrayList<ExtraHourEntity> getExtraHour() {
    return extraHourService.getExtraHour();
  }

  @PostMapping(path = "/create")
  public String createExtraHour(
    @RequestParam("user_rut") String user_rut,
    @RequestParam("cantidad") int cantidad,
    @RequestParam("fecha") String fecha
  ) {
    ExtraHourEntity extraHour = new ExtraHourEntity();
    extraHour.setUser_rut(user_rut);
    extraHour.setCantidad(cantidad);
    extraHour.setFecha(fecha);
    extraHourService.saveExtraHour(extraHour);
    return "redirect:http://localhost:8080/horasExtras";
  }
}
