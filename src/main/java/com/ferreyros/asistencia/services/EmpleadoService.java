package com.ferreyros.asistencia.services;

import com.ferreyros.asistencia.models.Empleado;
import com.ferreyros.asistencia.repositories.imp.EmpleadoRepositoryImp;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmpleadoService {

    Scanner scanner = new Scanner(System.in);
    EmpleadoRepositoryImp empleadoRepositoryImp = new EmpleadoRepositoryImp();
    String codigo;

    public void insertEmployee() {
        Empleado empleado = new Empleado();
        System.out.println("Crear nuevo Empleado");
        System.out.println("---------------------");

        System.out.println("Ingresa el codigo de empleado: ");
        empleado.setCodigo(scanner.nextLine());
        //String codigo= scanner.nextLine();

        System.out.println("Ingresa el dni: ");
        empleado.setDni(scanner.nextLine());

        System.out.println("Ingresa el nombre: ");
        empleado.setNombre(scanner.nextLine());

        System.out.println("Ingresa el apellido: ");
        empleado.setApellido(scanner.nextLine());
        //String apellido= scanner.nextLine();

        //Empleado empleado= new Empleado(codigo, dni, nombre, apellido);
        empleadoRepositoryImp.save(empleado);
    }

    public void listEmployees() {
        empleadoRepositoryImp.list();
    }

    public void selectionOptions() {
        System.out.println("------Escoge las opciones disponibles-----");
        System.out.println("1. Ver lista de empleados");
        System.out.println("2. Buscar Empleado");
        System.out.println("3. Crear nuevo empleado");
        System.out.println("4. Editar datos del empleado");
        System.out.println("5. Registrar asistencia");
        System.out.println("6. Generar reporte de asistencia");
        System.out.println("7. Salir");
//        String[] numbers = {"1", "2","3", "4", "5"};

        int number = 0;
        while (number != 7) {
            System.out.println("Ingrese la opcion que desea (solo numero ejemplo: 1): ");
            number = Integer.parseInt(scanner.nextLine());

            switch (number) {
                case 1:
                    listEmployees();
                    break;
                case 2:
                    showEmployee();
                    break;
                case 3:
                    insertEmployee();
                    break;
                case 4:
                    updateEmployee();
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

    public void updateEmployee(){
        showEmployee();
        Empleado empleado= listByCodeEmployee(this.codigo);
        System.out.println("Si no deseas modificar un campo presiona la tecla ENTER para pasar al siguiente");

        System.out.println("Ingresa el dni: ");
        validateFields(scanner.nextLine(), (String s) -> !s.isEmpty(), empleado::setDni);

        System.out.println("Ingresa el nombre: ");
        validateFields(scanner.nextLine(), (String s) -> !s.isEmpty(), empleado::setNombre);

        System.out.println("Ingresa el apellido: ");
        validateFields(scanner.nextLine(), (String s) -> !s.isEmpty(), empleado::setApellido);

    }

    public Empleado listByCodeEmployee(String codigo){
        return empleadoRepositoryImp.listByCode(codigo);
    }

    public void showEmployee(){
        System.out.println("Busca el empleado por codigo");
        System.out.println("Ingrese el codigo de empleado: ");
        this.codigo= scanner.nextLine();
        Empleado empleado;
        if (listByCodeEmployee(this.codigo) != null){
            empleado = listByCodeEmployee(this.codigo);
            System.out.println("CODIGO: " + empleado.getCodigo());
            System.out.println("DNI: " + empleado.getDni());
            System.out.println("NOMBRE: " + empleado.getNombre());
            System.out.println("APELLIDO: " + empleado.getApellido());
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
