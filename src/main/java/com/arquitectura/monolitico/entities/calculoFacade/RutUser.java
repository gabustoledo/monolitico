package com.arquitectura.monolitico.entities.calculoFacade;

import com.arquitectura.monolitico.entities.Horario;
import com.arquitectura.monolitico.entities.SalaryEntity;

import java.util.ArrayList;
import java.util.List;

public class RutUser {

    public static List<SalaryEntity> getRut(List<Horario> horarios){
        List<SalaryEntity> salariosRut = new ArrayList<>();
        List<String> rutIngresados = new ArrayList<>();

        for (int i = 0; i < horarios.size(); i++) {
            SalaryEntity salario = new SalaryEntity();
            if (!rutIngresados.contains(horarios.get(i).getRun())) {
                rutIngresados.add(horarios.get(i).getRun());
                salario.setRut(horarios.get(i).getRun());
                salariosRut.add(salario);
            }
        }
        return salariosRut;
    }
}
