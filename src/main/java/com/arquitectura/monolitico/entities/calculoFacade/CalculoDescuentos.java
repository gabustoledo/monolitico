package com.arquitectura.monolitico.entities.calculoFacade;

import com.arquitectura.monolitico.entities.SalaryEntity;

import java.util.ArrayList;
import java.util.List;

public class CalculoDescuentos {

    public static List<SalaryEntity> getCalculoDescuentos(List<SalaryEntity> salariosDescuentos){

        List<SalaryEntity> salariosCalculoDescuentos = new ArrayList<>();

        for (SalaryEntity salario : salariosDescuentos) {
            float porcentajeIngreso = (float) salario.getPorcentajeIngreso() / 100;
            float porcentajeSalida = (float) salario.getPorcentajeSalida() / 100;

            int descuentoIngreso = (int) (
                    salario.getSueldoFijo() * porcentajeIngreso
            );
            int descuentoSalida = (int) (salario.getSueldoFijo() * porcentajeSalida);
            salario.setDescuentoIngreso(descuentoIngreso);
            salario.setDescuentoSalida(descuentoSalida);

            float ingresoPuntual = (float) salario.getIngresoPuntual() /
                    salario.getDiasTrabajados();
            float salidaPuntual = (float) salario.getSalidaPuntual() /
                    salario.getDiasTrabajados();

            if (ingresoPuntual > 0.9) {
                salario.setBonoPuntualidad((int) (salario.getSueldoFijo() * 0.08));
            } else if (ingresoPuntual > 0.8) {
                salario.setBonoPuntualidad((int) (salario.getSueldoFijo() * 0.05));
            }

            if (salidaPuntual > 0.9) {
                salario.setBonoPuntualidad((int) (salario.getSueldoFijo() * 0.08));
            } else if (salidaPuntual > 0.8) {
                salario.setBonoPuntualidad((int) (salario.getSueldoFijo() * 0.05));
            }

            salariosCalculoDescuentos.add(salario);
        }

        return salariosCalculoDescuentos;
    }
}
