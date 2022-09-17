package com.arquitectura.monolitico.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

  @Id
  @Column(unique = true, nullable = false)
  private String rut;

  private String apellidos;
  private String nombres;
  private String fechaNacimiento;
  private String categoria;
  private String area;
  private String fechaIngreso;
}
