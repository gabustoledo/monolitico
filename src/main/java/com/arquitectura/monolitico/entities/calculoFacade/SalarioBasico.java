package com.arquitectura.monolitico.entities.calculoFacade;

import com.arquitectura.monolitico.entities.SalaryEntity;
import com.arquitectura.monolitico.entities.UserEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SalarioBasico {

    public static List<SalaryEntity> getSalarioBasico(List<SalaryEntity> salariosRut, ArrayList<UserEntity> usuarios) throws ParseException {

        List<SalaryEntity> salarioBasico = new ArrayList<>();

        for (SalaryEntity salario : salariosRut) {
            for (UserEntity usuario : usuarios) {
                if (Objects.equals(salario.getRut(), usuario.getRut())) {
                    salario.setCategoria(usuario.getCategoria());
                    salario.setArea(usuario.getArea());
                    salario.setNombre(usuario.getNombres());
                    salario.setApellido(usuario.getApellidos());
                    salario.setFechaIngreso(usuario.getFechaIngreso());
                    if (Objects.equals(usuario.getArea(), "Administracion")) {
                        if (Objects.equals(usuario.getCategoria(), "A")) {
                            salario.setSueldoFijo(1700000);
                        } else if (Objects.equals(usuario.getCategoria(), "B")) {
                            salario.setSueldoFijo(1200000);
                        } else if (Objects.equals(usuario.getCategoria(), "C")) {
                            salario.setSueldoFijo(800000);
                        }
                    } else if (Objects.equals(usuario.getArea(), "Operaciones")) {
                        if (Objects.equals(usuario.getCategoria(), "A")) {
                            salario.setSueldoFijo(2300000);
                        } else if (Objects.equals(usuario.getCategoria(), "B")) {
                            salario.setSueldoFijo(1600000);
                        } else if (Objects.equals(usuario.getCategoria(), "C")) {
                            salario.setSueldoFijo(900000);
                        }
                    }

                    Date fechaIngreso = new SimpleDateFormat("yyyy-MM-dd")
                            .parse(usuario.getFechaIngreso());
                    Date hoy = new Date();
                    long elapsedms = hoy.getTime() - fechaIngreso.getTime();
                    long diff = TimeUnit.MINUTES.convert(
                            elapsedms,
                            TimeUnit.MILLISECONDS
                    );

                    int tiempoServicio = (int) (diff / 525600);

                    salario.setTiempoServicio(tiempoServicio);

                    int bonoTiempoServicio = 0;

                    if (tiempoServicio < 5) { // 0
                        salario.setBonoTiempoServicio(0);
                    } else if (tiempoServicio < 10) { // 5
                        bonoTiempoServicio = (int) (salario.getSueldoFijo() * 0.05);
                        salario.setBonoTiempoServicio(bonoTiempoServicio);
                    } else if (tiempoServicio < 15) { // 8
                        bonoTiempoServicio = (int) (salario.getSueldoFijo() * 0.08);
                        salario.setBonoTiempoServicio(bonoTiempoServicio);
                    } else if (tiempoServicio < 20) { // 11
                        bonoTiempoServicio = (int) (salario.getSueldoFijo() * 0.11);
                        salario.setBonoTiempoServicio(bonoTiempoServicio);
                    } else if (tiempoServicio < 25) { // 14
                        bonoTiempoServicio = (int) (salario.getSueldoFijo() * 0.14);
                        salario.setBonoTiempoServicio(bonoTiempoServicio);
                    } else { // 17
                        bonoTiempoServicio = (int) (salario.getSueldoFijo() * 0.17);
                        salario.setBonoTiempoServicio(bonoTiempoServicio);
                    }

                    salarioBasico.add(salario);
                }
            }
        }
        return salarioBasico;
    }
}
