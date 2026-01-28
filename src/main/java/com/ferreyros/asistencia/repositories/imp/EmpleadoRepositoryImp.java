package com.ferreyros.asistencia.repositories.imp;

import com.ferreyros.asistencia.models.Empleado;
import com.ferreyros.asistencia.repositories.EmpleadoRepository;

import java.util.ArrayList;

public class EmpleadoRepositoryImp implements EmpleadoRepository {

    ArrayList<Empleado> empleados = new ArrayList<>();

    @Override
    public Empleado listByCode(String codigo) {
        Empleado data = null;
        for (Empleado empleado : empleados){
            if (empleado.getCodigo() != null && empleado.getCodigo().equals(codigo)){
                data= empleado;
                break;
            }
        }
        return data;
    }

    @Override
    public void list() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getCodigo());
            System.out.println(empleado.getDni());
            System.out.println(empleado.getNombre());
            System.out.println(empleado.getApellido());
            System.out.println("_________________");
        }
    }

    @Override
    public void save(Empleado empleado) {
        empleados.add(empleado);
    }

    @Override
    public void update(String codigo,Empleado data) {
        for (Empleado empleado : empleados){
            if (empleado.getCodigo().equals(codigo)){
                empleado.setDni(data.getDni());
                empleado.setNombre(data.getNombre());
                empleado.setApellido(data.getApellido());
            }
        }
    }
}
