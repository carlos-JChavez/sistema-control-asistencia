package com.ferreyros;


import com.ferreyros.asistencia.services.EmpleadoService;

public class Main {
    public static void main(String[] args) {

        EmpleadoService empleadoService = new EmpleadoService();
        empleadoService.selectionOptions();
    }
}