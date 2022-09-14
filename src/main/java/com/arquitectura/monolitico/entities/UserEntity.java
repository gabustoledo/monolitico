package com.arquitectura.monolitico.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

  // @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column(unique = true, nullable = false)
  // private Long id;

  @Id
  @Column(unique = true, nullable = false)
  private String rut;

  private String apellidos;
  private String nombres;
  private Date fechaNacimiento;
  private String categoria;
  private String area;
  private Date fechaIngreso;

  // Relaciones con entidades

  // uno a muchos con mes laboral
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
  private List<MonthEntity> listMonth = new ArrayList<>();

  // uno a muchos con horas extras
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
  private List<ExtraHourEntity> listExtraHour = new ArrayList<>();

  // uno a muchos con justificativo
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
  private List<JustificationEntity> listJustification = new ArrayList<>();

  // uno a muchos con sueldo
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
  private List<SalaryEntity> listSalary = new ArrayList<>();

  // uno a muchos con horario
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
  private List<HourlyEntity> listHourly = new ArrayList<>();
}
