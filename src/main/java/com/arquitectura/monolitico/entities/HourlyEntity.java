package com.arquitectura.monolitico.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hourly")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HourlyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  private String user_rut;

  private String fecha;
  private String ingreso;
  private String salida;
  private int descuentoIngreso;
  private int descuentoSalida;
  private Boolean inasistencia;
}
