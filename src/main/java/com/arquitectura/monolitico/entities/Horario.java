package com.arquitectura.monolitico.entities;

public abstract class Horario {

    public abstract String getFecha();
    public abstract String getHora();
    public abstract String getRun();
    public abstract void setFecha(String fecha);
    public abstract void setHora(String hora);
    public abstract void setRun(String run);
}
