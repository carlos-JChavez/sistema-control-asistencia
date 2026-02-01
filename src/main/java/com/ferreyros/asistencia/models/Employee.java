package com.ferreyros.asistencia.models;

public class Employee extends Person {
    private String code;

    public Employee() {
    }

    public Employee(String code, String dni, String name, String lastName) {
        super(dni,name,lastName);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
