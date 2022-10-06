package com.arquitectura.monolitico.entities;

public class Factory extends HorarioFactory{

    public Horario createHorario(String type){
        if (type.equals("HourlyInit")){
            return new HourlyInit();
        }
        return null;
    }
}
