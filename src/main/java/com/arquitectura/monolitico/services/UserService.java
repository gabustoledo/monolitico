package com.arquitectura.monolitico.services;

import com.arquitectura.monolitico.entities.UserEntity;
import com.arquitectura.monolitico.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository usuarioRepository;

  public ArrayList<UserEntity> getUsers() {
    return (ArrayList<UserEntity>) usuarioRepository.findAll();
  }

  public UserEntity saveUser(UserEntity usuario) {
    return usuarioRepository.save(usuario);
  }

  public Optional<UserEntity> getById(Long id) {
    return usuarioRepository.findById(id);
  }

  public boolean deleteUser(Long id) {
    try {
      usuarioRepository.deleteById(id);
      return true;
    } catch (Exception err) {
      return false;
    }
  }
}
