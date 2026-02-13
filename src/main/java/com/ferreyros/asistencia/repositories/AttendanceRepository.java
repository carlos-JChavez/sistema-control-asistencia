package com.ferreyros.asistencia.repositories;

import com.ferreyros.asistencia.models.Attendance;

import java.util.List;

public interface AttendanceRepository {

    public List<Attendance> list();
    public void listByCode();
    public int save(Attendance attendance);
    public void update(int id, Attendance attendance);
}
