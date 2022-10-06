package com.arquitectura.monolitico.entities.calculoFacade;

import com.arquitectura.monolitico.entities.ExtraHourEntity;
import com.arquitectura.monolitico.entities.Horario;
import com.arquitectura.monolitico.entities.SalaryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExtraHour {

    public static List<SalaryEntity> getExtraHour(List<SalaryEntity> salariosBasico, ArrayList<ExtraHourEntity> horasExtras, List<Horario> horarios){
        List<SalaryEntity> salarioExtraHour = new ArrayList<>();

        for (SalaryEntity salario : salariosBasico) {
            for (ExtraHourEntity horaExtra : horasExtras) {
                if (Objects.equals(salario.getRut(), horaExtra.getUser_rut())) {
                    for (Horario horario : horarios) {
                        if (
                                Objects.equals(horario.getFecha(), horaExtra.getFecha()) &&
                                        Objects.equals(salario.getRut(), horario.getRun())
                        ) {
                            int salida = Integer.parseInt(horario.getHora().split(":")[0]);
                            int horas = horaExtra.getCantidad();

                            if (salida >= 18 + horas) {
                                if (Objects.equals(salario.getArea(), "Administracion")) {
                                    if (Objects.equals(salario.getCategoria(), "A")) {
                                        salario.setBonoHorasExtras(35000 * horas);
                                    } else if (Objects.equals(salario.getCategoria(), "B")) {
                                        salario.setBonoHorasExtras(25000 * horas);
                                    } else if (Objects.equals(salario.getCategoria(), "C")) {
                                        salario.setBonoHorasExtras(15000 * horas);
                                    }
                                } else if (Objects.equals(salario.getArea(), "Operaciones")) {
                                    if (Objects.equals(salario.getCategoria(), "A")) {
                                        salario.setBonoHorasExtras(55000 * horas);
                                    } else if (Objects.equals(salario.getCategoria(), "B")) {
                                        salario.setBonoHorasExtras(40000 * horas);
                                    } else if (Objects.equals(salario.getCategoria(), "C")) {
                                        salario.setBonoHorasExtras(25000 * horas);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            salarioExtraHour.add(salario);
        }

        return salarioExtraHour;
    }
}
