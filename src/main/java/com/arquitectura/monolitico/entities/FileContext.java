package com.arquitectura.monolitico.entities;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class FileContext {

  private FileStrategy strategy;

  public void setFileType(FileStrategy strategy) {
    this.strategy = strategy;
  }

  public FileStrategy getStrategy() {
    return this.strategy;
  }

  public List<Horario> readFile(MultipartFile file) throws IOException {
    return this.strategy.readFile(file);
  }
}
