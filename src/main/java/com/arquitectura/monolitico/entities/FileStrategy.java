package com.arquitectura.monolitico.entities;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface FileStrategy {
  public List<HourlyInit> readFile(MultipartFile file) throws IOException;
}
