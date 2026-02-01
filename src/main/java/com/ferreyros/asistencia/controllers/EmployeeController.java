package com.ferreyros.asistencia.controllers;

import com.ferreyros.asistencia.models.Employee;
import com.ferreyros.asistencia.services.EmployeeService;

import java.util.Scanner;

public class EmployeeController {

    Scanner scanner = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeService();
    //String code;

    public void list(){
        employeeService.listEmployees();
    }

    public void insert(){

        Employee employee = new Employee();
        System.out.println("Crear nuevo Empleado");
        System.out.println("---------------------");

        System.out.println("Ingresa el codigo de empleado: ");
        employee.setCode(scanner.nextLine());
        //String codigo= scanner.nextLine();

        System.out.println("Ingresa el dni: ");
        employee.setDni(scanner.nextLine());

        System.out.println("Ingresa el nombre: ");
        employee.setName(scanner.nextLine());

        System.out.println("Ingresa el apellido: ");
        employee.setLastName(scanner.nextLine());

        employeeService.insertEmployee(employee);
    }

    public void show(){
        System.out.println("Busca el empleado por codigo");
        System.out.println("Ingrese el codigo de empleado: ");
        employeeService.showEmployee(scanner.nextLine());
    }

    public void selectionOptions() {
        System.out.println("------Escoge las opciones disponibles-----");
        System.out.println("1. Ver lista de empleados");
        System.out.println("2. Buscar Empleado");
        System.out.println("3. Crear nuevo empleado");
        System.out.println("4. Editar datos del empleado");
        System.out.println("5. Registrar asistencia");
        System.out.println("6. Generar reporte");
        System.out.println("7. Salir");
//        String[] numbers = {"1", "2","3", "4", "5"};

        int number = 0;
        while (number != 7) {
            System.out.println("Ingrese la opcion que desea (solo numero ejemplo: 1): ");
            number = Integer.parseInt(scanner.nextLine());

            switch (number) {
                case 1:
                    list();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    insert();
                    break;
                case 4:
                    //updateEmployee();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }

    }

}
