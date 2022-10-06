package com.arquitectura.monolitico.entities.calculoFacade;

import com.arquitectura.monolitico.entities.SalaryEntity;

import java.util.ArrayList;
import java.util.List;

public class SueldoFinal {

    public static List<SalaryEntity> getSueldoFinal(List<SalaryEntity> salariosCalculoDescuentos){
        List<SalaryEntity> salariosFinal = new ArrayList<>();
        for (SalaryEntity salario : salariosCalculoDescuentos) {
            int bruto =
                    salario.getSueldoFijo() +
                            salario.getBonoHorasExtras() +
                            salario.getBonoTiempoServicio() +
                            salario.getBonoPuntualidad();

            bruto =
                    bruto - salario.getDescuentoIngreso() - salario.getDescuentoSalida();

            salario.setSueldoBruto(bruto);

            int ingreso = Integer.parseInt(salario.getFechaIngreso().split("-")[0]);
            if (ingreso < 1980) {
                salario.setPrevision((int) (bruto * 0.07));
                salario.setSalud((int) (bruto * 0.07));
            } else if (ingreso < 2000) {
                salario.setPrevision((int) (bruto * 0.09));
                salario.setSalud((int) (bruto * 0.08));
            } else {
                salario.setPrevision((int) (bruto * 0.1));
                salario.setSalud((int) (bruto * 0.08));
            }

            int sueldoFinal = bruto - salario.getPrevision() - salario.getSalud();
            salario.setSueldoFinal(sueldoFinal);

            salariosFinal.add(salario);
        }
        return salariosFinal;
    }
}
