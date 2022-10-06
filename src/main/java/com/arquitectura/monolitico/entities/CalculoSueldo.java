package com.arquitectura.monolitico.entities;

import com.arquitectura.monolitico.entities.calculoFacade.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CalculoSueldo {

  public List<SalaryEntity> salario(
    List<Horario> horarios,
    ArrayList<UserEntity> usuarios,
    ArrayList<JustificationEntity> justificativos,
    ArrayList<ExtraHourEntity> horasExtras
  )
    throws ParseException {

    // ------------------------------ Obtengo los rut de los trabajadores
    List<SalaryEntity> salariosRut = RutUser.getRut(horarios);

    // ------------------------------ Obtener sueldo fijo segun categoria y area, detectar tiempo de servicio, sueldo fijo y bono por tiempo
    List<SalaryEntity> salariosBasico = SalarioBasico.getSalarioBasico(salariosRut,usuarios);

    // ------------------------------ Horas Extras
    List<SalaryEntity> salariosExtraHour = ExtraHour.getExtraHour(salariosBasico,horasExtras,horarios);

    // ------------------------------ se detectan descuentos
    List<SalaryEntity> salariosDescuentos = Descuentos.getDescuentos(salariosExtraHour,horarios,justificativos);

    // ------------------------------ Se calculan los descuentos
    List<SalaryEntity> salariosCalculoDescuentos = CalculoDescuentos.getCalculoDescuentos(salariosDescuentos);

    // ------------------------------ Se calcula el sueldo final
    List<SalaryEntity> salariosFinal = SueldoFinal.getSueldoFinal(salariosCalculoDescuentos);

    return salariosFinal;
  }
}
