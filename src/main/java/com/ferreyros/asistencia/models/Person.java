package com.ferreyros.asistencia.models;

public class Person {
    private String dni;
    private String name;
    private String lastName;

    public Person() {
    }

    public Person(String dni, String name, String lastName) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()){
            this.name = name.trim().toUpperCase();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()){
            this.lastName = lastName.trim().toUpperCase();
        }
    }
}
