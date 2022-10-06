package com.arquitectura.monolitico.entities;

public class HourlyInit extends Horario{

  private String fecha;
  private String hora;
  private String run;

  public HourlyInit(){}

  public HourlyInit(String fecha, String hora, String run) {
    this.fecha = fecha;
    this.hora = hora;
    this.run = run;
  }

  public String getFecha() {
    return fecha;
  }

  public String getHora() {
    return hora;
  }

  public String getRun() {
    return run;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public void setRun(String run) {
    this.run = run;
  }
}
