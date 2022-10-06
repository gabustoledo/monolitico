package com.arquitectura.monolitico.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class FileTXT implements FileStrategy {

  @Override
  public List<HourlyInit> readFile(MultipartFile file) throws IOException {
    String content = new String(file.getBytes());
    String[] linesOld = content.split("\n");
    String[] lines = Arrays.copyOfRange(linesOld, 1, linesOld.length);

    List<HourlyInit> empleados = new ArrayList<HourlyInit>();

    for (String linea : lines) {
      String[] horario = linea.split(";");
      HourlyInit empl = new HourlyInit(
        horario[0].replaceAll("\\s", ""),
        horario[1].replaceAll("\\s", ""),
        horario[2].replaceAll("\\s", "")
      );

      empleados.add(empl);
    }

    return empleados;
  }
}
