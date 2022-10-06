package com.arquitectura.monolitico.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CalculoSueldo {

  public List<SalaryEntity> salario(
    List<HourlyInit> horarios,
    ArrayList<UserEntity> usuarios,
    ArrayList<JustificationEntity> justificativos,
    ArrayList<ExtraHourEntity> horasExtras
  )
    throws ParseException {
    List<SalaryEntity> salariosRut = new ArrayList<>();

    // Obtengo los rut de los trabajadores
    List<String> rutIngresados = new ArrayList<>();
    for (int i = 0; i < horarios.size(); i++) {
      SalaryEntity salario = new SalaryEntity();
      if (!rutIngresados.contains(horarios.get(i).getRun())) {
        rutIngresados.add(horarios.get(i).getRun());
        salario.setRut(horarios.get(i).getRun());
        salariosRut.add(salario);
      }
    }

    List<SalaryEntity> salarios2 = new ArrayList<>();
    // Obtener sueldo fijo segun categoria y area, detectar tiempo de servicio, sueldo fijo y bono por tiempo
    for (SalaryEntity salario : salariosRut) {
      for (UserEntity usuario : usuarios) {
        if (Objects.equals(salario.getRut(), usuario.getRut())) {
          salario.setCategoria(usuario.getCategoria());
          salario.setArea(usuario.getArea());
          salario.setNombre(usuario.getNombres());
          salario.setApellido(usuario.getApellidos());
          salario.setFechaIngreso(usuario.getFechaIngreso());
          //                    salarios2.add(salario);
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

          salarios2.add(salario);
        }
      }
    }

    List<SalaryEntity> salarios3 = new ArrayList<>();
    for (SalaryEntity salario : salarios2) {
      for (ExtraHourEntity horaExtra : horasExtras) {
        if (Objects.equals(salario.getRut(), horaExtra.getUser_rut())) { // busco usuarios que tengan he asignada
          for (HourlyInit horario : horarios) {
            if (
              Objects.equals(horario.getFecha(), horaExtra.getFecha()) &&
              Objects.equals(salario.getRut(), horario.getRun())
            ) { // busco el dia asignado
              // compruebo si realizo la he

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
      salarios3.add(salario);
    }

    List<SalaryEntity> salarios4 = new ArrayList<>();
    for (SalaryEntity salario : salarios3) {
      salario.setDiasTrabajados(0);
      salario.setIngresoPuntual(0);
      salario.setSalidaPuntual(0);
      salario.setPorcentajeIngreso(0);
      salario.setPorcentajeSalida(0);
      for (HourlyInit horario : horarios) {
        if (Objects.equals(salario.getRut(), horario.getRun())) {
          salario.setDiasTrabajados(salario.getDiasTrabajados() + 1);
          int hora =
            Integer.parseInt(horario.getHora().split(":")[0]) *
            60 +
            Integer.parseInt(horario.getHora().split(":")[1]);

          if (hora < 720) { // entrada
            if (hora <= 480) { // entro a las 8 o antes
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
          } else { // salida
            if (hora >= 1080) { // salida a las 18 o despues
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
      salarios4.add(salario);
    }

    List<SalaryEntity> salarios5 = new ArrayList<>();
    for (SalaryEntity salario : salarios4) {
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

      salarios5.add(salario);
    }

    List<SalaryEntity> salarios6 = new ArrayList<>();
    for (SalaryEntity salario : salarios5) {
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

      salarios6.add(salario);
    }

    return salarios6;
  }
}
