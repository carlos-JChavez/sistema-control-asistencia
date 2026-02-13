package com.ferreyros.asistencia.repositories.imp;

import com.ferreyros.asistencia.config.DatabaseConnection;
import com.ferreyros.asistencia.models.Attendance;
import com.ferreyros.asistencia.repositories.AttendanceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepositoryImp implements AttendanceRepository {

    DatabaseConnection connection= new DatabaseConnection();
    Attendance attendance = null;

    @Override
    public List<Attendance> list() {
        List<Attendance> list= new ArrayList<>();
        try {
            Connection con= connection.connectionDB();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM Asistencia");
            ResultSet result= preparedStatement.executeQuery();
            while (result.next()){
               attendance.setIdEmployee(result.getInt("id_empleado"));
               attendance.setDate(result.getDate("fecha").toLocalDate());
               attendance.setTotalHoursWorked(result.getDouble("total_horas_trabajadas"));
               attendance.setTotalOvertimeHours(result.getDouble("total_horas_extra"));
               attendance.setState(result.getString("estado"));
               list.add(attendance);
            }
        } catch (SQLException e) {
            System.err.println("No se pudo ejecutar la sentencia");
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void listByCode() {

    }

    @Override
    public int save(Attendance attendance) {
        int value= 0;
        try {
            Connection con= connection.connectionDB();
            PreparedStatement ps= con.prepareStatement("INSERT INTO Asistencia \n" +
                    "(id_empleado, fecha, total_horas_trabajadas, total_horas_extra, estado) VALUES (?,?,?,?,?)");

            ps.setInt(1,attendance.getIdEmployee());
            ps.setObject(2,attendance.getDate());
            ps.setDouble(3,attendance.getTotalHoursWorked());
            ps.setDouble(4, attendance.getTotalOvertimeHours());
            ps.setString(5,attendance.getState());
            value= ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    @Override
    public void update(int id, Attendance attendance) {

        try {
            Connection con= connection.connectionDB();
            PreparedStatement ps= con.prepareStatement("UPDATE Asistencia SET total_horas_trabajadas = ?, total_horas_extra = ?, estado = ? WHERE id_asistencia = ?");

            ps.setDouble(1,attendance.getTotalHoursWorked());
            ps.setDouble(2, attendance.getTotalOvertimeHours());
            ps.setString(3, attendance.getState());
            ps.executeUpdate();

        } catch (SQLException e){
            System.err.println("Error: No se pudo actualizar");
        }
    }

}
