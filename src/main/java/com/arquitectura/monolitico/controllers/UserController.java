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
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/")
  public String home(Model model) {
    // ArrayList<UserEntity> usuarios = userService.getUsers();
    // model.addAttribute("usuarios", usuarios);
    return "index";
  }

	@GetMapping("/test")
  public String test(Model model) {
    // ArrayList<UserEntity> usuarios = userService.getUsers();
    // model.addAttribute("usuarios", usuarios);
    return "test";
  }
}
