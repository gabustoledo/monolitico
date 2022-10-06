package com.arquitectura.monolitico.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class FileJSON implements FileStrategy {

  @Override
  public List<HourlyInit> readFile(MultipartFile file) throws IOException {
    String content = new String(file.getBytes());
    String replace = content.replace("[", "");
    String replace1 = replace.replace("]", "");
    String replace2 = replace1.replace("{", "");
    String replace3 = replace2.replace("}", "");
    String replace4 = replace3.replace("\"fecha\":", "");
    String replace5 = replace4.replace("\"hora\":", "");
    String replace6 = replace5.replace("\"run\":", "");
    String replace7 = replace6.replace("\"", "");

    List<String> myList = new ArrayList<String>(
      Arrays.asList(replace7.split(","))
    );

    int cantidad = myList.size();
    List<HourlyInit> empleados = new ArrayList<HourlyInit>();

    for (int i = 0; i <= cantidad - 3; i += 3) {
      HourlyInit empl = new HourlyInit(
        myList.get(i).replaceAll("\\s", ""),
        myList.get(i + 1).replaceAll("\\s", ""),
        myList.get(i + 2).replaceAll("\\s", "")
      );

      empleados.add(empl);
    }

    return empleados;
  }
}
