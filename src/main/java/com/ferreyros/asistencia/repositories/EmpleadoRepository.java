package com.ferreyros.asistencia.repositories;

import com.ferreyros.asistencia.models.Empleado;

public interface EmpleadoRepository {

    public Empleado listByCode(String codigo);
    public void list();
    public void save(Empleado empleado);
    public void update(String codigo, Empleado empleado);
}
