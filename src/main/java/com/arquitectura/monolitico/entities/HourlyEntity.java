package com.arquitectura.monolitico.entities;

import java.util.Date;
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user.rut")
  private UserEntity user;

  private Date fecha;
  private Date ingreso;
  private Date salida;
  private int descuentoIngreso;
  private int descuentoSalida;
  private Boolean inasistencia;
}
