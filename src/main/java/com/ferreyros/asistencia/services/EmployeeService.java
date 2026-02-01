package com.ferreyros.asistencia.services;

import com.ferreyros.asistencia.models.Employee;
import com.ferreyros.asistencia.repositories.imp.EmployeeRepositoryImp;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmployeeService {

    Scanner scanner = new Scanner(System.in);
    EmployeeRepositoryImp employeeRepositoryImp = new EmployeeRepositoryImp();
    String code;

    public void insertEmployee(Employee employee) {
        employeeRepositoryImp.save(employee);
    }

    public void listEmployees() {
        employeeRepositoryImp.list();
    }



    public void updateEmployee(){
        //showEmployee();
        Employee employee= listByCodeEmployee(this.code);
        System.out.println("Si no deseas modificar un campo presiona la tecla ENTER para pasar al siguiente");

        System.out.println("Ingresa el dni: ");
        validateFields(scanner.nextLine(), (String s) -> !s.isEmpty(), employee::setDni);

        System.out.println("Ingresa el nombre: ");
        validateFields(scanner.nextLine(), (String s) -> !s.isEmpty(), employee::setName);

        System.out.println("Ingresa el apellido: ");
        validateFields(scanner.nextLine(), (String s) -> !s.isEmpty(), employee::setLastName);

    }

    public Employee listByCodeEmployee(String code){
        return employeeRepositoryImp.listByCode(code);
    }

    public void showEmployee(String code){
        Employee employee;
        if (listByCodeEmployee(code) != null){
            employee = listByCodeEmployee(code);
            System.out.println("CODIGO: " + employee.getCode());
            System.out.println("DNI: " + employee.getDni());
            System.out.println("NOMBRE: " + employee.getName());
            System.out.println("APELLIDO: " + employee.getLastName());
        } else {
            System.out.println("El empleado no se encontro");
        }
    }

    public <T> void validateFields(T value, Predicate<T> validation, Consumer<T> setter){
        if (value != null && validation.test(value)){
            setter.accept(value);
        }
    }
}
