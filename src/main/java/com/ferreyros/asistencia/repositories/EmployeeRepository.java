package com.ferreyros.asistencia.repositories;

import com.ferreyros.asistencia.models.Employee;

public interface EmployeeRepository {

    public Employee listByCode(String code);
    public void list();
    public void save(Employee employee);
    public void update(String code, Employee employee);
}
