package com.ferreyros.asistencia.models;

import java.time.LocalDateTime;

public class MarkingDetail {

    private int id_marking;
    private int id_attendance;
    private int id_type;
    private LocalDateTime exactTime;



    public int getId_marking() {
        return id_marking;
    }

    public void setId_marking(int id_marking) {
        this.id_marking = id_marking;
    }

    public int getId_attendance() {
        return id_attendance;
    }

    public void setId_attendance(int id_attendance) {
        this.id_attendance = id_attendance;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public LocalDateTime getExactTime() {
        return exactTime;
    }

    public void setExactTime(LocalDateTime exactTime) {
        this.exactTime = exactTime;
    }
}
