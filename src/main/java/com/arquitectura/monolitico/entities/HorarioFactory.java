package com.arquitectura.monolitico.entities;

public abstract class HorarioFactory {

    public HorarioFactory(){}

    protected abstract Horario createHorario(String type);
}
