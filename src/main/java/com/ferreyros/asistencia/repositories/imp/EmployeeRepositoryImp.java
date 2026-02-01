package com.ferreyros.asistencia.repositories.imp;

import com.ferreyros.asistencia.models.Employee;
import com.ferreyros.asistencia.repositories.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeRepositoryImp implements EmployeeRepository {

    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public Employee listByCode(String code) {
        Employee data = null;
        for (Employee employee : employees){
            if (employee.getCode() != null && employee.getCode().equals(code)){
                data= employee;
                break;
            }
        }
        return data;
    }

    @Override
    public void list() {
        for (Employee employee : employees) {
            System.out.println(employee.getCode());
            System.out.println(employee.getDni());
            System.out.println(employee.getName());
            System.out.println(employee.getLastName());
            System.out.println("_________________");
        }
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void update(String code, Employee data) {
        for (Employee employee : employees){
            if (employee.getCode().equals(code)){
                employee.setDni(data.getDni());
                employee.setName(data.getName());
                employee.setLastName(data.getLastName());
            }
        }
    }
}
