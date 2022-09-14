package com.arquitectura.monolitico.entities;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "extraHour")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraHourEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user.rut")
  private UserEntity user;

  private Date fecha;
  private Boolean completada;
}
