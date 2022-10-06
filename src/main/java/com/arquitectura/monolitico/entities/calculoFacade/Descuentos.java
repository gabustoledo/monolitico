package com.arquitectura.monolitico.entities.calculoFacade;

import com.arquitectura.monolitico.entities.Horario;
import com.arquitectura.monolitico.entities.JustificationEntity;
import com.arquitectura.monolitico.entities.SalaryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Descuentos {

    public static List<SalaryEntity> getDescuentos(List<SalaryEntity> salariosExtraHour,List<Horario> horarios,ArrayList<JustificationEntity> justificativos){

        List<SalaryEntity> salariosDescuentos = new ArrayList<>();

        for (SalaryEntity salario : salariosExtraHour) {
            salario.setDiasTrabajados(0);
            salario.setIngresoPuntual(0);
            salario.setSalidaPuntual(0);
            salario.setPorcentajeIngreso(0);
            salario.setPorcentajeSalida(0);
            for (Horario horario : horarios) {
                if (Objects.equals(salario.getRut(), horario.getRun())) {
                    salario.setDiasTrabajados(salario.getDiasTrabajados() + 1);
                    int hora =
                            Integer.parseInt(horario.getHora().split(":")[0]) *
                                    60 +
                                    Integer.parseInt(horario.getHora().split(":")[1]);

                    if (hora < 720) {
                        if (hora <= 480) {
                            salario.setIngresoPuntual(salario.getIngresoPuntual() + 1);
                        } else if (hora > 490 && hora <= 505) {
                            salario.setPorcentajeIngreso(salario.getPorcentajeIngreso() + 1);
                        } else if (hora > 505 && hora <= 525) {
                            salario.setPorcentajeIngreso(salario.getPorcentajeIngreso() + 3);
                        } else if (hora > 525 && hora <= 550) {
                            salario.setPorcentajeIngreso(salario.getPorcentajeIngreso() + 6);
                        } else if (hora > 550) {
                            boolean flagIngreso = false;
                            for (JustificationEntity justificativo : justificativos) {
                                if (
                                        Objects.equals(
                                                justificativo.getUser_rut(),
                                                salario.getRut()
                                        ) &&
                                                Objects.equals(justificativo.getFecha(), horario.getFecha())
                                ) {
                                    flagIngreso = true;
                                }
                            }
                            if (!flagIngreso) {
                                salario.setPorcentajeIngreso(
                                        salario.getPorcentajeIngreso() + 15
                                );
                            }
                        }
                    } else {
                        if (hora >= 1080) {
                            salario.setSalidaPuntual(salario.getSalidaPuntual() + 1);
                        } else if (hora >= 1065) {
                            salario.setPorcentajeSalida(salario.getPorcentajeSalida() + 2);
                        } else if (hora >= 1050) {
                            salario.setPorcentajeSalida(salario.getPorcentajeSalida() + 4);
                        } else if (hora >= 1035) {
                            salario.setPorcentajeSalida(salario.getPorcentajeSalida() + 7);
                        } else {
                            boolean flagSalida = false;
                            for (JustificationEntity justificativo : justificativos) {
                                if (
                                        Objects.equals(
                                                justificativo.getUser_rut(),
                                                salario.getRut()
                                        ) &&
                                                Objects.equals(justificativo.getFecha(), horario.getFecha())
                                ) {
                                    flagSalida = true;
                                }
                            }
                            if (!flagSalida) {
                                salario.setPorcentajeIngreso(
                                        salario.getPorcentajeSalida() + 15
                                );
                            }
                        }
                    }
                }
            }
            salario.setDiasTrabajados(salario.getDiasTrabajados() / 2);
            salariosDescuentos.add(salario);
        }
        return salariosDescuentos;
    }
}
