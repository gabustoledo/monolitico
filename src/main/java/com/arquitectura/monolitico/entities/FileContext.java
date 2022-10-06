package com.arquitectura.monolitico.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileContext {

  private FileStrategy strategy;

  public void setFileType(FileStrategy strategy) {
    this.strategy = strategy;
  }

  public FileStrategy getStrategy() {
    return this.strategy;
  }

  public List<HourlyInit> readFile(MultipartFile file) throws IOException {
    return this.strategy.readFile(file);
  }
}
