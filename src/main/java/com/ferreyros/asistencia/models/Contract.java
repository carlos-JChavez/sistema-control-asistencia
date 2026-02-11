package com.ferreyros.asistencia.models;

import java.time.LocalDate;

public class Contract {
    private int id_contract;
    private int id_employee;
    private double dailyHoursRequired;
    private int inputTolerance;
    private LocalDate start_date;
    private LocalDate end_date;

    public int getId_contract() {
        return id_contract;
    }

    public void setId_contract(int id_contract) {
        this.id_contract = id_contract;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public double getDailyHoursRequired() {
        return dailyHoursRequired;
    }

    public void setDailyHoursRequired(double dailyHoursRequired) {
        this.dailyHoursRequired = dailyHoursRequired;
    }

    public int getInputTolerance() {
        return inputTolerance;
    }

    public void setInputTolerance(int inputTolerance) {
        this.inputTolerance = inputTolerance;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
}
