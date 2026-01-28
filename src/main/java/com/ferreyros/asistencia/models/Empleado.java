package com.ferreyros.asistencia.models;

public class Empleado extends Persona{
    private String codigo;

    public Empleado() {
    }

    public Empleado(String codigo, String dni, String nombre, String apellido) {
        super(dni,nombre,apellido);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
