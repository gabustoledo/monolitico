package com.arquitectura.monolitico.entities;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileStrategy {
  public List<Horario> readFile(MultipartFile file) throws IOException;
}
