package com.arquitectura.monolitico.entities;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileTXT implements FileStrategy {

  @Override
  public List<Horario> readFile(MultipartFile file) throws IOException {
    String content = new String(file.getBytes());
    String[] linesOld = content.split("\n");
    String[] lines = Arrays.copyOfRange(linesOld, 1, linesOld.length);

    List<Horario> empleados = new ArrayList<Horario>();

    for (String linea : lines) {
      String[] horario = linea.split(";");

      Factory factory = new Factory();

      Horario empl = factory.createHorario("HourlyInit");

      empl.setFecha(horario[0].replaceAll("\\s", ""));
      empl.setHora(horario[1].replaceAll("\\s", ""));
      empl.setRun(horario[2].replaceAll("\\s", ""));

      empleados.add(empl);
    }

    return empleados;
  }
}
