package com.ferreyros.asistencia.models;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;

    public Persona() {
    }

    public Persona(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni != null && dni.length() == 8) {
            this.dni = dni;
        }
        else {
            System.err.println("El campo dni deben ser de 8 digitos");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()){
            this.nombre = nombre.trim().toUpperCase();
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()){
            this.apellido = apellido.trim().toUpperCase();
        }
    }
}
