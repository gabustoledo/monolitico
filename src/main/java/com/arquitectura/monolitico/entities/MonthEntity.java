package com.arquitectura.monolitico.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "month")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user.rut")
  private UserEntity user;

  private String mes;
  private int year;
  private int dias; // Cantidad de dias laborales
  private int ingresoPuntual; // Cantidad de dias que ingreso puntualmente o menos de 10 minutos tarde
  private int descuentoIngreso; // Descuento total por ingreso tarde
  private int salidaPuntual; // Cantidad de dias que sale en su horario puntualmente o mas tarde
  private int descuentoSalida; // Descuento total por salida anticipada
  private int inasistencia; // Cantidad de dias que tiene inasistencia
}
