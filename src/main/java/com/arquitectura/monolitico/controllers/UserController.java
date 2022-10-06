package com.arquitectura.monolitico.controllers;

import com.arquitectura.monolitico.entities.UserEntity;
import com.arquitectura.monolitico.services.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/get")
  @ResponseBody
  public ArrayList<UserEntity> getUser() {
    return userService.getUsers();
  }

  @PostMapping("/create")
  @ResponseBody
  public UserEntity createUser(@RequestBody UserEntity user) {
    return userService.saveUser(user);
  }
}
