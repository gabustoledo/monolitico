package com.arquitectura.monolitico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "extraHour")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraHourEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  private String user_rut;

  private String fecha;
  private int cantidad;
}
