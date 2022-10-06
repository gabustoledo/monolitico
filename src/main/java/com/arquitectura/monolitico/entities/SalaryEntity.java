package com.arquitectura.monolitico.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  private String rut;
  private String nombre;
  private String apellido;
  private String categoria;
  private int tiempoServicio;
  private String area;
  private int sueldoFijo;
  private int bonoHorasExtras;
  private int bonoTiempoServicio;
  private int bonoPuntualidad;
  private int descuentoIngreso;
  private int descuentoSalida;
  private int sueldoBruto;
  private int prevision;
  private int salud;
  private int sueldoFinal;
  private String fechaIngreso;
  private int diasTrabajados;
  private int ingresoPuntual;
  private int salidaPuntual;
  private int porcentajeIngreso;
  private int porcentajeSalida;
}
