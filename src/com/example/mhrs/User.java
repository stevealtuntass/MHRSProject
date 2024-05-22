package com.example.mhrs;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    private final String password;
    private final List<Appointment> appointments;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
        this.appointments = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}

